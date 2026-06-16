package org.example.backend.service.impl;


import org.example.backend.service.IPasswordService;

public class PasswordServiceImpl implements IPasswordService {
    @Override
    public boolean checkPassword(String password) {
        String regex = "^(?=.*[A-Z])" +     // 1 chữ hoa
                        "(?=.*[a-z])" +     // 1 chữ thường
                        "(?=.*\\d)" +       //1 chữ số
                        "(?=.*[@#$%^&+!])" +    // 1 ký tự đặc biệt
                        "(?!.*\\s)" +       // không có  khoảng trống
                        ".{8,20}$";         // độ dài 8->20
        return password.matches(regex);
    }
}
