package in.capgemini.onlineplantnurseryonline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlantIdNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public PlantIdNotFoundException() {
		super();
	}
	public PlantIdNotFoundException(String msg) {
		super(msg);
	}
}