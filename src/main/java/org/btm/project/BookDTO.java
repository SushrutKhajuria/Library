package org.btm.project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Book_Table")
public class BookDTO implements Serializable{

	@Id
	@GeneratedValue(generator="inc")
	@GenericGenerator(name="inc",strategy="increment")
	private int id;
	@Column(name="BOOK_Name")
	private String name;
	@Column(name="BOOK_Price")
	private double price;
	@Column(name="BOOK_Author")
	private String author;
	
	
	@ManyToOne
	LibraryDTO library;
	
	
	
	
	public LibraryDTO getLibrary() {
		return library;
	}
	public void setLibrary(LibraryDTO library) {
		this.library = library;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BookDTO() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + "]";
	}
	
	
}
