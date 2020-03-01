package com.devni.tlp.rentcloud.profileservice.repository;

import com.devni.tlp.rentcloud.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
