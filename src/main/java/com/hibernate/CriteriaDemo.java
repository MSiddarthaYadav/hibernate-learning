package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Student.class);

        try (SessionFactory factory = cfg.buildSessionFactory()) {

            try (Session session = factory.openSession()) {

                CriteriaBuilder builder =
                        session.getCriteriaBuilder();

                CriteriaQuery<Student> query =
                        builder.createQuery(Student.class);

                Root<Student> root =
                        query.from(Student.class);

                query.select(root);

                List<Student> students =
                        session.createQuery(query)
                                .getResultList();

                for (Student s : students) {

                    System.out.println(
                            s.getId() + " "
                            + s.getName() + " "
                            + s.getCourse()
                    );
                }
            }

            System.out.println(
                    "Criteria API Executed Successfully"
            );
        }
    }
}