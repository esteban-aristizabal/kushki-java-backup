package com.kushkipagos.unit;

import com.kushkipagos.Amount;
import com.kushkipagos.KushkiException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
***REMOVED***
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.kushkipagos.commons.TestsHelpers.getRandomDouble;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by dvillaci on 4/14/16.
 */
@RunWith(JUnitParamsRunner.class)
public class AmountTest {

***REMOVED***
    public void shouldTransformToHash() throws KushkiException {
        Amount amount = new Amount(0d, 0d, 0d, 0d);
        Map<String, String> result = amount.toHash();
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("Subtotal_IVA", "0.00");
        expectedResult.put("Subtotal_IVA0", "0.00");
        expectedResult.put("IVA", "0.00");
        expectedResult.put("ICE", "0.00");
        expectedResult.put("Total_amount", "0.00");
        assertThat(result, is(expectedResult));
***REMOVED***

***REMOVED***
    public void shouldTransformToHashWithValidInputs() throws KushkiException {
        Double subtotalIVA = getRandomDouble(1d, 50d);
        Double iva = getRandomDouble(1d, 50d);
        Double subtotalIVA0 = getRandomDouble(1d, 50d);
        Double ice = getRandomDouble(1d, 50d);
        Double total = subtotalIVA + iva + subtotalIVA0 + ice;

        Amount amount = new Amount(subtotalIVA, iva, subtotalIVA0, ice);
        Map<String, String> result = amount.toHash();
        Map<String, String> expectedResult = new HashMap<>();

        expectedResult.put("Subtotal_IVA", getStringValue(subtotalIVA));
        expectedResult.put("Subtotal_IVA0", getStringValue(subtotalIVA0));
        expectedResult.put("IVA", getStringValue(iva));
        expectedResult.put("ICE", getStringValue(ice));
        expectedResult.put("Total_amount", getStringValue(total));
        assertThat(result, is(expectedResult));
***REMOVED***

***REMOVED***
    @Parameters(method = "invalidAmountsAndExceptionMessages")
    public void shouldThrowKushkiExceptionIfAmountIsInvalid(Amount amount, String exceptionMessage) {
        Exception exception = null;
***REMOVED***
            amount.toHash();
***REMOVED*** catch (KushkiException e) {
            exception = e;
***REMOVED***
        assertNotNull("Exception should not be null", exception);
        assertThat("Amount should be invalid because: " + exceptionMessage, exception.getMessage(), is(exceptionMessage));
***REMOVED***

    private static String getStringValue(Double amount) {
        return String.format(Locale.ENGLISH, "%.2f", amount);
***REMOVED***

    @SuppressWarnings("unused")
    private Object[][] invalidAmountsAndExceptionMessages() {
        Amount invalidSubtotalIVA = new Amount(-2d, 0d, 0d, 0d);
        Amount invalidIva = new Amount(0d, -2d, 0d,  0d);
        Amount invalidSubtotalIVA0 = new Amount(0d, 0d, -2d,  0d);
        Amount invalidIce = new Amount(0d, 0d, 0d,  -2d);
        return new Object[][]{
                {invalidSubtotalIVA, "El subtotal IVA debe ser superior o igual a 0"***REMOVED***,
                {invalidSubtotalIVA0, "El subtotal IVA 0 debe ser superior o igual a 0"***REMOVED***,
                {invalidIva, "El IVA debe ser superior o igual a 0"***REMOVED***,
                {invalidIce, "El ICE debe ser superior o igual a 0"***REMOVED***,
***REMOVED***;
***REMOVED***
***REMOVED***
