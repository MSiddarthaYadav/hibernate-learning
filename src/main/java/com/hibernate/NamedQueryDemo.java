package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NamedQueryDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory =
                     cfg.buildSessionFactory()) {

            try (Session session =
                         factory.openSession()) {

                List<Student> students =
                        session.createNamedQuery(
                                "Student.findAll",
                                Student.class
                        ).getResultList();

                for (Student s : students) {

                    System.out.println(
                            s.getId() + " "
                            + s.getName() + " "
                            + s.getCourse()
                    );
                }
            }

            System.out.println(
                    "Named Query Executed Successfully"
            );
        }
    }
}