package com.nace.economicactivities.service.impl;

import com.nace.economicactivities.entity.NACEDataObject;
import com.nace.economicactivities.repos.NACEDataRepository;
import com.nace.economicactivities.service.NACEDataService;
import com.nace.economicactivities.util.CSVOperations;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class NACEDataServiceImpl implements NACEDataService {

    @Autowired
    NACEDataRepository repository;

    @Autowired
    CSVOperations csvOperations;

    @Override
    public boolean putAllNaceData() throws Exception {
        List<NACEDataObject> list = csvOperations.readAll();
        try {
            repository.saveAll(list);
            return true;
        } catch (Exception e) {
            log.error("putAllNaceData() :  Exception occurred  :  " + e);
        }
        return false;
    }

    @Override
    public NACEDataObject getNaceDetailsForOrder(String order) {
        return repository.findById(order).orElseThrow(()-> new RuntimeException("Data not found for Order : "+ order));
    }

    @Override
    public List<NACEDataObject> getAllNaceDetails() {
        return repository.findAll();
    }
}
