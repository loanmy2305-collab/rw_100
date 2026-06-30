package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "position") // mapping đến bảng dep trang DB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Position {
    @Id // đại diện cho khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment (tăng id)
    @Column(name = "position_id") // trường này cho biết là thuộc tính này map với ột dep_id trong Db
    private Integer id;

    // dep_name varchar(100) not null unique
    @Column(name = "position_name", nullable = false, unique = true, length = 100)
    private String name;
}
