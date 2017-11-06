package com.sda.hibernate.entity;
//lombok@data + dependecy
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity  //encja

@Table(name = "books", schema = "ksiegarnia") //może być ale nie musi

public class BooksEntity {

    @Column
    private String title;
    @Column
    private String author;
    @Column
    private Date published;
    @Column
    private String isbn;
    @Column
    private String category;
    @Column
    private Integer pageCount;
    @Column
    private String publisher;
    @Column
    private Integer onStock;
    @Id
  //  @GeneratedValue //autoinkrementacja
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //@Column(name = "title", nullable = true)  można to wpisać nad geterami i setterami albo bezpośrednio nad polem
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getOnStock() {
        return onStock;
    }

    public void setOnStock(Integer onStock) {
        this.onStock = onStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BooksEntity(String title, String author, Date published,
                       String isbn, String category, Integer pageCount,
                       String publisher, Integer onStock, int id) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.isbn = isbn;
        this.category = category;
        this.pageCount = pageCount;
        this.publisher = publisher;
        this.onStock = onStock;
        this.id = id;

     //   @Column(name= "title", nullable = true, length = 128)
// public String getTitle(){return title;}
    }

    public BooksEntity() {
    }
}
