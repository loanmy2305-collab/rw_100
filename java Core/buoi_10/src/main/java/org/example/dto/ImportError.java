package org.example.dto;

import java.util.List;

public class ImportError {
    private  String line; //  dữ liệu trong row trên file csv
    private List<String> mesage;

    public ImportError(){

    }

    public ImportError(String line, List<String> mesage) {
        this.line = line;
        this.mesage = mesage;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public List<String> getMesage() {
        return mesage;
    }

    public void setMesage(List<String> mesage) {
        this.mesage = mesage;
    }
}
