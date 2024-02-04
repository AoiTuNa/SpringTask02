package com.nhnacademy.edu.springframework.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class WaterTariff {
    @JsonProperty("순번")
    private int identifiyNumber;
    @JsonProperty("지자체명")
    private String government;
    @JsonProperty("업종")
    private String usage;
    @JsonProperty("단계")
    private int step;
    @JsonProperty("구간시작(세제곱미터)")
    private int sectorStart;
    @JsonProperty("구간끝(세제곱미터)")
    private int sectorEnd;
    @JsonProperty("구간금액(원)")
    private int sectorBill;
    @Setter
    @JsonProperty("단계별 기본요금(원)")
    private int standardBillByStep;

    public WaterTariff(){
    }
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
