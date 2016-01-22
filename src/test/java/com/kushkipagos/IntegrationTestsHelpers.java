package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
***REMOVED***

/**
 * Created by lmunda on 1/21/16 16:16.
 */
public class IntegrationTestsHelpers {

    public static Kushki setupKushki() throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        String merchantId = "10000001408518323354818001";
        String language = "es";
        String currency = "USD";
        return new Kushki(merchantId, language, currency);
***REMOVED***

    public static Transaction getValidTokenTransaction(Kushki kushki) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException {
        Map<String, String> cardParams = new HashMap<>(5);
        cardParams.put("name", "John Doe");
        cardParams.put("number", "4111111111111111");
        cardParams.put("expiry_month", "12");
        cardParams.put("expiry_year", "20");
        cardParams.put("cvv", "123");
        return kushki.requestToken(cardParams);
***REMOVED***

    public static void assertsTransaction(Transaction transaction, Boolean isSuccessful,
                                          String expectedMessage, String expectedCode) {
        assertThat(transaction.isSuccessful(), is(isSuccessful));
        assertThat(transaction.getResponseText(), is(expectedMessage));
        assertThat(transaction.getResponseCode(), is(expectedCode));
***REMOVED***

    public static void assertsValidTransaction(Transaction transaction) {
        assertsTransaction(transaction, true, "Transacción aprobada", "000");
***REMOVED***

***REMOVED***
