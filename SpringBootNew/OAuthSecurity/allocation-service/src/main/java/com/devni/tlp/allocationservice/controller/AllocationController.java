package com.devni.tlp.allocationservice.controller;

import com.devni.tlp.allocationservice.model.Allocation;
import com.devni.tlp.allocationservice.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alloservice")
public class AllocationController {
    @Autowired
    AllocationService allocationService;

    @RequestMapping("/test")
    public Allocation test() {
        Allocation allocation = new Allocation();
        allocation.setEmpId(1);
        allocation.setId(1);
        allocation.setName("TTTT");
        allocation.setStartDate("2018");
        allocation.setEndDate("2020");

        return allocation;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Allocation save(@RequestBody Allocation allocation) {
        return  allocationService.save(allocation);
    }

    @RequestMapping("/fetchall")
    public List<Allocation> fetchAllAllocations() {
        return allocationService.fetchAllAllocations();
    }

    @RequestMapping("/fetchbyid/{id}")
    public Allocation fetchAllocationById(@PathVariable int id) {
        return allocationService.fetchAllocationById(id);
    }

    @RequestMapping("/fetchby_empid/{empId}")
    public List<Allocation> fetchByEmpId(@PathVariable int empId) {
        return allocationService.fetchByEmpId(empId);
    }
}
