package org.library.model;

import javax.validation.constraints.*;

public class Book {

    private int id;
    private Integer personId;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    private String title;

    @NotEmpty(message = "AuthorName should not be empty")
    @Size(min = 2, max = 100, message = "AuthorName should be between 2 and 100 characters")
    private String authorName;

    @Max(value = 2023, message = "Publish year should be less than 2023")
    private int publishYear;

    public Book() {
    }

    public Book(int id, Integer personId, String title, String authorName, int publishYear) {
        this.id = id;
        this.personId = personId;
        this.title = title;
        this.authorName = authorName;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
