package com.devni.tlp.allocation_service.project4_2.repository;

import com.devni.tlp.allocation_service.project4_2.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
    List<Allocation> findByEmpId(int id);
}
