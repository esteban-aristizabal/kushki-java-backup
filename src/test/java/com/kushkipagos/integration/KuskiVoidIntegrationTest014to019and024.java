***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Amount;
import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiException;
import com.kushkipagos.commons.TestsHelpers;
import com.kushkipagos.Transaction;
import org.junit.Before;
***REMOVED***

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsValidTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.getValidTokenTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.setupKushki;

/**
 * Created by lmunda on 1/22/16 10:50.
 */
public class KuskiVoidIntegrationTest014to019and024 {
    private Kushki secretKushki;
    private Transaction tokenTransaction;
    private Transaction chargeTransaction;
    private Transaction voidTransaction;
    private Amount amount;
    private String ticket;

    @Before
    public void setUp() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InterruptedException {
        Kushki kushki = setupKushki(false);
        secretKushki = setupKushki(true);

        tokenTransaction = getValidTokenTransaction(kushki);
        amount = TestsHelpers.getRandomAmount();
        String token = tokenTransaction.getToken();
        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        chargeTransaction = secretKushki.charge(token, amount);
        ticket = chargeTransaction.getTicketNumber();
        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        voidTransaction = secretKushki.voidCharge(ticket, amount);
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulVoidTransactionTC014() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(chargeTransaction);
        assertsValidTransaction(voidTransaction);
***REMOVED***

***REMOVED***
    public void shouldReturnFailedVoidTransactionNoTicketTC018() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException, InterruptedException {
        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction voidTransaction = secretKushki.voidCharge("", amount);

        assertsTransaction(voidTransaction, false, "El número de ticket de la transacción es requerido", "705");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedVoidTransactionInvalidTicketTC019() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException, InterruptedException {
        String ticket = "153633977318400068";

        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction voidTransaction = secretKushki.voidCharge(ticket, amount);

        assertsTransaction(voidTransaction, false, "Transacción no encontrada", "222");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedRefundTransactionAfterVoidingChargeTC024() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException, InterruptedException {
        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction refundTransaction = secretKushki.refundCharge(ticket, amount);

        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(chargeTransaction);
        assertsValidTransaction(voidTransaction);
        assertsTransaction(refundTransaction, false, "Transacción no encontrada", "222");
***REMOVED***
***REMOVED***
