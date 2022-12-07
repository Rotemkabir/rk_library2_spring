package com.jb.authour.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrDetails {

    private final String key = "Java 151";
    private String value;
}
