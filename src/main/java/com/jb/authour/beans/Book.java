package com.jb.authour.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40, nullable = false)
    private String name;
    private int year;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Author author;

    public Book(String name, int year) {
        this.name = name;
        this.year = year;
    }
}
