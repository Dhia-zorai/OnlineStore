package com.fsb.onlinestore3.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private long id;
    private String code;
    private String name;
    private double price;
    private int quantity;
    private String img;


}
