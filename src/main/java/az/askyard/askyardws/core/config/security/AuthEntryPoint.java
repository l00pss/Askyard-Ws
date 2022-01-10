package az.askyard.askyardws.core.config.security;

import az.askyard.askyardws.core.concretes.utilities.messages.error.UserErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Vugar Mammadli
 */
public class AuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), UserErrorMessages.USER_NOT_FOUND.getValue());
    }
}
