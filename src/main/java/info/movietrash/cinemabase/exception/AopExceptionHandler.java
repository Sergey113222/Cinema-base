package info.movietrash.cinemabase.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDto>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<ExceptionDto> exceptionDtoList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setErrorMessage(String.format("%s - %s", fieldName, errorMessage));
            exceptionDto.setStatus(4001);
            exceptionDto.setTimestamp(LocalDateTime.now());
            exceptionDtoList.add(exceptionDto);
        });
        return ResponseEntity.badRequest().body(exceptionDtoList);
    }
}
