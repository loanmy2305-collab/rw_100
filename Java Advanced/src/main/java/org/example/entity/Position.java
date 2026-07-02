package org.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.ArticlePositionNameConverter;
import org.example.enums.PositionName;

import java.util.List;

@Entity
@Table(name = "position")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id// đại diện cho khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto_increment
    @Column(name = "position_id")// trường này cho biết là thuộc tính này map với cột department_id trong DB
    private Integer id;

    //    @Enumerated(EnumType.STRING)// String ORDINAL
    @Convert(converter = ArticlePositionNameConverter.class)
    @Column(name = "position_name")//
    private PositionName name;

    @OneToMany(mappedBy = "position")
    private List<Account> accounts;
}