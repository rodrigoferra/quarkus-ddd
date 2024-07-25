package com.dolap.quarkus.ddd.infrastructure.exception;

import com.dolap.quarkus.ddd.infrastructure.configuration.MessagePropertyReader;
import com.rodrigof.ddd.domain.member.exception.BusinessException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

    @Inject
    MessagePropertyReader messagePropertyReader;

    @Override
    public Response toResponse(BusinessException exception) {
        String errorMessage = messagePropertyReader.getMessage(exception.getMessageKey());
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
    }

}
