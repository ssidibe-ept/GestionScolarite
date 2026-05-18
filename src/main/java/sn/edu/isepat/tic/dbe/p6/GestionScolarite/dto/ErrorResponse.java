package sn.edu.isepat.tic.dbe.p6.GestionScolarite.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ErrorResponse(
        Integer status,
        String message,
        LocalDateTime timestamp
) {}
