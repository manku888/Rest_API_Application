package BookManager.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Author_Id")
	private int authorId;
	
	@Column(name="Author_Name")
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="Author_DateOFBirth")
	private Date dateOfBirth;
	
	@Column(name="Author_Nationality")
	private char nationality;

	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book books;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authorId, String name, Date dateOfBirth, char nationality, Book books) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.books = books;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public char getNationality() {
		return nationality;
	}

	public void setNationality(char nationality) {
		this.nationality = nationality;
	}

	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}

	

}
