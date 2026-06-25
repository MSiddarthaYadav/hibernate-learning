package com.hibernate.fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchTypeDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Department.class);
        cfg.addAnnotatedClass(Employee.class);

        try (SessionFactory factory =
                     cfg.buildSessionFactory()) {

            try (Session session =
                         factory.openSession()) {

                Department dept =
                        session.find(
                                Department.class,
                                301
                        );

                if (dept != null) {
                    System.out.println(
                            "Department Loaded"
                    );

                    System.out.println(
                            dept.getEmployees()
                    );
                } else {
                    System.out.println("Department not found");
                }
            }

            System.out.println(
                    "Fetch Type Executed Successfully"
            );
        }
    }
}