package com.gmail.aba.repository;

import com.gmail.aba.data.IphoneData;
import com.gmail.aba.dto.IphoneDetailsDTO;
import com.gmail.aba.dto.IphoneIdDTO;
import com.gmail.aba.dto.IphoneSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IphoneRepoImpl implements IphoneRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int create(IphoneData iphone) {
        return jdbcTemplate.update("INSERT INTO iphone (name, color, price, fk_iphone) VALUES (?, ?, ?, ?)",
                new Object[] {iphone.getName(), iphone.getColor(), iphone.getPrice(), iphone.getFkIphone()});
    }

    @Override
    public IphoneDetailsDTO readById(int id) {
        return jdbcTemplate.queryForObject("SELECT iphone.iphoneId, name, color, price, appleFactory.factoryId, country FROM iphone LEFT JOIN appleFactory on iphone.fk_iphone = appleFactory.factoryId where iphone.iphoneId = ?",
                new BeanPropertyRowMapper<IphoneDetailsDTO>(IphoneDetailsDTO.class), id);
    }

    @Override
    public int update(IphoneData iphone, int id) {
        return jdbcTemplate.update("UPDATE iphone SET name = ?, color = ?, price = ?, fk_iphone = ? WHERE iphoneId = ?",
                new Object[] {iphone.getName(), iphone.getColor(), iphone.getPrice(), iphone.getFkIphone(), id});
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM iphone WHERE iphoneId=?", id);
    }

    @Override
    public List<IphoneData> searchNameEndColorByLimit(IphoneSearchDTO iphoneSearch) {
        return jdbcTemplate.query("SELECT * FROM iphone WHERE name=? AND color=? LIMIT ?, ?",
                new BeanPropertyRowMapper<IphoneData>(IphoneData.class), iphoneSearch.getName(), iphoneSearch.getColor(), iphoneSearch.getFrom(), iphoneSearch.getSize());
    }
    
    //
    @Override
    public List<IphoneIdDTO> getAllId(){
        return jdbcTemplate.query("SELECT iphoneId FROM iphone",
                new BeanPropertyRowMapper<IphoneIdDTO>(IphoneIdDTO.class));
    }

//    @Override
//    public void deleteAllPhones() {
//        jdbcTemplate.update("DELETE FROM iphone");
//    }

}
