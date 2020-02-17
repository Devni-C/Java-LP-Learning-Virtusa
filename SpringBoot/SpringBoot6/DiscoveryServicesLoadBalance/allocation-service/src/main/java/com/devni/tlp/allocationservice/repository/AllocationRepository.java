package com.devni.tlp.allocationservice.repository;

import com.devni.tlp.allocationservice.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
    List<Allocation> findByEmpId(int id);
}
