package com.gmail.aba.data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class IphoneData {

    private Integer iphoneId;
    private String name;
    private String color;
    private String price;
    private Integer fkIphone;

    public IphoneData(String name, String color, String price, Integer fkIphone) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.fkIphone = fkIphone;
    }
}
