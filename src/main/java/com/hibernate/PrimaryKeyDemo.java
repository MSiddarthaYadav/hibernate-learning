package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory =
                        cfg.buildSessionFactory()) {

            try (Session session =
                            factory.openSession()) {

                Transaction tx =
                        session.beginTransaction();

                Student student =
                        new Student(
                                110,
                                "Siddartha",
                                "Primary Key"
                        );

                session.persist(student);

                tx.commit();
            }

            System.out.println(
                    "Primary Key Demo Executed Successfully"
            );
        }
    }
}