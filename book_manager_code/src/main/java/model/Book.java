package model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Book.
 */
public class Book implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The book id. */
    private Integer bookId;
    
    /** The book title. */
    private String bookTitle;
    
    /** The author. */
    private String author;
    
    /** The brief. */
    private String brief;
    
    /** The publisher. */
    private String publisher;
    
    /** The content. */
    private String content;
    
    /** The category. */
    private String category;

    /**
     * Instantiates a new book.
     */
    public Book() {
    }

    /**
     * Instantiates a new book.
     *
     * @param bookId the book id
     * @param bookTitle the book title
     * @param author the author
     * @param brief the brief
     * @param publisher the publisher
     * @param content the content
     * @param category the category
     */
    public Book(Integer bookId, String bookTitle, String author, String brief, String publisher,
                String content, String category) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.content = content;
        this.category = category;
    }

    /**
     * Instantiates a new book.
     *
     * @param bookTitle the book title
     * @param author the author
     * @param brief the brief
     * @param publisher the publisher
     * @param content the content
     * @param category the category
     */
    public Book(String bookTitle, String author, String brief, String publisher, String content,
                String category) {
        super();
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.content = content;
        this.category = category;
    }

    /**
     * Instantiates a new book.
     *
     * @param bookId the book id
     * @param content the content
     */
    public Book(Integer bookId, String content) {
      super();
      this.bookId = bookId;
      this.content = content;
    }

    /**
     * Gets the book id.
     *
     * @return the book id
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Sets the book id.
     *
     * @param bookId the new book id
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * Gets the book title.
     *
     * @return the book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Sets the book title.
     *
     * @param bookTitle the new book title
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     *
     * @param author the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the brief.
     *
     * @return the brief
     */
    public String getBrief() {
        return brief;
    }

    /**
     * Sets the brief.
     *
     * @param brief the new brief
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * Gets the publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher.
     *
     * @param publisher the new publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     *
     * @param category the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author
                + ", brief=" + brief + ", publisher=" + publisher + ", content=" + content
                + ", category=" + category + "]";
    }

    /**
     * Display.
     *
     * @param stt the stt
     */
    public void display(int stt) {

        System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %7$-15s %8$-15s \n",
                stt,
                bookId,
                bookTitle,
                author,
                brief,
                publisher,
                content,
                category);
    }

}
