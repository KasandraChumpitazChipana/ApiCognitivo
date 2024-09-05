package Vallegrande.edu.pe.SpringAPIGROQ.Controller;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.ServerInfo;
import Vallegrande.edu.pe.SpringAPIGROQ.Model.QueryRecord;
import Vallegrande.edu.pe.SpringAPIGROQ.service.ServerInfoService;
import Vallegrande.edu.pe.SpringAPIGROQ.service.QueryRecordService;
import Vallegrande.edu.pe.SpringAPIGROQ.service.GroqCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private GroqCloudService groqCloudService;

    @Autowired
    private ServerInfoService serverInfoService;

    @Autowired
    private QueryRecordService queryRecordService;

    @PostMapping("/groq/query")
    public ResponseEntity<String> executeQuery(@RequestBody String query) {
        String result = groqCloudService.executeGroqQuery(query);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/groq/query-and-store")
    public ResponseEntity<QueryRecord> executeQueryAndStore(@RequestBody String query) {
        String result = groqCloudService.executeGroqQuery(query);

        QueryRecord queryRecord = new QueryRecord();
        queryRecord.setQuery(query);
        queryRecord.setResponse(result);
        queryRecord.setTimestamp(new Date());

        QueryRecord savedRecord = queryRecordService.saveQueryRecord(queryRecord);

        return ResponseEntity.ok(savedRecord);
    }

    @PostMapping("/server-info")
    public ResponseEntity<ServerInfo> saveServerInfo(@RequestBody ServerInfo serverInfo) {
        ServerInfo savedInfo = serverInfoService.saveServerInfo(serverInfo);
        return ResponseEntity.ok(savedInfo);
    }

    @GetMapping("/server-info")
    public ResponseEntity<List<ServerInfo>> getAllServerInfo() {
        List<ServerInfo> serverInfoList = serverInfoService.getAllServerInfo();
        return ResponseEntity.ok(serverInfoList);
    }

    @GetMapping("/server-info/{id}")
    public ResponseEntity<ServerInfo> getServerInfoById(@PathVariable String id) {
        ServerInfo serverInfo = serverInfoService.getServerInfoById(id);
        if (serverInfo != null) {
            return ResponseEntity.ok(serverInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/query-records")
    public ResponseEntity<List<QueryRecord>> getAllQueryRecords() {
        List<QueryRecord> queryRecords = queryRecordService.getAllQueryRecords();
        return ResponseEntity.ok(queryRecords);
    }

    @GetMapping("/query-records/{id}")
    public ResponseEntity<QueryRecord> getQueryRecordById(@PathVariable String id) {
        QueryRecord queryRecord = queryRecordService.getQueryRecordById(id);
        if (queryRecord != null) {
            return ResponseEntity.ok(queryRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}