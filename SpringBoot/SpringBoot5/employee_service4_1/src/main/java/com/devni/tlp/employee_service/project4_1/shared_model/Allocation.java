package com.devni.tlp.employee_service.project4_1.shared_model;

import lombok.Data;

@Data
public class Allocation {
    Integer id;
    String name;
    String startDate;
    String endDate;

    Allocation[] allocations;
}
