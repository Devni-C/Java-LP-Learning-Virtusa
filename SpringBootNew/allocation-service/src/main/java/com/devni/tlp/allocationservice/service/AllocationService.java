package com.devni.tlp.allocationservice.service;

import com.devni.tlp.allocationservice.model.Allocation;

import java.util.List;

public interface AllocationService {

    Allocation save(Allocation allocation);

    List<Allocation> fetchAllAllocations();

    Allocation fetchAllocationById(int id);

    List<Allocation> fetchByEmpId(int empId);
}
