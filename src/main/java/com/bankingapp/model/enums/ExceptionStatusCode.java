package com.bankingapp.model.enums;

import lombok.Getter;


@Getter
public enum ExceptionStatusCode {

    /**
     * İşlem başaralı
     */
    SUCCESS(100,"SUCCESS"),

    /**
     * İşlem basarısız
     */
    ERROR(500,"ERROR"),

    /**
     * Müsteri zaten mevcut hatasını ifade eder.
     */
    CUSTOMER_ALREADY_EXISTS(600,"CUSTOMER_ALREADY_EXISTS"),

    /**
     * Hesap bulunamadı hatasını ifade eder.
     */
    ACCOUNT_NOT_FOUND(601,"ACCOUNT_NOT_FOUND"),

    /**
     * Geçersiz tutar hatası ifade eder.
     */
    INVALID_ACCOUNT(602,"INVALID_ACCOUNT"),

    /**
     * Yetersiz bakiye hatasını ifade eder.
     */
    INSUFFICIENT_BALANCE(603,"INSUFFICIENT_BALANCE"),

    ;


    private int statusCode;
    private String statusMessage;

    ExceptionStatusCode(int statusCode,String statusMessage){
        this.statusCode=statusCode;
        this.statusMessage=statusMessage;
    }

}
