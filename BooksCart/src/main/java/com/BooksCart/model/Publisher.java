package com.BooksCart.model;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Publisher implements Serializable{

    private static final long serialVersionUID = -3532377236419382983L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PublisherId;



    @NotEmpty (message = "The PublisherName must not be null.")
    private String publishername;
    private String password;
    private String email;
    private String address;
    private String mobile;
    

    public int getPublisherId() {
        return PublisherId;
    }

    public void setPublisherId(int PublisherId) {
        this.PublisherId = PublisherId;
    }

    public String getpublishername() {
        return publishername;
    }

    public void setpublishername(String publishername) {
        this.publishername = publishername;
    }


    public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


/*    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }*/
}
