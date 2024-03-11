package com.grpc.tutorails.codes.handson.sec02;

import com.grpc.protobuf.tutorials.handson.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializationDeserializationDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(SerializationDeserializationDemo.class);
    private static final Path PATH = Path.of("person.bin");

    public static void main(String[] args) throws IOException {
        var person = Person.newBuilder().setFullName("Ram")
                .setAge(25)
                .setEmail("ram@gmail.com")
                .setEmployed(true)
                .setSalary(100000)
                .setBankAccountNumber(1234567891245L)
                .setBalance(-1234)
                .build();
        serialize(person);
        LOGGER.info(deserialize().toString());
        LOGGER.info("equals:{}", person.equals(deserialize()));
        LOGGER.info("byte length:{}", person.toByteArray().length);

    }

    public static void serialize(Person person) throws IOException {
        person.writeTo(Files.newOutputStream(PATH));
    }

    public static Person deserialize() {
        try (var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
