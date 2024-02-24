package BookManager.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book_Id")
	private int id;

	@Column(name="Book_Title")
	private String title;

	@Column(name="Book_Genre")
	private char genre;

	@Temporal(TemporalType.DATE)
	@Column(name="Book_Published_Date")
	private Date publishedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, Author author, char genre, Date publishedDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publishedDate = publishedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", publishedDate="
				+ publishedDate + "]";
	}

}
