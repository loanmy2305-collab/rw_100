package com.example.entity;

import com.example.enums.PositionName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "position")// mapping đến bảng department trong DB
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
    @Enumerated(EnumType.STRING)
    @Column(name = "position_name")//
    private PositionName name;
}
