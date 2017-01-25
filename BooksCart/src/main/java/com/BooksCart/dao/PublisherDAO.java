package com.BooksCart.dao;

import com.BooksCart.model.Publisher;

import java.util.List;


public interface PublisherDAO {

    List<Publisher> getPublisherList();

    Publisher getPublisherById(int id);

    void addPublisher(Publisher publisher);

    void editPublisher(Publisher publisher);

    void deletePublisher(Publisher publisher);
}
