package com.foof.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.foof.mvc.models.Book;
import com.foof.mvc.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public void deleteAll() {
		bookRepository.deleteAll();
	}
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book b = findBook(id);
		b.setTitle(title);
		b.setDescription(desc);
		b.setLanguage(lang);
		b.setNumberOfPages(numOfPages);
		return bookRepository.save(b);
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
	public Book updateBook(@Valid Book book) {
		Book b = findBook(book.getId());
		b.setTitle(book.getTitle());
		b.setDescription(book.getDescription());
		b.setLanguage(book.getLanguage());
		b.setNumberOfPages(book.getNumberOfPages());
		return bookRepository.save(b);
		
	}
    
    
}