package org.example;

import org.example.service.UserService;
import org.example.config.MongoConfig;
import org.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*

    json:
    key, value, json 0bject, json array

    key similar to variable: int id, String name
    1. Embedded
    "user":{
        "id":1, // key
        "name":"moti",// key
        "Address":{"id":101,"plotNo":"70 A", "area":"mansarovar",number:[]} // json object,
        "courses":["java","python"],
        "courses":[{"id":201,"name":"java"},{"id":202,"name":"python"}],
    }
    2. reference
    "user":{
                    "id"101,
                    "name:"moti"
    }
    "courses":{
                "id":201,
                "course":"java",
                referece:101

    }

 */



public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);

        UserService service = context.getBean(UserService.class);

        // CREATE
        User user = new User("Ashu", "ashu99_97@gmail.com", 22);
        service.createUser(user);

        // READ
        System.out.println("All Users:");
        service.getAllUsers().forEach(u ->
                System.out.println(u.getName()));

        // UPDATE
        user.setAge(30);
        service.updateUser(user);

    }
}
