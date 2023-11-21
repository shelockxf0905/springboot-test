package com.dragon.test.com.dragon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${name}")
    private String name;

    @Value("${person.name}")
    private String name2;

    @Value("${person.age}")
    private int age;

//    @Value("${address[0]}")
//    private String address1;
//
//    @Value("${address[1]}")
//    private String address2;
//
//    @Value("${address[2]}")
//    private String address3;
//
//    @Value("${address[3]}")
//    private String address4;

    @Value("${msg_1}")
    private String msg1;

    @Value("${msg_2}")
    private String msg2;

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @RequestMapping("/test2")
    public String Test2() {
        System.out.println("name = " + name);
        System.out.println("name2 = " + name2);
        System.out.println("age = " + age);
//        System.out.println("address1 = " + address1);
//        System.out.println("address2 = " + address2);
//        System.out.println("address3 = " + address3);
//        System.out.println("address4 = " + address4);
        System.out.println("msg1 = " + msg1);
        System.out.println("msg2 = " + msg2);

        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("person.name = " + env.getProperty("person.name"));
//        System.out.println("address[1] = " + env.getProperty("address[1]"));
        System.out.println("person's name = " + person.getName());
        System.out.println("person's age = " + person.getAge());

        String[] addressList = person.getAddress();
        int i = 1;
        for (String s : addressList) {
            System.out.println(String.valueOf(i) + ": address = " + s);
            i++;
        }

        return "Test2 springboot.";
    }
    @RequestMapping("/test")
    public String Test() {
        return "Test springboot.";
    }
}
