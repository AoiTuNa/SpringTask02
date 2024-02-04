package com.nhnacademy.edu.springframework.domain;

import lombok.Getter;

@Getter
public class WaterBill {
    private final String city;
    private final String sector;
    private final int unitPrice;
    private final int billTotal;

    public WaterBill(String city,String sector,int unitPrice, int billTotal){
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
        this.billTotal = billTotal;
    }

    @Override
    public String toString(){
        return "WaterBill{city='"+city+"', sector='"+sector+"', unitPrice="+unitPrice+"', billTotal="+billTotal+"}";
    }
}
