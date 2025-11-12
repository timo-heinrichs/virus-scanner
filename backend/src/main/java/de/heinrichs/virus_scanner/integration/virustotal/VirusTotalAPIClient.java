package de.heinrichs.virus_scanner.integration.virustotal;

import de.heinrichs.virus_scanner.dto.FileDTO;
import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static de.heinrichs.virus_scanner.util.StringUtils.*;

/**
 * VirusTotalAPIClient integrates some of the
 * VirusTotalAPI V3 = <a href="https://docs.virustotal.com/reference/overview">...</a> endpoints
 *
 * An API key has to be provided via a spring configuration file using virustotal.api.key
 */
@Component
public class VirusTotalAPIClient {

    private static final Logger logger = LoggerFactory.getLogger(VirusTotalAPIClient.class);

    @Value("${virustotal.api.url}")
    private String apiBaseURL;
    @Value("${virustotal.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    private HttpHeaders headers;

    @PostConstruct
    private void init() {
        headers = new HttpHeaders();
        headers.set("x-apikey", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
    };

    //GET APIs
    private static final String API_GET_FILE_REPORT = "/files/{fileHash}";

    public FileDTO getFileReportBySHA256(String fileHash) {
        HttpEntity<FileDTO> entity = new HttpEntity<FileDTO>(headers);

        ResponseEntity<FileDTO> response = restTemplate.exchange(
                joinURLs(apiBaseURL, API_GET_FILE_REPORT),
                HttpMethod.GET,
                entity,
                FileDTO.class,
                fileHash
        );

        return response.getBody();
    }

}
