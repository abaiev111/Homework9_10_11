package com.gmail.aba.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IphoneDetailsDTO {

    private Integer iphoneId;
    private String name;
    private String color;
    private String price;

    private Integer factoryId;
    private String country;



}
