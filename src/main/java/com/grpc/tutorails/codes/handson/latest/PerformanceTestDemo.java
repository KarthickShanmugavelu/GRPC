package com.grpc.tutorails.codes.handson.latest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpc.protobuf.tutorials.handson.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceTestDemo {

    public static final Logger LOGGER =  LoggerFactory.getLogger(PerformanceTestDemo.class);
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
        var person = Person.newBuilder().setFullName("Ram")
                .setAge(25)
                .setEmail("ram@gmail.com")
                .setEmployed(true)
                .setSalary(100000)
                .setBankAccountNumber(1234567891245L)
                .setBalance(-1234)
                .build();
        var jsonPerson=new JsonPerson("Ram",25,"ram@gmail.com",true,100000,1234567891245L
        ,-1234);
        json(jsonPerson);
        proto(person);
       /* for (int i = 0; i < 5; i++) {
            runTest("Json",()->json(jsonPerson));
            runTest("proto",()->proto(person));

        }*/
    }

    private static void proto(Person person){
        try{
            var bytes=person.toByteArray();
            System.out.println("Proto: "+bytes.length);
            Person.parseFrom(bytes);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void json(JsonPerson jsonPerson){
        try{
            var bytes=objectMapper.writeValueAsBytes(jsonPerson);
            System.out.println("Json: "+bytes.length);
            objectMapper.readValue(bytes, JsonPerson.class);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private static void runTest(String testName,Runnable runnable){
        var start=System.currentTimeMillis();
        for (int i = 0; i <5000000 ; i++) {
            runnable.run();
        }
        var end=System.currentTimeMillis();
        LOGGER.info("Timetaken by {} for serialization & deserialization is {}",testName,(end-start));
    }
}
