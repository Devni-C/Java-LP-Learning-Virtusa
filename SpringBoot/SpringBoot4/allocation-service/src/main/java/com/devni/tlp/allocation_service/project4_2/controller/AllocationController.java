package com.devni.tlp.allocation_service.project4_2.controller;

import com.devni.tlp.allocation_service.project4_2.model.Allocation;
import com.devni.tlp.allocation_service.project4_2.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allocation_service")
public class AllocationController {
    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/test/allocation")//, produces = MediaType.APPLICATION_JSON_VALUE)
    public Allocation test() {
        Allocation allocation = new Allocation();
        allocation.setId(01);
        allocation.setName("iko");
        allocation.setStart("2027");
        allocation.setEnd("2020");
        allocation.setEmpId(001);

        return allocation;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Allocation saveAllocation(@RequestBody Allocation allocation) {
        return allocationService.saveAllocation(allocation);
    }

    @RequestMapping(value = "/findbyid/{id}")
    public Allocation findById(@PathVariable int id) {
        return allocationService.getAllocationById(id);
    }

    @RequestMapping(value = "/empid/{eid}")
    public List<Allocation> findByEmpId(@PathVariable int eid) {
        return allocationService.getAllocationByEmpId(eid);
    }

}
