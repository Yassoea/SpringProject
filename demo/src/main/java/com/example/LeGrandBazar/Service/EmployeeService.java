package com.example.LeGrandBazar.Service;

import com.example.LeGrandBazar.Repository.EmployeeRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



}
