package com.BooksCart.daoimpl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.BooksCart.dao.PublisherDAO;
import com.BooksCart.model.Publisher;

import java.util.List;


@Repository
@EnableTransactionManagement
public class PublisherDAOImpl implements PublisherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Publisher> getPublisherList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Publisher");
        List<Publisher> publisherList = query.list();
        session.flush();

        return publisherList;
    }

	@Transactional
    public Publisher getPublisherById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Publisher publisher = (Publisher) session.get(Publisher.class, id);
        session.flush();
        return publisher;
	}

	@Transactional
	public void addPublisher(Publisher publisher) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(publisher);
        session.flush();
	}

	@Transactional
	public void editPublisher(Publisher publisher) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(publisher);
        session.flush();
	}

	@Transactional
	public void deletePublisher(Publisher publisher) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(publisher);
        session.flush();
	}
}
