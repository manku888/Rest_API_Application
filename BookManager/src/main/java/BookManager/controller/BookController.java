package BookManager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BookManager.entity.Book;
import BookManager.services.BookService;

@RestController
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	// get all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>>getBook(){
		
		List<Book> list = bookService.getALLBooks();
		try {
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}catch (Exception e) {
			e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	// get single book handler
		@GetMapping("/books/{id}")
		public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

			Book book = bookService.getBookById(id);
            try {
			if (book == null) {
				  
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			}
			
            }catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
            return ResponseEntity.of(Optional.of(book));
            
		}

		// new book handler
		@PostMapping(value = "/books" ,consumes = "application/json")
		public ResponseEntity<Book> addBook(@RequestBody Book book) {
			Book b = null;
			try {
				b = this.bookService.addBook(book);

				return ResponseEntity.status(HttpStatus.CREATED).body(b);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		}

		// delete book handler
		@DeleteMapping("/books/{bookId}")
		public ResponseEntity<String> deleteBook(@PathVariable("bookId") int bookId) {
			
			try {
				if (bookId!=0) {
					
					this.bookService.deleteBook(bookId);
					return ResponseEntity.status(HttpStatus.ACCEPTED).body("Book deleted successfully");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		}
		
		
		

		// update book handler
		@PutMapping("books/{bookId}")
		public ResponseEntity<String> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
			try {
				this.bookService.updateBook(book, bookId);
				//return ResponseEntity.ok().body(book);
				return ResponseEntity.of(Optional.of("Book updated successfully"));
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to update book: " + e.getMessage());
			}
			
		}
}
