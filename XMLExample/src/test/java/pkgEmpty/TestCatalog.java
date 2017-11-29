package pkgEmpty;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.Catalog;
import pkgLibrary.BookException;
import pkgMain.XMLReader;

public class TestCatalog {


	@org.junit.Test (expected = BookException.class)
	public void getBooktest() throws BookException {
		Book b1 = new Book();
		Book b2 = new Book();
		b1.setId("1");
		b2.setId("2");
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		
		Catalog cat = new Catalog();
		cat.setBooks(books);
		assertEquals(cat.getBook("1"),b1);
		assertEquals(cat.getBook("2"), b2);
		cat.getBook("3"); //throws exception because no book with id = 3
	}

	@org.junit.Test (expected = BookException.class)
	public void addBooktest() throws BookException{
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		b1.setId("1");
		b2.setId("2");
		b3.setId("3");
		b4.setId("4");
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		Catalog cat = new Catalog();
		cat.setBooks(books);
		cat.addBook(b1); //throws exception because b1 already in cat
		
		cat.addBook(b4);
		books.add(b4);
		assertEquals(cat.getBooks(), books);
	}
}