package matcher;

public class Book {
	private String isbn;

	private int id;

	private String title;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public Book(int id, String isbn, String title) {
		super();
		this.isbn = isbn;
		this.id = id;
		this.title = title;
	}

}
