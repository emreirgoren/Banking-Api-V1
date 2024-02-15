package com.bankingapp.model.dto.exceptionsDtos;

import com.bankingapp.model.enums.ExceptionStatusCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ExceptionResponseDto {

    private int exceptionStatusCode;
    private String message;
    private HttpStatus httpstatus;
    private ExceptionStatusCode exceptionStatusMessage;

}
