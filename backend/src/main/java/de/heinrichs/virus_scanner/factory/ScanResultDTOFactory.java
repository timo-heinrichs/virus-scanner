package de.heinrichs.virus_scanner.factory;

import de.heinrichs.virus_scanner.constants.ScanResultType;
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
            setScanResultType(ScanResultType.FILE_HASH);
            setTotalEngines(FileDTOUtil.getTotalEngines(fileDTO));
            setThreatCount(FileDTOUtil.getThreatCount(fileDTO));
            setVerdict(attr.getThreatVerdict());
            setLastAnalysisDate(attr.getLastAnalysisDate());
        }};
    }

}
