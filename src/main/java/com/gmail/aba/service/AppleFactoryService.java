package com.gmail.aba.service;

import com.gmail.aba.data.AppleFactoryData;
import com.gmail.aba.repository.AppleFactoryRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppleFactoryService {

    @Autowired
    AppleFactoryRepoImpl appleFactoryRepo;

    public List<AppleFactoryData> getListFactories() {
        return appleFactoryRepo.getListFactories();
    }



}
