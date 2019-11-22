package org.patsimas.pagination.domain;


import javax.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;
}
