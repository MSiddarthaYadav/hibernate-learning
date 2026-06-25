package com.hibernate.relationshipmapping.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Department.class);

        try (SessionFactory factory = cfg.buildSessionFactory()) {

            try (Session session = factory.openSession()) {

                Transaction tx = session.beginTransaction();

                Department department =
                        new Department(
                                202,
                                "IT"
                        );

                Employee e1 =
                        new Employee(
                                11,
                                "Rahul",
                                department
                        );

                Employee e2 =
                        new Employee(
                                12,
                                "Kiran",
                                department
                        );

                Employee e3 =
                        new Employee(
                                13,
                                "Siddartha",
                                department
                        );

                session.persist(e1);
                session.persist(e2);
                session.persist(e3);

                tx.commit();
            }

            System.out.println(
                    "Many-To-One Mapping Executed Successfully"
            );
        }
    }
}