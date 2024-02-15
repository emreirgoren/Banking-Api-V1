package com.bankingapp.exception.handler;

import com.bankingapp.exception.*;
import com.bankingapp.model.dto.exceptionsDtos.ExceptionResponseDto;
import com.bankingapp.model.enums.ExceptionStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ExceptionResponseDto> customerAlreadyExistsException(CustomerAlreadyExistsException e){
        ExceptionResponseDto responseDto = ExceptionResponseDto.builder()
                .exceptionStatusCode(ExceptionStatusCode.CUSTOMER_ALREADY_EXISTS.getStatusCode())
                .message("Müsteri zaten mevcut")
                .httpstatus(HttpStatus.CONFLICT)
                .exceptionStatusMessage(ExceptionStatusCode.CUSTOMER_ALREADY_EXISTS)
                .build();
        return new ResponseEntity<>(responseDto,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponseDto> accountNotFoundException(AccountNotFoundException e){
        ExceptionResponseDto responseDto = ExceptionResponseDto.builder()
                .exceptionStatusCode(ExceptionStatusCode.ACCOUNT_NOT_FOUND.getStatusCode())
                .message("Hesap bulunamadı.")
                .httpstatus(HttpStatus.NOT_FOUND)
                .exceptionStatusMessage(ExceptionStatusCode.ACCOUNT_NOT_FOUND)
                .build();
        return new ResponseEntity<>(responseDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponseDto> invalidAmountException(InvalidAmountException e){
        ExceptionResponseDto responseDto = ExceptionResponseDto.builder()
                .exceptionStatusCode(ExceptionStatusCode.INVALID_ACCOUNT.getStatusCode())
                .message("Geçersiz Tutar")
                .httpstatus(HttpStatus.BAD_REQUEST)
                .exceptionStatusMessage(ExceptionStatusCode.INVALID_ACCOUNT)
                .build();
        return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponseDto> insufficientBalanceException(InsufficientBalanceException e){
        ExceptionResponseDto responseDto = ExceptionResponseDto.builder()
                .exceptionStatusCode(ExceptionStatusCode.INSUFFICIENT_BALANCE.getStatusCode())
                .message("Yetersiz bakiye")
                .httpstatus(HttpStatus.BAD_REQUEST)
                .exceptionStatusMessage(ExceptionStatusCode.INSUFFICIENT_BALANCE)
                .build();
        return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
    }

}




















