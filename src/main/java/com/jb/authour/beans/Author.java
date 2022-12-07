package com.jb.authour.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40, nullable = false)
    private String name;
    @OneToMany(mappedBy ="author",cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    @Singular
    private List<Book> books;
}
