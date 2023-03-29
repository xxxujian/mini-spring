package com.minis;

import lombok.Data;

@Data
public class BeanDefination {
    private String id;
    private String className;

    public BeanDefination(String id, String className) {
        this.id = id;
        this.className = className;
    }
}
