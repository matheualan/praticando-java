package br.com.lojaonline.util;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateUtil {

    public String dateFormatted(LocalDateTime localDateFormat) {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(localDateFormat);
    }

}
