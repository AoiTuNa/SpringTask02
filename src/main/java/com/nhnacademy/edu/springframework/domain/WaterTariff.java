package com.nhnacademy.edu.springframework.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
public class WaterTariff {
    private final int identifiyNumber;
    private final String government;
    private final String usage;
    private final int step;
    private final int sectorStart;
    private final int sectorEnd;
    private final int sectorBill;
    @Setter
    private int standardBillByStep;

    public WaterTariff(int identifiyNumber, String government, String usage, int step,
                       int sectorStart, int sectorEnd, int sectorBill) {
        this.identifiyNumber = identifiyNumber;
        this.government = government;
        this.usage = usage;
        this.step = step;
        this.sectorStart = sectorStart;
        this.sectorEnd = sectorEnd;
        this.sectorBill = sectorBill;
    }
    @Override
    public String toString(){
        return "Tariff 순번"+getIdentifiyNumber() + "지자체명 :"+ getGovernment() + "업종 :" +getUsage() + "단계"
                + getStep() +" 구간시작 : "+getSectorStart() + "구간종료 : "+getSectorEnd() + "단계별 기본요금 : "+ getStandardBillByStep();
    }
}
