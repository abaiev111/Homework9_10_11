package com.gmail.aba.repository;

import com.gmail.aba.data.AppleFactoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppleFactoryRepoImpl implements AppleFactoryRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<AppleFactoryData> getListFactories() {
        return jdbcTemplate.query("SELECT * FROM appleFactory", new BeanPropertyRowMapper<AppleFactoryData>(AppleFactoryData.class));
    }
}
