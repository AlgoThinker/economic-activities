package com.nace.economicactivities.repos;

import com.nace.economicactivities.entity.NACEDataObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NACEDataRepository extends JpaRepository<NACEDataObject, String> {
}
