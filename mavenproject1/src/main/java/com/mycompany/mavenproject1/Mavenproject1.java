/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author admin
 */
public class Mavenproject1 {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
    spark.Spark.port(4567);
        spark.Spark.get("/hello",(req, res) -> {
            User user = new User("Phuc","1234567");
            ObjectMapper mapper  = new ObjectMapper();
            String data = mapper.writeValueAsString(user);
            
            res.header("Content-Type", "application/json");
            return data;
        });
        
        
    }
}
