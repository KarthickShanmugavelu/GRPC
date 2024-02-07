package com.grpc.tutorails.handson;

import java.util.HashMap;
import java.util.Map;

public class Mapdemo {
    public static void main(String[] args) {
        com.grpc.course.handson.Car accord = com.grpc.course.handson.Car.newBuilder().setMake("Honda")
                .setModel("Accord")
                .setYear(2021).build();
        com.grpc.course.handson.Car civic = com.grpc.course.handson.Car.newBuilder().setMake("Honda")
                .setModel("Civic")
                .setYear(2022).build();
        com.grpc.course.handson.Car swift = com.grpc.course.handson.Car.newBuilder().setMake("Maruthi")
                .setModel("Swift")
                .setYear(2023).build();
        com.grpc.course.handson.Car figo = com.grpc.course.handson.Car.newBuilder().setMake("Ford")
                .setModel("Figo")
                .setYear(2024).build();
        Map<Integer, com.grpc.course.handson.Car> carMap = new HashMap<>();
        carMap.put(2023,swift);
        carMap.put(2024,figo);
        com.grpc.course.handson.Dealer dealer = com.grpc.course.handson.Dealer.newBuilder()
                .putModels(2021,accord)
                .putModels(2022,civic)
                .putAllModels(carMap)
                .build();
        System.out.println(
                //"\ndealer.getModelsOrThrow "+ dealer.getModelsOrThrow(245)+
                "\ndealer.getModelsOrDefault "+dealer.getModelsOrDefault(234,accord)+
                        "\ndealer.getModelsCount() "+dealer.getModelsCount()+
                        "\ndealer.getModels "+dealer.getModels()


        );
    }
}
