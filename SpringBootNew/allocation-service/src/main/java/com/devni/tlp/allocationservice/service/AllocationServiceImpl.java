package com.devni.tlp.allocationservice.service;

import com.devni.tlp.allocationservice.model.Allocation;
import com.devni.tlp.allocationservice.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Allocation save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    @Override
    public List<Allocation> fetchAllAllocations() {
        return allocationRepository.findAll();
    }

    @Override
    public Allocation fetchAllocationById(int id) {
        Optional<Allocation> optional = allocationRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Allocation> fetchByEmpId(int empId) {
        Allocation allocation = new Allocation();
        allocation.setEmpId(empId);

        Example<Allocation> example = Example.of(allocation);
        return allocationRepository.findAll(example);
    }
}
