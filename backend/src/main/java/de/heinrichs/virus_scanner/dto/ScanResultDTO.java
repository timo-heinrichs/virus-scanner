package de.heinrichs.virus_scanner.dto;

import de.heinrichs.virus_scanner.constants.ScanType;
import de.heinrichs.virus_scanner.constants.ThreatLevel;
import lombok.Data;

@Data
public class ScanResultDTO {

    private String id;

    private String name;

    private String sha256;

    private ScanType scanType;

    private Integer totalEngines;

    private Integer threatCount;

    private ThreatLevel verdict;

    private Long lastAnalysisDate;

}
