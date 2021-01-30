package com.samlasoft.simpleboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "simpleboard")
@NoArgsConstructor
@AllArgsConstructor
public class SimpleBoard {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;

}
