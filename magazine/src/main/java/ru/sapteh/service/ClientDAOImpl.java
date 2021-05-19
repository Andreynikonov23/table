package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Client;

import java.util.List;

public class ClientDAOImpl implements DAO<Client, Integer> {
    private final SessionFactory factory;

    public ClientDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Client client) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Client client) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Client client) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Client> findByAll() {
        try(Session session = factory.openSession()){
            Query<Client> query = session.createQuery("FROM Client");
            return query.list();
        }
    }

    @Override
    public Client read(Integer integer) {
        try(Session session = factory.openSession()){
            return session.get(Client.class, integer);
        }
    }
}
