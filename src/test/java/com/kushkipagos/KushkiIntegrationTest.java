package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
***REMOVED***

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import static org.hamcrest.CoreMatchers.is;
***REMOVED***

public class KushkiIntegrationTest {
    private Kushki kushki;
    private static String currency = "USD";

    @Before
    public void setUp() throws Exception {
        String merchantId = "10000000123454545454546546";
        String language = "es";
        kushki = new Kushki(merchantId, language, currency);
***REMOVED***

***REMOVED***
    public void shouldReturnASuccessfulTransaction() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Double amount = TestsHelpers.getRandomAmount();
        String token = "s25s784a87ad497af797a48sdg7rhy4d";
        Transaction transaction = kushki.charge(token, amount);
        assertThat(transaction.isSuccessful(), is(true));
***REMOVED***

***REMOVED***
    public void shouldReturnANonSuccessfulTransaction() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String token = "123456789-declined";
        Double amount = TestsHelpers.getRandomAmount();
        Transaction transaction = kushki.charge(token, amount);
        assertThat(transaction.isSuccessful(), is(false));
***REMOVED***
***REMOVED***
