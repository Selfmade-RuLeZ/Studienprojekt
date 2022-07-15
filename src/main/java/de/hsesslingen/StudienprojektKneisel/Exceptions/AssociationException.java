package de.hsesslingen.StudienprojektKneisel.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Association does not fit to entities")
public class AssociationException extends Exception{
}
