package pl.kowalski.bugtracker.Service;

import org.springframework.security.core.AuthenticationException;

public class EmailNotFoundException extends AuthenticationException {

    public EmailNotFoundException(String email) {
        super(email);
    }
}
