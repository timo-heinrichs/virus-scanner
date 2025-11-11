package de.heinrichs.virus_scanner.util;

import de.heinrichs.virus_scanner.dto.FileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FileDTOUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileDTOUtil.class);

    public static int getTotalEngines(FileDTO fileDTO) {
        FileDTO.LastAnalysisStats lar = fileDTO.getData().getAttributes().getLastAnalysisStats();

        int totalEngines = 0;

        try {
            for (Field field : lar.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    totalEngines += (Integer) field.get(lar);
            }
        } catch (IllegalAccessException e) {
            logger.error("Unable to determine TotalEngines from FileDTO, members changed?", new RuntimeException(e));
        }

        return totalEngines;
    }

    public static int getThreatCount(FileDTO fileDTO) {
        FileDTO.LastAnalysisStats lar = fileDTO.getData().getAttributes().getLastAnalysisStats();
        return lar.getSuspicious() + lar.getMalicious();
    }

}
