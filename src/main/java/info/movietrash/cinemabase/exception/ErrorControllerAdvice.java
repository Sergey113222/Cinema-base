package info.movietrash.cinemabase.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorControllerAdvice {

    @ExceptionHandler(JsonProcessingException.class)
    ResponseEntity handleException(JsonProcessingException ex) {
        log.error("Caught JsonProcessingException - {}", ex.getMessage());
        //return ResponseEntity.status(404).body(ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    ResponseEntity handleException(Throwable ex) {
        log.error("Caught unhandled exception: {}", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
