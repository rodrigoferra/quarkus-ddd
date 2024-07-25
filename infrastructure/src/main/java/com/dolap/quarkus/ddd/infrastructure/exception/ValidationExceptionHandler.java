package com.dolap.quarkus.ddd.infrastructure.exception;

import com.dolap.quarkus.ddd.application.base.exception.ValidationException;
import com.dolap.quarkus.ddd.infrastructure.configuration.MessagePropertyReader;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {

    @Inject
    MessagePropertyReader messagePropertyReader;

    @Override
    public Response toResponse(ValidationException exception) {
        String errorMessage = messagePropertyReader.getMessage(exception.getMessageKey());
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
    }

}
