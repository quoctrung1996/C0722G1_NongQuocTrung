package com.example.service;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFacilityService extends IService<Facility> {
    Page<Facility> search( String name, String facilityTypeId, Pageable pageable);

}
