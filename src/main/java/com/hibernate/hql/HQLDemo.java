package com.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLDemo {

    public static void main(String[] args) {

        Configuration cfg =
                new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory =
                        cfg.buildSessionFactory()) {

            try (Session session =
                            factory.openSession()) {

                Query<Student> query =
                        session.createQuery(
                                "FROM Student",
                                Student.class
                        );

                List<Student> students =
                        query.list();

                for (Student s : students) {

                    System.out.println(
                            s.getId()
                                    + " "
                                    + s.getName()
                                    + " "
                                    + s.getCourse()
                    );
                }
            }

            System.out.println(
                    "HQL Executed Successfully"
            );
        }
    }
}