package com.hibernate.cascade;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CascadeDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Department.class);
        cfg.addAnnotatedClass(Employee.class);

        try (SessionFactory factory =
                     cfg.buildSessionFactory()) {

            try (Session session =
                         factory.openSession()) {

                Transaction tx =
                        session.beginTransaction();

                Employee e1 =
                        new Employee(
                                21,
                                "Rahul"
                        );

                Employee e2 =
                        new Employee(
                                22,
                                "Kiran"
                        );

                Employee e3 =
                        new Employee(
                                23,
                                "Siddartha"
                        );

                Department department =
                        new Department(
                                301,
                                "Development",
                                Arrays.asList(
                                        e1,
                                        e2,
                                        e3
                                )
                        );

                session.persist(department);

                tx.commit();
            }

            System.out.println(
                    "Cascade Type Executed Successfully"
            );
        }
    }
}