package com.devni.tlp.allocationservice.service;

import com.devni.tlp.allocationservice.model.Allocation;

import java.util.List;

public interface AllocationService {
    List<Allocation> fetchAllAllocations();

    Allocation saveAllocation(Allocation allocation);

    Allocation getAllocationById(int id);

    List<Allocation> getAllocationByEmpId(int id);
}
