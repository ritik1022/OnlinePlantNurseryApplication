package in.capgemini.onlineplantnurseryonline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	  private ResponseEntity<Object> handleDepartmentIdException(PlanterIdException ex,WebRequest request) {
	    PlanterIdExceptionResponse errorMessage=new PlanterIdExceptionResponse(ex.getMessage());
	    return new ResponseEntity<Object>(errorMessage,HttpStatus.BAD_REQUEST); 
	  }

}
