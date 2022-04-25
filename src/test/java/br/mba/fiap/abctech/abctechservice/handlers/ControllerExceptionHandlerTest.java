package br.mba.fiap.abctech.abctechservice.handlers;

import br.mba.fiap.abctech.abctechservice.handler.ControllerExceptionHandler;
import br.mba.fiap.abctech.abctechservice.handler.exception.MaxAssistsException;
import br.mba.fiap.abctech.abctechservice.handler.exception.MinimumAssistsRequiredException;
import br.mba.fiap.abctech.abctechservice.repository.AssistanceRepository;
import br.mba.fiap.abctech.abctechservice.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.net.BindException;

@SpringBootTest
public class ControllerExceptionHandlerTest {
    private ControllerExceptionHandler controllerExceptionHandler;
    @Mock
    private MethodParameter methodParameter;
    @Mock
    private BindingResult bindingResult;

    @BeforeEach
    void setUp() {
        controllerExceptionHandler = new ControllerExceptionHandler();
    }

    @Test
    void testingMinAssistRequired() {
        MinimumAssistsRequiredException minimumAssistsRequiredException = new MinimumAssistsRequiredException("Mensagem Mock", "Descrição Mock");
        Assertions.assertNotNull(controllerExceptionHandler.errorMinAssistRequired(minimumAssistsRequiredException));
    }

    @Test
    void testingValidationErrorHandler() {
        MethodArgumentNotValidException methodArgumentNotValidException = new  MethodArgumentNotValidException(methodParameter, bindingResult);
        Assertions.assertNotNull(controllerExceptionHandler.validationErrorHandler(methodArgumentNotValidException));
     }


}

