package de.heinrichs.virus_scanner.controller;

import de.heinrichs.virus_scanner.dto.ScanResultDTO;
import de.heinrichs.virus_scanner.service.VirusScannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class VirusScannerController {

    private static final Logger logger = LoggerFactory.getLogger(VirusScannerController.class);

    @Autowired
    private VirusScannerService vss;

    @GetMapping("/scan/file")
    public ScanResultDTO scanFile(@RequestParam String sha256) {
        ScanResultDTO srd = vss.scanSHA256(sha256);
        srd.setId(UUID.randomUUID().toString());

        return srd;
    }

}
