package ventas.cheffify.jpa.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ventas.cheffify.jpa.entity.Author;
import jakarta.persistence.EntityManagerFactory;

@Service
public class DaoFactory {

    @Autowired
    private SessionFactory sessionFactory;

    public DaoFactory(EntityManagerFactory factory) {
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public void create(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
    }

    public void update(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(obj);
        session.getTransaction().commit();
    }

    public List<Author> getAuthors() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Author> query = session.createNativeQuery("SELECT * FROM AUTHORS", Author.class);
        List<Author> listaAuthors = query.list();
        session.getTransaction().commit();
        return listaAuthors;
    }
}
