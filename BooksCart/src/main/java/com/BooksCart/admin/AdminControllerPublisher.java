package com.BooksCart.admin;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.BooksCart.dao.PublisherDAO;
import com.BooksCart.model.Publisher;



@Controller
@RequestMapping("/admin")
public class AdminControllerPublisher {

    private Path path;

    @Autowired
    private PublisherDAO publisherDao;

    @Transactional
    @RequestMapping("/publisherInventory")
  //@RequestMapping("/publisherhome")  
    public String getPublishers(Model model) {
        List<Publisher> publishers = publisherDao.getPublisherList();
        model.addAttribute("publishers", publishers);

        return "publisherInventory";
      //return "publisherhome";  
    }
    
    
    @Transactional
    @RequestMapping("/addPublisher")
    public String addPublisher(Model model) {
    	
        Publisher publisher = new Publisher();

        model.addAttribute("publisher", publisher);

        return "addPublisher";
    }

    @Transactional
    @RequestMapping(value="/addPublisher", method = RequestMethod.POST)
    public String addPublisherPost(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result,
                                 HttpServletRequest request) {
        if(result.hasErrors()) {
            return "denied";
        }

        publisherDao.addPublisher(publisher);

     //   MultipartFile publisherImage = publisher.getPublisherImage();
        
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+publisher.getPublisherId()+".jpg");
        //path=Paths.get("D:\\img\\"+publisher.getPublisherId()+".jpg");


       // if (publisherImage != null && !publisherImage.isEmpty()) {
         //   try {
           //     publisherImage.transferTo(new File(path.toString()));
            //} catch (Exception e) {
              //  e.printStackTrace();
                //throw new RuntimeException("Publisher image saving failed.", e);
            //}
        //}

        return "redirect:/admin/publisherInventory";
      //return "redirect:/admin/publisherhome";  
    }

    @Transactional
    @RequestMapping("/publisher/editPublisher/{id}")
    public String editPublisher(@PathVariable("id") int id, Model model) {
        Publisher publisher = publisherDao.getPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "editPublisher";
    }

    @Transactional
    @RequestMapping(value="/publisher/editPublisher", method = RequestMethod.POST)
    public String editPublisherPost(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result,
                                 HttpServletRequest request) {
        if(result.hasErrors()) {
            return "editPublisher";
        }

        //MultipartFile publisherImage = publisher.getPublisherImage();
        
        //String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+publisher.getPublisherId()+".jpg");
        path=Paths.get("D:\\img\\"+publisher.getPublisherId()+".jpg");

        //if (publisherImage != null && !publisherImage.isEmpty()) {
          //  try {
            //    publisherImage.transferTo(new File(path.toString()));
            //} catch (Exception e) {
              //  e.printStackTrace();
                //throw new RuntimeException("Publisher image saving failed.", e);
           // }
        //}

        publisherDao.editPublisher(publisher);

        return "redirect:/admin/publisherInventory";
    }

    @Transactional
    @RequestMapping("/publisher/deletePublisher/{id}")
    public String deletePublisher(@PathVariable int id, Model model, HttpServletRequest request) {
       
    	//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".jpg");
    	path=Paths.get("D:\\img\\"+id+".jpg");
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Publisher publisher = publisherDao.getPublisherById(id);
        publisherDao.deletePublisher(publisher);

        return "redirect:/admin/publisherInventory";
    }
}
