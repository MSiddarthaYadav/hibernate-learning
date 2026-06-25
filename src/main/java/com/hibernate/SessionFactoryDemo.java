package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory = cfg.buildSessionFactory()) {

            System.out.println(
                    "SessionFactory Created Successfully"
            );

            System.out.println(factory);
        }
    }
}