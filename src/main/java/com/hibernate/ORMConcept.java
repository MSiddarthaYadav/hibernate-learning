package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ORMConcept {

        public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory = cfg.buildSessionFactory();
                Session session = factory.openSession()) {

                Transaction tx =
                        session.beginTransaction();

                Student student =
                        new Student(
                                104,
                                "Siddartha",
                                "ORM Concept"
                        );

                session.persist(student);

                tx.commit();

                System.out.println(
                        "ORM Concept Record Saved Successfully");
        }
        }
}