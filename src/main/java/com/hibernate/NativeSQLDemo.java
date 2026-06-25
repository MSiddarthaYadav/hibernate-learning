package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NativeSQLDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory =
                        cfg.buildSessionFactory()) {

            try (Session session =
                            factory.openSession()) {

                String sql =
                        "SELECT * FROM student";

            List<Object[]> students =
        session.createNativeQuery(sql, Object[].class)
                .getResultList();

                for (Object[] row : students) {

                    System.out.println(
                            row[0] + " "
                            + row[1] + " "
                            + row[2]
                    );
                }
            }

            System.out.println(
                    "Native SQL Query Executed Successfully"
            );
        }
    }
}