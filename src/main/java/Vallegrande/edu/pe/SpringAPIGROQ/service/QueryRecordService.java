package Vallegrande.edu.pe.SpringAPIGROQ.service;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.QueryRecord;
import Vallegrande.edu.pe.SpringAPIGROQ.repository.QueryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QueryRecordService {

    @Autowired
    private QueryRecordRepository queryRecordRepository;

    /**
     * Guarda un nuevo registro de consulta en la base de datos.
     * @param queryRecord El registro de consulta a guardar.
     * @return Un Mono que emite el registro guardado.
     */
    public Mono<QueryRecord> saveQueryRecord(QueryRecord queryRecord) {
        return queryRecordRepository.save(queryRecord);
    }

    /**
     * Obtiene todos los registros de consulta de la base de datos.
     * @return Un Flux que emite una lista de registros de consulta.
     */
    public Flux<QueryRecord> getAllQueryRecords() {
        return queryRecordRepository.findAll();
    }

    /**
     * Obtiene un registro de consulta específico por su ID.
     * @param id El ID del registro a buscar.
     * @return Un Mono que emite el registro encontrado o vacío si no existe.
     */
    public Mono<QueryRecord> getQueryRecordById(String id) {
        return queryRecordRepository.findById(id);
    }
}
