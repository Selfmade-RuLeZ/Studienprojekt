package de.hsesslingen.StudienprojektKneisel.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Manufacturer Not Found")
public class ManufacturerNotFoundException extends Exception{
}
