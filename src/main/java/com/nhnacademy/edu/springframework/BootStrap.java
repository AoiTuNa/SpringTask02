package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.configuration.MainConfig;
import com.nhnacademy.edu.springframework.domain.WaterBill;
import com.nhnacademy.edu.springframework.repository.StandardBillStorage;
import com.nhnacademy.edu.springframework.service.StandardWaterBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class BootStrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

        StandardWaterBillService waterBillService = context.getBean("waterBillService",StandardWaterBillService.class);
        StandardBillStorage billStorage = context.getBean(StandardBillStorage.class);
        billStorage.load("data/Tariff_20220331.json");


        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("종료하려면 -1 입력! 시작하려면 아무 숫자나 입력하세요!");
            while(scanner.nextInt()!=-1){
                System.out.println("물 사용량을 입력 하시오!!");
                int waterVolume = scanner.nextInt();
                List<WaterBill> calculatedBill = waterBillService.calculated(waterVolume);
                for(WaterBill waterBill : calculatedBill){
                    System.out.println(waterBill.toString());
                }
            }
        }catch (Exception e){
            log.error("요금 처리중 에러가 발생 하였음!");
        }
    }
}