package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // 1. Configuration
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Student.class);

        // 2. SessionFactory and 3. Session (try-with-resources)
        try (SessionFactory factory = cfg.buildSessionFactory();
                Session session = factory.openSession()) {

            // 4. Transaction
            Transaction tx = session.beginTransaction();

            // Entity Object
            Student student =
                    new Student(
                        105,
                            "Siddartha",
                            "Hibernate Architecture");

            // Save Object
            session.persist(student);

            // Commit Transaction
            tx.commit();
        }

        System.out.println("Student Saved Successfully");
    }
}