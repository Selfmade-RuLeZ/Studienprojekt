package de.hsesslingen.StudienprojektKneisel.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "RepairShop Not Found")
public class RepairShopNotFoundException extends Exception{
}
