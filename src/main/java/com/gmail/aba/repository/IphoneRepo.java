package com.gmail.aba.repository;

import com.gmail.aba.data.IphoneData;
import com.gmail.aba.dto.IphoneDetailsDTO;
import com.gmail.aba.dto.IphoneIdDTO;
import com.gmail.aba.dto.IphoneSearchDTO;

import java.util.List;

public interface IphoneRepo {

    int create(IphoneData iphone);
    IphoneDetailsDTO readById(int id);
    int update(IphoneData iphone, int id);
    int deleteById(int id);
    List<IphoneData> searchNameEndColorByLimit(IphoneSearchDTO iphoneSearch);
    List<IphoneIdDTO> getAllId();

}
