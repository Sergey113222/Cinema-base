package info.movietrash.cinemabase.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class AopExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDto> handleException(ResourceNotFoundException ex) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorMessage(ex.getMessage());
        exceptionDto.setStatus(NOT_FOUND.value());
        exceptionDto.setTimestamp(LocalDateTime.now());

        log.error("Caught ResourceNotFoundException - {}", ex.getMessage());

        return ResponseEntity.status(NOT_FOUND).body(exceptionDto);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDto> handleException(Exception ex) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrorMessage(ex.getMessage());
        exceptionDto.setStatus(BAD_REQUEST.value());
        exceptionDto.setTimestamp(LocalDateTime.now());

        log.error("Caught another exception exception: {}", ex.getMessage());

        return ResponseEntity.status(BAD_REQUEST).body(exceptionDto);
    }
}
