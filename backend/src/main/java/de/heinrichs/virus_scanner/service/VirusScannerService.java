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

@Service
public class VirusScannerService {

    private static final Logger logger = LoggerFactory.getLogger(VirusScannerConfiguration.class);

    @Autowired
    VirusTotalAPIClient vtac;

    @Autowired
    ScanResultDTOFactory srdf;

    public ScanResultDTO scanMD5(String md5) {
        FileDTO fileDTO = vtac.getFileReportByHash(md5);

        ScanResultDTO scanResultDTO = srdf.fromFileDTO(fileDTO);
        scanResultDTO.setScanType(ScanType.FILE_HASH);

        return scanResultDTO;
    }

}
