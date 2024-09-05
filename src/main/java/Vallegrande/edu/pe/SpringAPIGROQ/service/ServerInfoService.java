package Vallegrande.edu.pe.SpringAPIGROQ.service;

import Vallegrande.edu.pe.SpringAPIGROQ.Model.ServerInfo;
import Vallegrande.edu.pe.SpringAPIGROQ.repository.ServerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerInfoService {

    @Autowired
    private ServerInfoRepository serverInfoRepository;

    public ServerInfo saveServerInfo(ServerInfo serverInfo) {
        return serverInfoRepository.save(serverInfo);
    }

    public List<ServerInfo> getAllServerInfo() {
        return serverInfoRepository.findAll();
    }

    public ServerInfo getServerInfoById(String id) {
        return serverInfoRepository.findById(id).orElse(null);
    }
}