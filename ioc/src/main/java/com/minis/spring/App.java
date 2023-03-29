package com.minis.spring;

import com.minis.ClassPathXmlApplicationContext;
import com.minis.beans.AService;

/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) {
      
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/minis/beans.xml");

        AService aService = (AService) ctx.getBean("aservice");
        aService.sayHello();
    }
}
