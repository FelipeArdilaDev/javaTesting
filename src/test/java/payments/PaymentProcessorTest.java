package payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void paymentIsCorrect() {

        //Preparacion de los objetos
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        //Ejecucion del metodo
        boolean result = paymentProcessor.makePayment(1000);

        //Comprobacion del resultado
        assertTrue(result);
    }

    @Test
    public void paymentIsWrong() {

        //Preparacion de los objetos
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.Error));

        //Ejecucion del metodo
        boolean result = paymentProcessor.makePayment(1000);

        //Comprobacion del resultado
        assertFalse(result);
    }
}