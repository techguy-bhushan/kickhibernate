package com.kickhibernate.onetoone.bidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BookDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String authorName;

    private Double price;

    @OneToOne
    private Book book;

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}';
    }
}
