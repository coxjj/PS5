package pkgLibrary;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Book getBook(String id) throws BookException {
		boolean bookExists = false;
		try {
			for (Book b : this.getBooks()) {
				if (b.getId().equals(id)) {
					bookExists = true;
					return b;
				}
			}
			if (!bookExists) {
				throw new BookException("we dont have this Book!");
			}
		}catch(BookException e) {
			throw e;
		}
		return null;
	}
	
	
		
	private static Catalog ReadXMLFile() {

			Catalog cat = null;

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			System.out.println(file.getAbsolutePath());
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
				System.out.println(cat);
			} catch (JAXBException e) {
				e.printStackTrace();
			}

			return cat;

		}
	public void addBook(Book b) throws BookException {
		boolean bookExists = false;
		try {
			for (Book c : this.getBooks()) {
				if (c.getId().equals(b.getId())) {
					bookExists = true;
					throw new BookException("Book exists");
				}
			}
		}catch(BookException c) {
			throw c;
		}
		if (!bookExists) {
			this.books.add(b);
		}
	}
	
}


	
	
	
	

