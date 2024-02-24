package BookManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import BookManager.dao.Repository;
import BookManager.entity.Book;

@Component
public class BookService {
	@Autowired
  private Repository repository;
	
	
	
	// get all books
	public List<Book> getALLBooks(){
	List<Book> list	=(List<Book>)this.repository.findAll();
	
	return list;
	}
	
	
	
	// get single book by id
		public Book getBookById(int id) {
			Book book=null;
			try {
				
				//book=list.stream().filter(e->e.getId()==id).findFirst().get();
				
			book=this.repository.findById(id);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return book;
		}
		
		//adding the book using Post
		
		public Book addBook(Book b) {
			Book result =this.repository.save(b);
			return result;
		}

		// delete book
		public void deleteBook(int bid)
		{
			
			//list=list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList());
			if (repository.existsById(bid)) {
				
				this.repository.deleteById(bid);
			}
		}

		
	  
		
		
		// update
		public void updateBook(Book book, int bookId)
		{
//		  list=	list.stream().map(b->{
//			if(	b.getId()==bookId) {
//				b.setName(book.getName());
//				b.setAuther(book.getAuther());
//			}
//			return b;
//			}).collect(Collectors.toList());
			book.setId(bookId);
			this.repository.save(book);
		}
		
}
