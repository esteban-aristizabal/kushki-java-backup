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
    public void shouldReturnSuccessfulVoidTransaction_TC_014() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        Transaction tokenTransaction = IntegrationTestsHelpers.getValidTokenTransaction(kushki);
        Double amount = TestsHelpers.getRandomAmount();
        String token = tokenTransaction.getToken();
        Transaction chargeTransaction = kushki.charge(token, amount);
        String ticket = chargeTransaction.getTicketNumber();

        Transaction voidTransaction = kushki.voidCharge(ticket, amount);

        assertThat(tokenTransaction.isSuccessful(), is(true));
        assertThat(chargeTransaction.isSuccessful(), is(true));
        assertThat(voidTransaction.isSuccessful(), is(true));
        assertThat(voidTransaction.getResponseText(), is("Transacción aprobada"));
        assertThat(voidTransaction.getResponseCode(), is("000"));
***REMOVED***

***REMOVED***
    public void shouldReturnFailedVoidTransactionNoTicket_TC_018() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        Transaction tokenTransaction = IntegrationTestsHelpers.getValidTokenTransaction(kushki);
        Double amount = TestsHelpers.getRandomAmount();

        Transaction voidTransaction = kushki.voidCharge("", amount);

        assertThat(tokenTransaction.isSuccessful(), is(true));
        assertThat(voidTransaction.isSuccessful(), is(false));
        assertThat(voidTransaction.getResponseText(), is("El número de ticket de la transacción es requerido"));
        assertThat(voidTransaction.getResponseCode(), is("705"));
***REMOVED***

***REMOVED***
    public void shouldReturnFailedVoidTransactionInvalidTicket_TC_019() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        Double amount = TestsHelpers.getRandomAmount();
        String ticket = "153633977318400068";

        Transaction voidTransaction = kushki.voidCharge(ticket, amount);

        assertThat(voidTransaction.isSuccessful(), is(false));
        assertThat(voidTransaction.getResponseText(), is("Transacción no encontrada"));
        assertThat(voidTransaction.getResponseCode(), is("222"));
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
    public void shouldReturnFailedVoidTransactionAfterRefundingCharge_TC_025() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        Transaction tokenTransaction = IntegrationTestsHelpers.getValidTokenTransaction(kushki);
        Double amount = TestsHelpers.getRandomAmount();
        String token = tokenTransaction.getToken();
        Transaction chargeTransaction = kushki.charge(token, amount);
        String ticket = chargeTransaction.getTicketNumber();
        Transaction refundTransaction = kushki.refundCharge(ticket, amount);

        Transaction voidTransaction = kushki.voidCharge(ticket, amount);

        assertThat(tokenTransaction.isSuccessful(), is(true));
        assertThat(chargeTransaction.isSuccessful(), is(true));
        assertThat(refundTransaction.isSuccessful(), is(true));
        assertThat(voidTransaction.isSuccessful(), is(false));
        assertThat(voidTransaction.getResponseText(), is("Anulación de venta no permitida"));
        assertThat(voidTransaction.getResponseCode(), is("231"));
***REMOVED***
***REMOVED***
