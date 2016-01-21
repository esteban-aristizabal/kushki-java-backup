package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
***REMOVED***
import org.junit.runner.RunWith;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import static com.kushkipagos.TestsHelpers.getRandomDouble;
import static com.kushkipagos.TestsHelpers.getRandomInteger;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.is;
***REMOVED***

/**
 * Created by lmunda on 1/21/16 14:55.
 */

@RunWith(JUnitParamsRunner.class)
public class ValidationsTest {
    private Kushki kushki;

    @Before
    public void setUp() throws Exception {
        String merchantId = randomAlphabetic(10);
        String language = randomAlphabetic(2);
        String currency = randomAlphabetic(10);
        kushki = new Kushki(merchantId, language, currency);
***REMOVED***

***REMOVED***
    @Parameters(method = "invalidAmountsAndExceptionMessages")
    public void shouldThrowKushkiExceptionIfChargeAmountIsInvalid(Double amount, String exceptionMessage) {
        Exception exception = null;
***REMOVED***
            String token = randomAlphabetic(10);
            kushki.charge(token, amount);
***REMOVED*** catch (KushkiException | BadPaddingException | JsonProcessingException | IllegalBlockSizeException e) {
            exception = e;
***REMOVED***
        Assert.assertNotNull(exception);
        assertThat(exception.getMessage(), is(exceptionMessage));
***REMOVED***

***REMOVED***
    @Parameters(method = "invalidAmountsAndExceptionMessages")
    public void shouldThrowKushkiExceptionIfVoidChargeAmountIsInvalid(Double amount, String exceptionMessage) {
        Exception exception = null;
***REMOVED***
            String token = randomAlphabetic(10);
            kushki.voidCharge(token, amount);
***REMOVED*** catch (KushkiException | BadPaddingException | JsonProcessingException | IllegalBlockSizeException e) {
            exception = e;
***REMOVED***
        Assert.assertNotNull(exception);
        assertThat(exception.getMessage(), is(exceptionMessage));
***REMOVED***

***REMOVED***
    @Parameters(method = "invalidAmountsAndExceptionMessages")
    public void shouldThrowKushkiExceptionIfRefundChargeAmountIsInvalid(Double amount, String exceptionMessage) {
        Exception exception = null;
***REMOVED***
            String token = randomAlphabetic(10);
            kushki.refundCharge(token, amount);
***REMOVED*** catch (KushkiException | BadPaddingException | JsonProcessingException | IllegalBlockSizeException e) {
            exception = e;
***REMOVED***
        Assert.assertNotNull(exception);
        assertThat(exception.getMessage(), is(exceptionMessage));
***REMOVED***

***REMOVED***
    @Parameters(method = "invalidParametersAndExceptionMessages")
    public void shouldThrowKushkiExceptionIfDeferredChargeParametersAreInvalid(Double amount, Integer months, Double interest, String exceptionMessage) {
        Exception exception = null;
***REMOVED***
            String token = randomAlphabetic(10);
            kushki.deferredCharge(token, amount, months, interest);
***REMOVED*** catch (KushkiException | BadPaddingException | JsonProcessingException | IllegalBlockSizeException e) {
            exception = e;
***REMOVED***
        Assert.assertNotNull(exception);
        assertThat(exception.getMessage(), is(exceptionMessage));
***REMOVED***

    @SuppressWarnings("unused")
    private Object[][] invalidAmountsAndExceptionMessages() {
        Double tooLongAmount = getRandomDouble(1000000000000.0, 9999999999999999999.9);
        Double negativeAmount = -getRandomDouble(1.0, 150.0);
        return new Object[][]{
                {tooLongAmount, "El monto debe tener 12 o menos dígitos"***REMOVED***,
                {negativeAmount, "El monto debe ser superior a 0"***REMOVED***,
                {0.0, "El monto debe ser superior a 0"***REMOVED***,
                {null, "El monto no puede ser un valor nulo"***REMOVED***
***REMOVED***;
***REMOVED***

    @SuppressWarnings("unused")
    private Object[][] invalidParametersAndExceptionMessages() {
        Double tooLongAmount = getRandomDouble(1000000000000.0, 9999999999999999999.9);
        Double negativeAmount = -getRandomDouble(1.0, 150000000.0);
        Double validAmount = getRandomDouble(1.0, 150000000.0);

        Integer tooLongMonths = getRandomInteger(100, 9999);
        Integer negativeMonths = -getRandomInteger(1, 99);
        Integer validMonths = getRandomInteger(1, 99);

        Double tooLongInterest = getRandomDouble(100.0, 9999999.9);
        Double negativeInterest = -getRandomDouble(0.01, 99.99);
        Double validInterest = getRandomDouble(0.01, 99.99);
        return new Object[][]{
                {tooLongAmount, validMonths, validInterest, "El monto debe tener 12 o menos dígitos"***REMOVED***,
                {negativeAmount, validMonths, validInterest, "El monto debe ser superior a 0"***REMOVED***,
                {0.0, validMonths, validInterest, "El monto debe ser superior a 0"***REMOVED***,
                {null, validMonths, validInterest, "El monto no puede ser un valor nulo"***REMOVED***,

                {validAmount, tooLongMonths, validInterest, "El número de meses debe tener 2 o menos dígitos"***REMOVED***,
                {validAmount, negativeMonths, validInterest, "El número de meses debe ser superior a 0"***REMOVED***,
                {validAmount, 0, validInterest, "El número de meses debe ser superior a 0"***REMOVED***,
                {validAmount, null, validInterest, "El número de meses no puede ser un valor nulo"***REMOVED***,

                {validAmount, validMonths, tooLongInterest, "La tasa de interés debe tener 5 o menos dígitos"***REMOVED***,
                {validAmount, validMonths, negativeInterest, "La tasa de interés debe ser superior a 0"***REMOVED***,
                {validAmount, validMonths, 0.0, "La tasa de interés debe ser superior a 0"***REMOVED***,
                {validAmount, validMonths, null, "La tasa de interés no puede ser un valor nulo"***REMOVED***
***REMOVED***;
***REMOVED***
***REMOVED***
