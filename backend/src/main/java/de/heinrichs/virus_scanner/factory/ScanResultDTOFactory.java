package de.heinrichs.virus_scanner.factory;

import de.heinrichs.virus_scanner.constants.ThreatLevel;
import de.heinrichs.virus_scanner.dto.FileDTO;
import de.heinrichs.virus_scanner.dto.ScanResultDTO;
import de.heinrichs.virus_scanner.util.FileDTOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScanResultDTOFactory {

    private static final Logger logger = LoggerFactory.getLogger(ScanResultDTOFactory.class);

    public ScanResultDTO fromFileDTO(FileDTO fileDTO) {
        FileDTO.Attributes attr = fileDTO.getData().getAttributes();

        return new ScanResultDTO() {{
            setId(attr.getMeaningfulName());
            setMd5Hash(attr.getMd5());
            setTotalEngines(FileDTOUtil.getTotalEngines(fileDTO));
            setThreatCount(FileDTOUtil.getThreatCount(fileDTO));
            setLastAnalysisDate(attr.getLastAnalysisDate());
            setVerdict(getThreatVerdict(fileDTO));
        }};
    }

    private ThreatLevel getThreatVerdict(FileDTO fileDTO) {
        FileDTO.LastAnalysisStats las = fileDTO.getData().getAttributes().getLastAnalysisStats();

        if (las == null)
            return ThreatLevel.UNKNOWN;

        if (las.getMalicious() > 0)
            return ThreatLevel.MALICIOUS;

        if (las.getSuspicious() > 0)
            return ThreatLevel.SUSPICIOUS;

        if (las.getHarmless() > 0)
            return ThreatLevel.HARMLESS;

        return ThreatLevel.UNKNOWN;
    }

}
