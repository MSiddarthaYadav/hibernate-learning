package com.hibernate.relationshipmapping.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

        cfg.addAnnotatedClass(Person.class);
        cfg.addAnnotatedClass(Passport.class);

        try (SessionFactory factory = cfg.buildSessionFactory()) {

            try (Session session = factory.openSession()) {

                Transaction tx =
                        session.beginTransaction();

                Passport passport =
                        new Passport(
                                1,
                                "IND12345"
                        );

                Person person =
                        new Person(
                                101,
                                "Siddartha",
                                passport
                        );

                session.persist(passport);
                session.persist(person);

                tx.commit();
            }

            System.out.println(
                    "One-To-One Mapping Executed Successfully"
            );
        }
    }
}