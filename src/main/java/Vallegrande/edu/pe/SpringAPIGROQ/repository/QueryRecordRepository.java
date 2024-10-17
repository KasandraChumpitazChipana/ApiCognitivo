package Vallegrande.edu.pe.SpringAPIGROQ.repository;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.QueryRecord;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRecordRepository extends ReactiveMongoRepository<QueryRecord, String> {
}
