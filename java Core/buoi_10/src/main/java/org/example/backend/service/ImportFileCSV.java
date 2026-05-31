package org.example.backend.service;

import org.example.dto.ImportError;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface ImportFileCSV<T, K, E> {
    // T là context:chứa dữ liệu để validation
    // K là entity
    // E là ốitượng map với file Csv DepartmentCsv,  accountCsv

    void validation(String line, T context, List<K> etities, List<ImportError<E>> importErrors);
    void saveAll(List<K> entities) ;
    void exportFileError(List<ImportError<E>> importErrors, String pathError);

    default String importFileCSV(String pathName, T context, String pathError) {
        // check file c tồn tại không
        File file = new File(pathName);
        if (!file.exists()) {
            return "file không tồn tai";
        }
        // dọc dữ liệu từ file và dưa dữ lệu cho repository để lưu vào DB
        if (!pathName.endsWith(".csv")) {
            return "dịnh dạng file không đuúng";
        }
        List<K> entities = new ArrayList<>();
        List<ImportError<E>> importErrors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = "";
            br.readLine();// lay dòng dau tien, bo no di
            while ((line = br.readLine()) != null) {
                // validation
                this.validation(line, context, entities, importErrors);
            }
            // luu vao DB
            this.saveAll(entities);
            // xuất ra file lỗi -ghi dữ liệu ra file
            this.exportFileError(importErrors, pathError);

    } catch (Exception e) {
           e.printStackTrace();
        }
        String message = "";
        if (importErrors.isEmpty()) {
            message = "Import thành công";
        }
        if (entities.isEmpty()) {
            message = "Import k thành công , đã xuất file lỗi " + pathError;
        }
        if (!importErrors.isEmpty() && !entities.isEmpty()) {
            message = "Import thành công" + entities.size() +
                    ", đã xuất file lỗi " + pathError;
        }
        return message;
    }


    }
