package com.medicalRecords.MedicalRecordsSpringBootAPIRest.Exceptions;



import com.medicalRecords.MedicalRecordsSpringBootAPIRest.DTO.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        /**
         * This function handles the exception when a resource 
         * is not found and returns a custom errorresponse.
         * 
         * @param exception The "exception" parameter is of type
         *  ResourceNotFoundException andrepresents the exception that was thrown.
         * @param webRequest The `webRequest` parameter is an object that represents 
         * the current HTTP request. It provides methods to access information 
         * about the request,  such as the request
         * URL, headers, and query parameters. In this case, 
         * it is used to get the description of the
         * request, which is passed to the `Error
         * @return The method is returning a ResponseEntity object 
         * with a generic type of ErrorDetails.
         */
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
            ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(), webRequest.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

        /**
         * This function handles exceptions of type MedicalRecordsAppException
         *  and returns a
         * ResponseEntity containing an ErrorDetails object with the exception message and request
         * description.
         * 
         * @param exception The "exception" parameter is an instance 
         * of the MedicalRecordsAppException
         * class, which is the exception that was thrown in the application.
         * @param webRequest The `webRequest` parameter is an object 
         * that represents the current HTTP
         * request. It provides methods to access information 
         * about the request, such as the request
         * URL, headers, and parameters. In this code snippet, 
         * it is used to get the description of the
         * request, which is then included in the `
         * @return The method is returning a ResponseEntity object
         *  with a generic type of ErrorDetails.
         */
        @ExceptionHandler(MedicalRecordsAppException.class)
        public ResponseEntity<ErrorDetails> handleBlogAppException(MedicalRecordsAppException exception, WebRequest webRequest){
            ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(), webRequest.getDescription(false));
            return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
        }

        /**
         * This Java function handles global exceptions and returns an 
         * error response with details.
         * 
         * @param exception The "exception" parameter is the exception object that was thrown during
         * the execution of the code. It contains information about the exception, such as the error
         * message and the stack trace.
         * @param webRequest The `webRequest` parameter is an object that represents the current web
         * request being handled. It provides methods to access information about the request, such as
         * the request URL, headers, and parameters. In this case, it is used to get a description of
         * the request for inclusion in the error details.
         * @return The method is returning a ResponseEntity object containing an ErrorDetails object
         * and an HTTP status code of INTERNAL_SERVER_ERROR.
         */
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,WebRequest webRequest){
            ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(), webRequest.getDescription(false));
            return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
        }


        /**
         * This function handles method argument validation errors and returns a ResponseEntity object
         * with a map of field errors and their corresponding error messages.
         * 
         * @param ex The MethodArgumentNotValidException object that was thrown.
         * @param headers The HttpHeaders object contains the headers of the HTTP response.
         * @param status The HTTP status code to be returned in the response.
         * @param request The `request` parameter represents the current web request being handled by
         * the controller. It provides access to information such as the request URL, headers, and
         * other request-specific details.
         * @return The method is returning a ResponseEntity object with a generic type of Object.
         */
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                    HttpHeaders headers, HttpStatus status, WebRequest request) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String nameField = ((FieldError)error).getField();
                String message = error.getDefaultMessage();

                errors.put(nameField, message);
            });

            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        }
}
