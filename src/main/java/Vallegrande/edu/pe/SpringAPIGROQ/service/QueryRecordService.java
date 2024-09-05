package Vallegrande.edu.pe.SpringAPIGROQ.service;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.QueryRecord;
import Vallegrande.edu.pe.SpringAPIGROQ.repository.QueryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryRecordService {

    @Autowired
    private QueryRecordRepository queryRecordRepository;

    public QueryRecord saveQueryRecord(QueryRecord queryRecord) {
        return queryRecordRepository.save(queryRecord);
    }

    public List<QueryRecord> getAllQueryRecords() {
        return queryRecordRepository.findAll();
    }

    public QueryRecord getQueryRecordById(String id) {
        return queryRecordRepository.findById(id).orElse(null);
    }
}