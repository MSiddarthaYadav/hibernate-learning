package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ColumnMappingDemo {

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
                                111,
                                "Siddartha",
                                "Column Mapping"
                        );

                session.persist(student);

                tx.commit();
            }

            System.out.println(
                    "Column Mapping Executed Successfully"
            );
        }
    }
}