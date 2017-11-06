package com.sda.hibernate;

import com.sda.hibernate.entity.BooksEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(String[] args) throws Exception {
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<BooksEntity> books =
                    session.createQuery("FROM " + BooksEntity.class.getName()).list();

            for (BooksEntity book: books){
                System.out.println(" Autor: " + book.getAuthor());
                System.out.println("  Tytul: " + book.getTitle());
            }
            tx.commit();

            tx = session.beginTransaction();

            BooksEntity booksEntity = new BooksEntity();
            booksEntity.setAuthor("Autor");
            booksEntity.setIsbn("ISBN 1233");
            BooksEntity booksEntity1 = new BooksEntity();
            booksEntity.setAuthor("Autor");
            booksEntity.setIsbn("ISBN 1233");
            session.save(booksEntity1);
            session.save(booksEntity);

            //usunięcie rekordu po id
            BooksEntity b1;
            b1 = (BooksEntity)session.load(BooksEntity.class, 2);
            session.delete(b1);

            tx.commit();

        } catch (
                HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            ourSessionFactory.close();
        }
    }
}

