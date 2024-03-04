package com.grpc.tutorails.codes.handson;

import com.grpc.protobuf.tutorials.handson.Person;

public class EqualsAndClearDemo {
    public static void main(String[] args) {
        Person p1=createPerson();
        Person p2=createPerson();

        //checking equals & ==
        System.out.println(p1.equals(p2));
        System.out.println(p1==p2);

        //checking mutability
        System.out.println("Before changing\t"+p1);
        p1 = p1.toBuilder().setName("Michael").build();
        System.out.println("After changing\t"+p1);

        //checking nullability
        //Person p3=p1.toBuilder().setName(null).build(); ==> Throws null pointer exception
        Person p3=p1.toBuilder().clearName().build();
        System.out.println(p3);

    }

    public static Person createPerson(){
        return Person.newBuilder().setAge(23).setName("Ravi").build();
    }
}
