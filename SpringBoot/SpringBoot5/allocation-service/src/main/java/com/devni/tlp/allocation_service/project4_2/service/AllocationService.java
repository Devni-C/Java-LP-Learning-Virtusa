package com.devni.tlp.allocation_service.project4_2.service;

import com.devni.tlp.allocation_service.project4_2.model.Allocation;

import java.util.List;

public interface AllocationService {
    List<Allocation> fetchAllAllocations();

    Allocation saveAllocation(Allocation allocation);

    Allocation getAllocationById(int id);

    List<Allocation> getAllocationByEmpId(int id);
}
