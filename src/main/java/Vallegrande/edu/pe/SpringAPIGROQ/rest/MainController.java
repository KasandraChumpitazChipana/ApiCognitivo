package Vallegrande.edu.pe.SpringAPIGROQ.rest;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.QueryRecord;
import Vallegrande.edu.pe.SpringAPIGROQ.service.GroqCloudService;
import Vallegrande.edu.pe.SpringAPIGROQ.service.QueryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private GroqCloudService groqCloudService;

    @Autowired
    private QueryRecordService queryRecordService;

    /**
     * Ejecuta una consulta en GroqCloud.
     * @param query La consulta que se va a ejecutar.
     * @return Un Mono que emite la respuesta de la consulta.
     */
    @PostMapping("/groq/query")
    public Mono<String> executeQuery(@RequestBody String query) {
        return Mono.just(groqCloudService.executeGroqQuery(query));
    }

    /**
     * Ejecuta una consulta en GroqCloud y almacena el registro en la base de datos.
     * @param query La consulta que se va a ejecutar.
     * @return Un Mono que emite un mapa con el ID y la respuesta.
     */
    @PostMapping("/groq/query-and-store")
    public Mono<Map<String, String>> executeQueryAndStore(@RequestBody String query) {
        return Mono.just(groqCloudService.executeGroqQuery(query))
                .flatMap(result -> {
                    QueryRecord queryRecord = new QueryRecord();
                    queryRecord.setQuery(query);
                    queryRecord.setResponse(result);
                    queryRecord.setTimestamp(new Date());

                    return queryRecordService.saveQueryRecord(queryRecord)
                            .map(savedRecord -> {
                                Map<String, String> responseMap = new HashMap<>();
                                responseMap.put("id", savedRecord.getId());
                                responseMap.put("response", savedRecord.getResponse());
                                return responseMap;
                            });
                });
    }

    /**
     * Obtiene todos los registros de consultas almacenados, mostrando solo el ID y la respuesta.
     * @return Un Flux que emite una lista de mapas con el ID y la respuesta.
     */
    @GetMapping("/query-records")
    public Flux<Map<String, String>> getAllQueryRecords() {
        return queryRecordService.getAllQueryRecords()
                .map(record -> {
                    Map<String, String> responseMap = new HashMap<>();
                    responseMap.put("id", record.getId());
                    responseMap.put("response", record.getResponse());
                    return responseMap;
                });
    }

    /**
     * Obtiene un registro de consulta por su ID y muestra solo el ID y la respuesta.
     * @param id El ID del registro a buscar.
     * @return Un Mono que emite un mapa con el ID y la respuesta.
     */
    @GetMapping("/query-records/{id}")
    public Mono<ResponseEntity<Map<String, String>>> getQueryRecordById(@PathVariable String id) {
        return queryRecordService.getQueryRecordById(id)
                .map(record -> {
                    Map<String, String> responseMap = new HashMap<>();
                    responseMap.put("id", record.getId());
                    responseMap.put("response", record.getResponse());
                    return ResponseEntity.ok(responseMap);
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
