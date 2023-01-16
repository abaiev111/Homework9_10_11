package com.gmail.aba.controllers;

import com.gmail.aba.data.IphoneData;
import com.gmail.aba.dto.*;
import com.gmail.aba.service.IphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/iphone")
public class IphoneController {

    @Autowired
    IphoneService iphoneService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse create(@RequestBody IphoneData iphone) {
        iphoneService.createIphone(iphone);
        return new RestResponse("Created");
    }

    @GetMapping("/{id}")
    public IphoneDetailsDTO getIphone(@PathVariable int id) {
        return iphoneService.getIphoneById(id);
    }

    @PutMapping("/update/{id}")
    public RestResponse updateIphone(@RequestBody IphoneData iphone, @PathVariable int id) {

        return new RestResponse(iphoneService.updateIphone(iphone, id));
    }

    @DeleteMapping("/delete/{id}")
    public RestResponse deleteIphoneById(@PathVariable int id) {
        return new RestResponse(iphoneService.deleteIphoneById(id));
    }

    @PostMapping("/_search")
    public List<IphoneData> searchNameEndColorByLimit(@RequestBody IphoneSearchDTO searchDTO) {
        return iphoneService.searchNameEndColorByLimit(searchDTO);
    }
}
