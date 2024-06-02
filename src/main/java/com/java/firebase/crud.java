package com.java.firebase;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter

public class crud {
    private String name;
    private String id;
    private Map<String, Integer> subjectMarks;
}
