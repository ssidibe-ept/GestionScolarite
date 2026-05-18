package sn.edu.isepat.tic.dbe.p6.GestionScolarite.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.ApiException;
import sn.edu.isepat.tic.dbe.p6.GestionScolarite.dto.ErrorResponse;

@ControllerAdvice
public class IntercepteurException {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleException(ApiException ex) {
       return ex.getErrorResponse();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity.status(538).body("un probleme est survenu");
    }
}
