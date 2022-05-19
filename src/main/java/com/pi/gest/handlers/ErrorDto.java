package com.pi.gest.handlers;

import com.pi.gest.exception.Errors;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {


    private Integer httpCode;
    private Errors code;
    private String message;
    private List<String> errors = new ArrayList<>();
}
