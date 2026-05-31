package org.example.dto.context;

import org.example.entity.Department;

import java.util.Map;

public class DepartmentContext {
    private Map<String, Department> mapByDepartmentName;

    public DepartmentContext(Map<String, Department> mapByDepartmentName) {
        this.mapByDepartmentName = mapByDepartmentName;
    }

    public Map<String, Department> getMapByDepartmentName() {
        return mapByDepartmentName;
    }

    public void setMapByDepartmentName(Map<String, Department> mapByDepartmentName) {
        this.mapByDepartmentName = mapByDepartmentName;
    }


}
