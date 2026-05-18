package sn.edu.isepat.tic.dbe.p6.GestionScolarite;


import sn.edu.isepat.tic.dbe.p6.GestionScolarite.dto.ErrorResponse;

import java.time.LocalDateTime;

public class ApiException extends RuntimeException {
    private ErrorResponse errorResponse;

    public ApiException(Integer status, String message) {
        super("code : "+status+" msg"+message);
        errorResponse=new ErrorResponse(status, message, LocalDateTime.now());
    }

}
