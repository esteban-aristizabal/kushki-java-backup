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

import static org.hamcrest.CoreMatchers.is;
***REMOVED***

public class KushkiIntegrationTest {
    private Kushki kushki;

    @Before
    public void setup() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        kushki = IntegrationTestsHelpers.setupKushki();
***REMOVED***

***REMOVED***
    public void shouldReturnFailedTokenTransactionInvalidMerchantId_TC_020() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        String merchantId = "abc";
        String language = "es";
        String currency = "USD";
        kushki = new Kushki(merchantId, language, currency);

        Transaction tokenTransaction = IntegrationTestsHelpers.getValidTokenTransaction(kushki);

        assertThat(tokenTransaction.isSuccessful(), is(false));
        assertThat(tokenTransaction.getResponseText(), is("ID de comercio no válido"));
        assertThat(tokenTransaction.getResponseCode(), is("201"));
***REMOVED***

***REMOVED***
    public void shouldReturnFailedTokenTransactionInvalidLanguage_TC_021() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        String merchantId = "10000001408518323354818001";
        String language = "xyz";
        String currency = "USD";
        kushki = new Kushki(merchantId, language, currency);

        Transaction tokenTransaction = IntegrationTestsHelpers.getValidTokenTransaction(kushki);

        assertThat(tokenTransaction.isSuccessful(), is(false));
        assertThat(tokenTransaction.getResponseText(), is("Indicador de idioma no válido"));
        assertThat(tokenTransaction.getResponseCode(), is("277"));
***REMOVED***

***REMOVED***
    public void shouldReturnFailedTokenTransactionInvalidCurrency_TC_023() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        String merchantId = "10000001408518323354818001";
        String language = "es";
        String currency = "xyz";
        kushki = new Kushki(merchantId, language, currency);
        Transaction tokenTransaction = IntegrationTestsHelpers.getValidTokenTransaction(kushki);
        String token = tokenTransaction.getToken();
        Double amount = 10.0;

        Transaction chargeTransaction = kushki.charge(token, amount);

        assertThat(tokenTransaction.isSuccessful(), is(true));
        assertThat(chargeTransaction.isSuccessful(), is(false));
        assertThat(chargeTransaction.getResponseText(), is("Tipo de moneda no válida"));
        assertThat(chargeTransaction.getResponseCode(), is("205"));
***REMOVED***

***REMOVED***
