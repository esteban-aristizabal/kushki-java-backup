package com.kushkipagos.unit;

import com.kushkipagos.KushkiException;
import com.kushkipagos.Validations;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
***REMOVED***
import org.junit.runner.RunWith;

import static com.kushkipagos.commons.TestsHelpers.getRandomDouble;
import static org.hamcrest.CoreMatchers.is;
***REMOVED***

@RunWith(JUnitParamsRunner.class)
public class ValidationsTest {

***REMOVED***
    @Parameters(method = "invalidNumbersAndExceptionMessages")
    public void shouldThrowKushkiExceptionIfNumberIsInvalid(Double valor, String exceptionMessage) {
        Exception exception = null;
***REMOVED***
            Validations.validateNumber(valor, 1, 12, "El valor");
***REMOVED*** catch (KushkiException e) {
            exception = e;
***REMOVED***
        Assert.assertNotNull(exception);
        assertThat(exception.getMessage(), is(exceptionMessage));
***REMOVED***

    @SuppressWarnings("unused")
    private Object[][] invalidNumbersAndExceptionMessages() {
        Double tooLong = getRandomDouble(1000000000000.0, 9999999999999999999.9);
        Double negative = -getRandomDouble(1.0, 150.0);
        return new Object[][]{
                {tooLong, "El valor debe tener 12 o menos dígitos"***REMOVED***,
                {negative, "El valor debe ser superior o igual a 1"***REMOVED***,
                {0.0, "El valor debe ser superior o igual a 1"***REMOVED***,
                {null, "El valor no puede ser un valor nulo"***REMOVED***
***REMOVED***;
***REMOVED***
***REMOVED***
