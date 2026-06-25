package com.hibernate.relationshipmapping.OneToMany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Department.class);
        cfg.addAnnotatedClass(Employee.class);

        try (SessionFactory factory = cfg.buildSessionFactory()) {

            try (Session session = factory.openSession()) {

                Transaction tx = session.beginTransaction();

                Employee e1 =
                        new Employee(
                                1,
                                "Rahul"
                        );

                Employee e2 =
                        new Employee(
                                2,
                                "Kiran"
                        );

                Employee e3 =
                        new Employee(
                                3,
                                "Siddartha"
                        );

                Department department =
                        new Department(
                                101,
                                "IT",
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
                    "One-To-Many Mapping Executed Successfully"
            );
        }
    }
}