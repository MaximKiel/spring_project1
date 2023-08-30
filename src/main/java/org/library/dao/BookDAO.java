package org.library.dao;

import org.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author_name, publish_year) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthorName(), book.getPublishYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET title=?, author_name=?, publish_year=? WHERE id=?",
                updatedBook.getTitle(), updatedBook.getAuthorName(), updatedBook.getPublishYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
}
