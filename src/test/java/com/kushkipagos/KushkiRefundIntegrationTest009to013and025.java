package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
***REMOVED***

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static com.kushkipagos.IntegrationTestsHelpers.assertsTransaction;
import static com.kushkipagos.IntegrationTestsHelpers.assertsValidTransaction;
import static com.kushkipagos.IntegrationTestsHelpers.getValidTokenTransaction;
import static com.kushkipagos.IntegrationTestsHelpers.setupKushki;


/**
 * Created by lmunda on 1/22/16 10:33.
 */
public class KushkiRefundIntegrationTest009to013and025 {
    private Kushki kushki;
    private Transaction tokenTransaction;
    private Transaction chargeTransaction;
    private Transaction refundTransaction;
    private Double amount;
    private String ticket;

    @Before
    public void setUp() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        kushki = setupKushki();

        tokenTransaction = getValidTokenTransaction(kushki);
        amount = TestsHelpers.getRandomAmount();
        String token = tokenTransaction.getToken();
        chargeTransaction = kushki.charge(token, amount);
        ticket = chargeTransaction.getTicketNumber();

        refundTransaction = kushki.refundCharge(ticket, amount);
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulRefundTransactionTC009() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(chargeTransaction);
        assertsValidTransaction(refundTransaction);
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulRefundTransactionNoTicketTC012() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        Transaction refundTransaction = kushki.refundCharge("", amount);

        assertsTransaction(refundTransaction, false, "El número de ticket de la transacción es requerido", "705");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedRefundTransactionInvalidTicketTC013() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        String ticket = "153633977318400068";

        Transaction refundTransaction = kushki.refundCharge(ticket, amount);

        assertsTransaction(refundTransaction, false, "Transacción no encontrada", "222");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedVoidTransactionAfterRefundingChargeTC025() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        Transaction voidTransaction = kushki.voidCharge(ticket, amount);

        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(chargeTransaction);
        assertsValidTransaction(refundTransaction);
        assertsTransaction(voidTransaction, false, "Anulación de venta no permitida", "231");
***REMOVED***
***REMOVED***
