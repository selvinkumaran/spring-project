package com.spring.springproject.repository;

import com.spring.springproject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        return jdbcTemplate.query("select * from book;", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book findById(int id) {
        return jdbcTemplate.queryForObject("select * from book where id=?;",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Book> insert(Book book) {
        jdbcTemplate.update("insert into book(title,author,price,amount) values(?,?,?,?);",
                new Object[]{book.getTitle(), book.getAuthor(), book.getPrice(), book.getAmount()});
        return findAll();
    }

    public List<Book> update(Book book) {
        jdbcTemplate.update("update book set title=?,author=?,price=?,amount=? where id =?;",
                new Object[]{book.getTitle(), book.getAuthor(), book.getPrice(), book.getAmount(),book.getId()});
        return findAll();
    }

    public List<Book> deleteById(int id) {
        jdbcTemplate.update("delete from book where id =?;",
                new Object[]{id});
        return findAll();
    }
}
