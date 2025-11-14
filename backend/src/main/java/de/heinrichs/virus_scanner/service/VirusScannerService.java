package de.heinrichs.virus_scanner.service;

import de.heinrichs.virus_scanner.config.VirusScannerConfiguration;
import de.heinrichs.virus_scanner.constants.ScanType;
import de.heinrichs.virus_scanner.dto.FileDTO;
import de.heinrichs.virus_scanner.dto.ScanResultDTO;
import de.heinrichs.virus_scanner.factory.ScanResultDTOFactory;
import de.heinrichs.virus_scanner.integration.virustotal.VirusTotalAPIClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VirusScannerService {

    private static final Logger logger = LoggerFactory.getLogger(VirusScannerConfiguration.class);

    @Autowired
    private VirusTotalAPIClient vtac;

    @Autowired
    private ScanResultDTOFactory srdf;

    public ScanResultDTO scanSHA256(String sha256) {
        FileDTO fileDTO = vtac.getFileReportBySHA256(sha256);

        ScanResultDTO scanResultDTO = srdf.fromFileDTO(fileDTO);
        scanResultDTO.setId(UUID.randomUUID().toString());
        scanResultDTO.setScanType(ScanType.FILE_HASH);

        return scanResultDTO;
    }

}
