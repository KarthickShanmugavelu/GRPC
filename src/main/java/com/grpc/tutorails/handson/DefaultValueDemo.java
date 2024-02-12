package com.grpc.tutorails.handson;

import com.grpc.course.handson.Person;

public class DefaultValueDemo {
    public static void main(String[] args) {
        Person person = Person.newBuilder().build();
        System.out.println(person.hasAddress());
        System.out.println(person.getAge()==0);
        System.out.println(person.getName().isEmpty());
    }
}
