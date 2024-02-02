package com.nhnacademy.edu.springframework.domain;


public class WaterTariff {
    private int identifiyNumber;
    private String government;
    private String usage;
    private int step;
    private int sectorStart;
    private int sectorEnd;
    private  int sectorBill;
    private int standardBillByStep;

    public WaterTariff(int identifiyNumber, String government, String usage, int step,
                       int sectorStart, int sectorEnd, int sectorBill, int standardBillByStep){
        this.identifiyNumber = identifiyNumber;
        this.government = government;
        this.usage = usage;
        this.step = step;
        this.sectorStart = sectorStart;
        this.sectorEnd = sectorEnd;
        this.sectorBill = sectorBill;
        this.standardBillByStep = standardBillByStep;

    }

}
