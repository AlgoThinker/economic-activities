package com.nace.economicactivities.util;

import com.nace.economicactivities.entity.NACEDataObject;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.util.List;

@Component
@Log4j2
public class CSVOperations {
    public List<NACEDataObject> readAll() throws Exception {
        List<NACEDataObject> objectList;
        try {
            objectList = new CsvToBeanBuilder(new FileReader(Constants.filePath))
                    .withType(NACEDataObject.class).build().parse();
        }catch (Exception e){
            log.error("readAll() : Error occurred while reading NACE CSV file");
            throw e;
        }
        return objectList;
    }
}
