package org.btm.project;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Library_Table")
public class LibraryDTO implements Serializable {

	@Id
	@GeneratedValue(generator="inc")
	@GenericGenerator(name="inc", strategy="increment")
	private int id;
	
	@Column(name="Library_name")
	private String name;
	
	@Column(name="Library_location")
	private  String location;

	
	
	@OneToMany(mappedBy="library")
	List<BookDTO> books=new ArrayList<BookDTO>();
	
	
	
	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LibraryDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
	
}

