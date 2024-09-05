package Vallegrande.edu.pe.SpringAPIGROQ.repository;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.QueryRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QueryRecordRepository extends MongoRepository<QueryRecord, String> {
}
