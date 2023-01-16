package com.gmail.aba.controllers;

import com.gmail.aba.data.AppleFactoryData;
import com.gmail.aba.service.AppleFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/factory")
public class AppleFactoryController {

    @Autowired
    AppleFactoryService appleFactoryService;

    @GetMapping("/getAll")
    public List<AppleFactoryData> getListFactories() {
        return appleFactoryService.getListFactories();
    }
}
