package storageOfTheAlliance;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import storageOfTheAlliance.domain.dtos.DTO;

@ControllerAdvice
public class REEH extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
	public ResponseEntity<Object> handleSQLIntegrConstViolException(Exception e, WebRequest r) {
		return handleExceptionInternal(e, new DTO("Samanniminen säilö on jo olemassa!"), new HttpHeaders(),
				HttpStatus.CONFLICT, r);
	}

}
