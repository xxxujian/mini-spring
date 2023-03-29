package com.minis.spring;

import com.minis.beans.AService;
import com.minis.context.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) throws Exception {
      
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/minis/beans.xml");

        AService aService = (AService) ctx.getBean("aservice");
        aService.sayHello();
    }
}
