package com.gmail.aba.repository;

import com.gmail.aba.data.IphoneData;
import com.gmail.aba.dto.IphoneDetailsDTO;
import com.gmail.aba.dto.IphoneIdDTO;
import com.gmail.aba.dto.IphoneSearchDTO;

import java.util.List;

public interface IphoneRepo {

    public int create(IphoneData iphone);
    public IphoneDetailsDTO readById(int id);
    public int update(IphoneData iphone, int id);
    public int deleteById(int id);
    public List<IphoneData> searchNameEndColorByLimit(IphoneSearchDTO iphoneSearch);
    public List<IphoneIdDTO> getAllId();


//    public void deleteAllPhones();



}
