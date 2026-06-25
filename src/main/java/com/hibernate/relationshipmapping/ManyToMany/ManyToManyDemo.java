package com.hibernate.relationshipmapping.ManyToMany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(StudentMTM.class);
        cfg.addAnnotatedClass(Course.class);

        try (SessionFactory factory =
                     cfg.buildSessionFactory()) {

            try (Session session =
                         factory.openSession()) {

                Transaction tx =
                        session.beginTransaction();

                Course c1 =
                        new Course(
                                501,
                                "Java"
                        );

                Course c2 =
                        new Course(
                                502,
                                "Hibernate"
                        );

                StudentMTM student =
                        new StudentMTM(
                                201,
                                "Siddartha",
                                Arrays.asList(c1, c2)
                        );

                session.persist(student);

                tx.commit();
            }

            System.out.println(
                    "Many-To-Many Mapping Executed Successfully"
            );
        }
    }
}