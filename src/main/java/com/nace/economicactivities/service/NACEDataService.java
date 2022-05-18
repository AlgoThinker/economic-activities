package com.nace.economicactivities.service;

import com.nace.economicactivities.entity.NACEDataObject;

import java.util.List;

public interface NACEDataService {

     boolean putAllNaceData() throws Exception;

     NACEDataObject getNaceDetailsForOrder(String order);

     List<NACEDataObject> getAllNaceDetails();
}
