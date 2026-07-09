package com.example.form;

import com.example.enums.PositionName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PositionCreateOrUpdateForm {
    private Integer id;
    private PositionName name;
}
