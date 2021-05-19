package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Product;

import java.util.List;

public class ProductDAOImpl implements DAO<Product, Integer> {
    private final SessionFactory factory;

    public ProductDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> findByAll() {
        try(Session session = factory.openSession()){
            Query<Product> query = session.createQuery("FROM Product");
            return query.list();
        }
    }

    @Override
    public Product read(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Product.class, integer);
        }
    }
}
