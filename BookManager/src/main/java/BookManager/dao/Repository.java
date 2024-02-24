package BookManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import BookManager.entity.Book;



public interface Repository extends JpaRepository<Book, Integer>{
	
	//for findBy id
	public Book  findById(int id);
}
