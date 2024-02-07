package com.grpc.tutorails.handson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.json.JPerson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {
    public static void main(String[] args) throws IOException {
        com.grpc.course.handson.Person person = com.grpc.course.handson.Person.newBuilder().setName("sam").setAge(25).build();
        com.grpc.course.handson.Person person1 = com.grpc.course.handson.Person.newBuilder().setName("Sam").setAge(25).build();

        //equals() & == behavior
        System.out.println(person.equals(person1));
        System.out.println(person==(person1));

        //serialization & deserialization
        Path path = Paths.get("person.bin");
        Files.write(path,person.toByteArray());

        byte[] bytes=Files.readAllBytes(path);
        com.grpc.course.handson.Person newPerson = com.grpc.course.handson.Person.parseFrom(bytes);
        System.out.println(newPerson);

        // JSON Vs Proto Performance comparison
        JPerson jPerson = new JPerson("Sam",25);
        ObjectMapper objectMapper = new ObjectMapper();

        Runnable json=()->{
            byte[] bytes1= new byte[0];
            try {
                bytes1 = objectMapper.writeValueAsBytes(jPerson);
                JPerson jPerson1=objectMapper.readValue(bytes1, JPerson.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        };

        com.grpc.course.handson.Person person2 = com.grpc.course.handson.Person.newBuilder().setName("Sam").setAge(25).build();


        Runnable proto=()->{
            byte[] bytes2 = person2.toByteArray();
            try {
                com.grpc.course.handson.Person person3 = com.grpc.course.handson.Person.parseFrom(bytes2);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i <5 ; i++) {
            performanceTest(json,"json");
            performanceTest(proto,"proto");
        }



    }

    private static void performanceTest(Runnable runnable,String method){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 9_000_000 ; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();
        System.out.println(method + " : " + (time2 - time1));
    }
}
