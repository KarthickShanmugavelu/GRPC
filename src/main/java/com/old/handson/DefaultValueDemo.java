package com.old.handson;

import com.grpc.course.handson.OldPeople;

public class DefaultValueDemo {
    public static void main(String[] args) {
        OldPeople OldPerson = OldPeople.newBuilder().build();
        System.out.println(OldPerson.hasAddress());
        System.out.println(OldPerson.getAge()==0);
        System.out.println(OldPerson.getName().isEmpty());
    }
}
