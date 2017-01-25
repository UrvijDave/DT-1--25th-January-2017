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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.BooksCart.dao.ProductDAO;
import com.BooksCart.model.Product;

@Controller
@RequestMapping("/admin")
public class AdminControllerProduct {

	private Path path;

	@Autowired
	private ProductDAO productDao;
	
	@RequestMapping("/productInventory")
    public String getProducts(Model model) {
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

	@Transactional
	@RequestMapping("/addProduct")
	public String addProduct(Model model) {

		Product product = new Product();
		product.setProductCategory("Books");
		product.setProductCondition("new");
		product.setProductStatus("active");

		model.addAttribute("product", product);

		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "denied";
		}
		System.out.println("inside addProduct-post");
		System.out.println(product.getProductName());
		System.out.println(product.getProductCategory());
		
		productDao.addProduct(product);

		MultipartFile productImage = product.getProductImage();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".jpg");
		// path=Paths.get("D:\\img\\"+product.getProductId()+".jpg");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed.", e);
			}
		}

		return "redirect:/admin/productInventory";
		//return "productInventory";
	}

	@Transactional
	@RequestMapping("/product/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productDao.getProductById(id);
		model.addAttribute("product", product);
		return "editProduct";
	}

	@RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editProduct";
		}

		MultipartFile productImage = product.getProductImage();

		// String rootDirectory =
		// request.getSession().getServletContext().getRealPath("/");
		// path = Paths.get(rootDirectory +
		// "\\WEB-INF\\resources\\images\\"+product.getProductId()+".jpg");
		path = Paths.get("D:\\img\\" + product.getProductId() + ".jpg");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed.", e);
			}
		}

		productDao.editProduct(product);

		return "redirect:/admin/productInventory";
	}

	@Transactional
	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {

		// String rootDirectory =
		// request.getSession().getServletContext().getRealPath("/");
		// path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" +
		// id + ".jpg");
		path = Paths.get("D:\\img\\" + id + ".jpg");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Product product = productDao.getProductById(id);
		productDao.deleteProduct(product);

		return "redirect:/admin/productInventory";
	}
}
