package com.devni.tlp.allocationservice.repository;

import com.devni.tlp.allocationservice.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
}
