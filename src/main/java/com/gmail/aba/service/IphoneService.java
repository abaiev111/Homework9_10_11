package com.gmail.aba.service;

import com.gmail.aba.data.IphoneData;
import com.gmail.aba.dto.IphoneDetailsDTO;
import com.gmail.aba.dto.IphoneIdDTO;
import com.gmail.aba.dto.IphoneSearchDTO;
import com.gmail.aba.repository.IphoneRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IphoneService {

    @Autowired
    IphoneRepoImpl iphoneRepo;

    public int createIphone(IphoneData iphone) {
        return iphoneRepo.create(iphone);
    }

    public IphoneDetailsDTO getIphoneById(int id) {
        return iphoneRepo.readById(id);
    }


    public String updateIphone(IphoneData iphone, int id) {
        String message = "method 'updateIphone': id not found";
        List<IphoneIdDTO> iphoneIDDTO = iphoneRepo.getAllId();

        for(IphoneIdDTO iddto : iphoneIDDTO) {
            if (iddto.getIphoneId().equals(id)) {
                iphoneRepo.update(iphone, id);
                message = "Iphone updated";
                break;
            }
        }
        return message;
    }

    public String deleteIphoneById(int id) {
        String message = "method 'deleteIphoneById': id not found";
        List<IphoneIdDTO> iphoneIDDTO = iphoneRepo.getAllId();

        for(IphoneIdDTO iddto : iphoneIDDTO) {
            if (iddto.getIphoneId().equals(id)) {
                iphoneRepo.deleteById(id);
                message = "Iphone deleted from the database";
                break;
            }
        }
        return message;
    }

    public List<IphoneData> searchNameEndColorByLimit(IphoneSearchDTO iphoneSearch) {
        return iphoneRepo.searchNameEndColorByLimit(iphoneSearch);
    }
}
