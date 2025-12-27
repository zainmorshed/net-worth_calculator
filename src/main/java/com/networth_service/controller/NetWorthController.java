package com.networth_service.controller;

import com.networth_service.dto.NetWorthResponse;
import com.networth_service.service.NetWorthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/networth")
public class NetWorthController {
    
    private final NetWorthService netWorthService;
    
    public NetWorthController(NetWorthService netWorthService) {
        this.netWorthService = netWorthService;
    }
    
    @GetMapping
    public NetWorthResponse getNetWorth(
            @RequestParam String user,
            @RequestHeader(value = "Authorization",required = false) String authorization) {
        
        // // Extract bearer token from "Bearer <token>"
        // String bearerToken = authorization.replace("Bearer ", "");
        
        return netWorthService.calculateNetWorth(user, authorization);
    }
}