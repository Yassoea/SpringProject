package com.example.LeGrandBazar.Entity;

import lombok.Getter;

@Getter

public enum EmployeeType {
    SECURITY("Security"),
    SELLER("Seller"),
    VOLUNTEER("Volunteer"),
    CLEANER("Cleaner"),
    CASHIER("Cashier"),
    MANAGER("Manager"),
    OTHER("Other");

    private final String type;

    EmployeeType(String type) {
        this.type = type;
    }

}