package com.DtoValidationSpring.DTOValidation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DtoValidationSpring.DTOValidation.DTO.DashboardResponseDTO;
import com.DtoValidationSpring.DTOValidation.service.DashboardService;

@RestController
@RequestMapping("/api/dashboardstats")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/summary")
    public DashboardResponseDTO getDashboard(@RequestParam Long userId) {
        return dashboardService.getDashboardSummary(userId);
    }
}

