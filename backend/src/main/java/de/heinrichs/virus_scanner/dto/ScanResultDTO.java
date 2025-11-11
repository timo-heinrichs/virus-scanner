package de.heinrichs.virus_scanner.dto;

import de.heinrichs.virus_scanner.constants.ScanResultType;
import lombok.Data;

@Data
public class ScanResultDTO {

    private String id;

    private String md5Hash;

    private ScanResultType scanResultType;

    private Integer totalEngines;

    private Integer threatCount;

    private String verdict;

    private Long lastAnalysisDate;

}
