package com.example.demo.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Locale;
import java.util.Map;

@Data
// Eger dönüşte null varsa gösterme
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResult {
    private int status;
    private String path;
    private String message;
    private Map<String, String> validationErrors;
    private String createdDate = nowDate();

    public ApiResult(int status, String path, String message) {
        this.status = status;
        this.path = path;
        this.message = message;
    }

    private String nowDate(){
        Locale locale = Locale.US;
        Locale.Builder localeBuilder = new Locale.Builder();
        localeBuilder.setLocale(locale);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",locale);
        return simpleDateFormat.format(new Date());
    }
}
