package com.nace.economicactivities.controller;

import com.nace.economicactivities.entity.NACEDataObject;
import com.nace.economicactivities.service.impl.NACEDataServiceImpl;
import com.nace.economicactivities.util.Constants;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class NACEDataController {

    @Autowired
    NACEDataServiceImpl service;

    @ApiOperation(value = "Populate DB with the NACE data ")
    @GetMapping("/putNaceDetails")
    public ResponseEntity<String> putNaceDetails() throws Exception {
        if (service.putAllNaceData()) {
            return ResponseEntity.status(HttpStatus.OK).body(Constants.savedSuccess);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.unableToSave);
    }

    @ApiOperation(value = "Get NACE Data for a particular Order ")
    @GetMapping("/getNaceDetails/{order}")
    public ResponseEntity<Object> getNaceDetails(@PathVariable String order) throws Exception {
        try {
            NACEDataObject naceDataObject = service.getNaceDetailsForOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body(naceDataObject);
        }catch (Exception e){
            log.error( "Exception occurred : "+ e );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @ApiOperation(value = "Get all NACE Data ")
    @GetMapping("/getNaceDetails")
    public ResponseEntity<Object> getAllNaceDetails() throws Exception {
        try {
            List<NACEDataObject> objectList = service.getAllNaceDetails();
            return ResponseEntity.status(HttpStatus.OK).body(objectList);
        }catch (Exception e){
            log.error( "Exception occurred : "+ e );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
