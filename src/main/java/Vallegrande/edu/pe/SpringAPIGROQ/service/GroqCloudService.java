package Vallegrande.edu.pe.SpringAPIGROQ.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class GroqCloudService {

    @Value("${groqcloud.api.key}")
    private String apiKey;

    @Value("${groqcloud.api.endpoint}")
    private String endpoint;

    private final RestTemplate restTemplate = new RestTemplate();

    public String executeGroqQuery(String query) {
        try {
            Map<String, Object> requestBodyMap = new HashMap<>();
            requestBodyMap.put("model", "mixtral-8x7b-32768");

            List<Map<String, String>> messages = new ArrayList<>();
            messages.add(Map.of("role", "user", "content", query));
            requestBodyMap.put("messages", messages);

            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(requestBodyMap);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", apiKey);
            headers.set("Content-Type", "application/json");

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al ejecutar la consulta: " + e.getMessage();
        }
    }
}