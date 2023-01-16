package com.gmail.aba.configure;

import com.gmail.aba.repository.AppleFactoryRepoImpl;
import com.gmail.aba.repository.IphoneRepoImpl;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestDataBean {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void fillData() {
        jdbcTemplate.update("insert into appleFactory (country) values ('China')");
        jdbcTemplate.update("insert into appleFactory (country) values ('USA')");
        jdbcTemplate.update("insert into appleFactory (country) values ('Europe')");

        for (int i = 0; i < 5; i++) {
            jdbcTemplate.update("INSERT INTO iphone (name, color, price, fk_iphone) VALUES ('iphone13', 'black', '37,000', 1)");
            jdbcTemplate.update("INSERT INTO iphone (name, color, price, fk_iphone) VALUES ('iphone12', 'white', '37,000', 1)");
            jdbcTemplate.update("INSERT INTO iphone (name, color, price, fk_iphone) VALUES ('iphone13', 'black', '37,000', 2)");
            jdbcTemplate.update("INSERT INTO iphone (name, color, price, fk_iphone) VALUES ('iphone12', 'white', '37,000', 2)");
            jdbcTemplate.update("INSERT INTO iphone (name, color, price, fk_iphone) VALUES ('iphone13', 'black', '37,000', 3)");
            jdbcTemplate.update("INSERT INTO iphone (name, color, price, fk_iphone) VALUES ('iphone12', 'white', '37,000', 3)");
        }
    }
}



