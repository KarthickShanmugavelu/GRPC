package com.grpc.tutorails.codes.handson.sec02;

import com.grpc.protobuf.tutorials.handson.sec02.Person;
import org.w3c.dom.ls.LSOutput;

public class ScalarDemo {

    public static void main(String[] args) {
        var person = Person.newBuilder().setFullName("Ram")
                .setAge(25)
                .setEmail("ram@gmail.com")
                .setEmployed(true)
                .setSalary(100000)
                .setBankAccountNumber(1234567891245L)
                .setBalance(-1234)
                .build();
        System.out.println(person);
    }


}