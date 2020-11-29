package pl.kowalski.bugtracker.Security;

import org.springframework.security.core.AuthenticationException;

public class EmailNotFoundException extends AuthenticationException {

    public EmailNotFoundException(String emailNotFound) {
        super(emailNotFound);
    }
}
