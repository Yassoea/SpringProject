package com.example.LeGrandBazar.Controller;

import com.example.LeGrandBazar.Entity.Stand;
import com.example.LeGrandBazar.Service.StandService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
@NoArgsConstructor
@RequestMapping("/stands")
public class StandController {

    private StandService standService;

    @Autowired
    public StandController(StandService standService) {
        this.standService = standService;
    }

    @GetMapping("/{id}")
    public Stand getStandById(@PathVariable Long id) {
        return standService.getStandById(id);
    }

    @PostMapping("/add")
    public Stand addStand(@RequestBody Stand stand) {
        return standService.addStand(stand);
    }

    @PostMapping("/{standId}/employees/add/{employeeId}")
    public Stand addEmployeeToStand(@PathVariable Long standId, @PathVariable Long employeeId) {
        return standService.addEmployeeToStand(standId, employeeId);
    }

    @GetMapping("/{id}/profit")
    public double calculateStandProfit(@PathVariable Long id) {
        return standService.calculateStandProfit(id);
    }

}
