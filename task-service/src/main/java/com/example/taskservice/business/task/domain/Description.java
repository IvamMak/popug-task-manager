package com.example.taskservice.business.task.domain;

import com.example.taskservice.business.task.exception.JiraIdInDescriptionException;
import lombok.Getter;

@Getter
public class Description {
    private final String text;

    public Description(String text) {
        if (text.contains("]") || text.contains("[")) {
            throw new JiraIdInDescriptionException(text);
        }
        this.text = text;
    }
}
