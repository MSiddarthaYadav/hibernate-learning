package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TransactionDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory = cfg.buildSessionFactory()) {

            try (Session session = factory.openSession()) {

                Transaction tx =
                        session.beginTransaction();

                Student student =
                        new Student(
                                107,
                                "Siddartha",
                                "Transaction"
                        );

                session.persist(student);

                tx.commit();
            }

            System.out.println(
                    "Transaction Committed Successfully"
            );
        }
    }
}