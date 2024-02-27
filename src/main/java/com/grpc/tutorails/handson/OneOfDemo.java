package com.grpc.tutorails.handson;

public class OneOfDemo {
    public static void main(String[] args) {
        com.grpc.course.handson.EmailCredentials emailCredentials = com.grpc.course.handson.EmailCredentials.newBuilder()
                .setEmail("abc@gamil.com")
                .setPassword("123")
                .build();
        com.grpc.course.handson.PhoneCredentials phoneCredentials = com.grpc.course.handson.PhoneCredentials.newBuilder()
                .setNumber(1234567890)
                .setCode(123)
                .build();
        System.out.println("******** ROUND 1 **************");
        com.grpc.course.handson.Credentials credentials =com.grpc.course.handson.Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneCredentials)
                .build();
        System.out.println(credentials);
        System.out.println("******** ROUND 2 **************");
        com.grpc.course.handson.Credentials credentials2 =com.grpc.course.handson.Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneCredentials)
                .build();
        switch (credentials.getModeCase()){
            case EMAILMODE: System.out.println(credentials2);break;
            case PHONEMODE: System.out.println(credentials2);break;
        }
        System.out.println("******** ROUND 3 **************");
        com.grpc.course.handson.Credentials credentials3 =com.grpc.course.handson.Credentials.newBuilder()
                .setPhoneMode(phoneCredentials)
                .setEmailMode(emailCredentials)
                .build();
        switch (credentials.getModeCase()){
            case EMAILMODE: System.out.println(credentials3);break;
            case PHONEMODE: System.out.println(credentials3);break;
        }
    }


}
