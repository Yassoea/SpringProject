package com.example.LeGrandBazar.Service;

import com.example.LeGrandBazar.Entity.Employee;
import com.example.LeGrandBazar.Entity.Stand;
import com.example.LeGrandBazar.Entity.item;
import com.example.LeGrandBazar.Repository.EmployeeRepository;
import com.example.LeGrandBazar.Repository.StandRepository;
import com.example.LeGrandBazar.Repository.itemRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Getter
@Setter
public class StandService {

    private StandRepository standRepository;
    private EmployeeRepository employeeRepository;
    private itemRepository itemRepository;

    @Autowired
    public StandService(StandRepository standRepository, EmployeeRepository employeeRepository, itemRepository itemRepository) {
        this.standRepository = standRepository;
        this.employeeRepository = employeeRepository;
        this.itemRepository = itemRepository;
    }

    public Stand getStandById(Long id) {
        return standRepository.findById(id).orElse(null);
    }

    public Stand addStand(Stand stand) {
        return standRepository.save(stand);
    }

    public double calculateStandProfit(Long id) {
        Stand stand = standRepository.findById(id).orElse(null);
        if (stand != null) {
            List<item> itemsSold = stand.getItemsSold();
            double totalProfit = 0.0;
            for (item item : itemsSold) {
                totalProfit += item.getPrice();
            }
            return totalProfit;
        }
        return 0.0;
    }

    public Stand addEmployeeToStand(Long standId, Long employeeId) {
        Stand stand = standRepository.findById(standId).orElse(null);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (stand != null && employee != null) {
            stand.getEmployees().add(employee);
            return standRepository.save(stand);
        } else {
            throw new NoSuchElementException("Stand or employee not found");
        }
    }
}
