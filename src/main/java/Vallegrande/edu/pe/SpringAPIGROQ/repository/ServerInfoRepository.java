package Vallegrande.edu.pe.SpringAPIGROQ.repository;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.ServerInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerInfoRepository  extends MongoRepository<ServerInfo, String> {
}
