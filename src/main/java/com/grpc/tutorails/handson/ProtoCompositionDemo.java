package com.grpc.tutorails.handson;

import com.grpc.course.handson.Address;
import com.grpc.course.handson.Car;

import java.util.ArrayList;
import java.util.List;

public class ProtoCompositionDemo {
    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(1234)
                .setStreet("1st Avenue")
                .setCity("California")
                .build();

        Car accord = Car.newBuilder().setMake("Honda")
                .setModel("Accord")
                .setYear(2021).build();
        Car civic = Car.newBuilder().setMake("Honda")
                .setModel("Civic")
                .setYear(2022).build();
        Car swift = Car.newBuilder().setMake("Maruthi")
                .setModel("Swift")
                .setYear(2023).build();
        Car figo = Car.newBuilder().setMake("Ford")
                .setModel("Figo")
                .setYear(2024).build();
        List<Car> cars = new ArrayList<>();
        cars.add(swift);
        cars.add(figo);

        com.grpc.course.handson.Person person = com.grpc.course.handson.Person.newBuilder()
                .setName("Sam")
                .setAge(30)
                .setAddress(address)
                .addCar(accord)
                .addCar(civic)
                .addAllCar(cars)
                .build();

        System.out.println(person);
    }
}
