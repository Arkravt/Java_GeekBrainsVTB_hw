package com.geekbrains.lesson11_Hibernate_Part1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    private static SessionFactory factory;
    private static Session session;

    public static void main(String[] args) {
        initFactory();

        try {
           // create();
            read();
           // update();
           // delete();
        } finally {
            factory.close();
            session.close();
        }

    }


    ////////////// CRUD //////////////
    private static void create() {

        // detach() - отвязать объект от контекста, отсоединяем от hibernate
        // persist() - Добавить объект к контексту
        // remove() - удалить объект из таблицы
        // merge() - вернуть удаленный объект пока транзакция не закомичена

        // Создание записи в таблице
        session = factory.getCurrentSession();
        Catalog catalog1 = new Catalog("BMW");
        Catalog catalog2 = new Catalog("TOYOTA");
        session.beginTransaction();
        session.save(catalog1);
        session.save(catalog2);
        session.getTransaction().commit();
    }

    private static void read() {
        // Чтение записи из таблицы
        session = factory.getCurrentSession();
        session.beginTransaction();
        Book book = session.get(Book.class, 12L);
//        List catalogs = session.createQuery("from Catalog").getResultList();
//        List catalogs = session.createQuery("from Catalog where title = :title")
//                .setParameter("title", "BMW")
//                .getResultList();
        session.getTransaction().commit();
        System.out.println(book);
    }

    private static void update() {
        // Изменение записи в таблице
        session = factory.getCurrentSession();
        session.beginTransaction();
        Catalog catalog = session.get(Catalog.class, 2L);
        catalog.setTitle("LEXUS");
        //session.createQuery("update Catalog set title = 'LEXUS' where id = 2").executeUpdate();
        session.getTransaction().commit();
    }

    private static void delete() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        Catalog catalog = session.get(Catalog.class, 2L);
        session.delete(catalog);
//        session.createQuery("delete from Catalog where id = 1").executeUpdate();
        session.getTransaction().commit();
    }
    ////////////// CRUD //////////////


    private static void initFactory() {
        factory = new Configuration()
                .configure("lesson11/hibernate_lesson11.cfg.xml")
                //.addAnnotatedClass(Catalog.class)
                .addAnnotatedClass(Readers.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(AuthorDetails.class)
                .buildSessionFactory();

    }
}
