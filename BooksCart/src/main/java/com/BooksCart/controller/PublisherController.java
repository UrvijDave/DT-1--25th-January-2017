package com.BooksCart.controller;




import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BooksCart.dao.PublisherDAO;
import com.BooksCart.model.Publisher;




@Controller
@RequestMapping("/publisher")
public class PublisherController  {

    @Autowired
    private PublisherDAO publisherDao;

    @RequestMapping("/publisherList/all")
    public String getPublishers(Model model) {
        List<Publisher> publishers = publisherDao.getPublisherList();
        model.addAttribute("publishers", publishers);

        return "publisherList";
    }
    
    @RequestMapping("/viewPublisher/{publisherId}")
    public String viewPublisher(@PathVariable int publisherId, Model model) throws IOException {
        Publisher publisher=publisherDao.getPublisherById(publisherId);
        model.addAttribute("publisher", publisher);

        return "viewPublisher";
    }

    @RequestMapping("/publisherList")
    public String getPublisherByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
        List<Publisher> publishers = publisherDao.getPublisherList();
        model.addAttribute("publishers", publishers);
        model.addAttribute("searchCondition", searchCondition);

        return "publisherList";
    }
}
