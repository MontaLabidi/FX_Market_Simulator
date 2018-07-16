package FX.Market_Simulator.user;

import javax.ws.rs.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.nio.file.AccessDeniedException;
import javax.persistence.EntityNotFoundException;


@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	private ResponseEntity<Object> buildResponseEntity(ApiCustomResponse apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
	 	@ExceptionHandler(BadRequestException.class)
	   protected ResponseEntity<Object> handleException(
	           Exception ex) {
	 		ApiCustomResponse apiError = new ApiCustomResponse(HttpStatus.NOT_FOUND);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }
	 @ExceptionHandler(AccessDeniedException.class)
	 protected ResponseEntity<Object> handleAccessDeniedException(
			 AccessDeniedException ex) {
	       ApiCustomResponse apiError = new ApiCustomResponse(HttpStatus.FORBIDDEN);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }
	 @ExceptionHandler(EntityNotFoundException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
	           EntityNotFoundException ex) {
	       ApiCustomResponse apiError = new ApiCustomResponse(HttpStatus.NOT_FOUND);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	 }
}

    
    