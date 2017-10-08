package com.kushkipagos.unit;


import com.kushki.*;
import com.kushki.Enum.KushkiEnvironment;
import com.kushki.TO.Amount;
import com.kushki.TO.ExtraTaxes;
import org.junit.Before;
***REMOVED***

import org.skyscreamer.jsonassert.JSONAssert;
***REMOVED***

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.*;


import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class KushkiChargeParameterBuilderTest {
    private Kushki kushki;

    @Before
    public void setUp() throws Exception {
        String merchantId = randomAlphabetic(10);
        String language = randomAlphabetic(2);
        String currency = randomAlphabetic(3);
        kushki = new Kushki(merchantId, language, currency, KushkiEnvironment.TESTING);
***REMOVED***


***REMOVED***
    public void happyTestWithoutMetadataMonthAndCurrency() {
        String token = randomAlphabetic(10);
***REMOVED***
            JSONObject response = ParametersBuilder.getChargeParameters(this.kushki, token, new Amount(100d, 12d, 0d, 0d), null, null);
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"amount\":{\"subtotalIva0\":0,\"iva\":12,\"subtotalIva\":100,\"ice\":0,\"currency\":\"" + kushki.getCurrency() + "\"***REMOVED***,\"token\":\"" + token + "\"***REMOVED***", response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***

***REMOVED***
    public void happyTestWithExtraTax() {
        String token = randomAlphabetic(10);
***REMOVED***
            Amount amount = new Amount(100d, 12d, 0d, 0d);
            amount.setExtraTaxes(new ExtraTaxes(1d, 2d, 3d, 4d));
            JSONObject response = ParametersBuilder.getChargeParameters(this.kushki, token, amount, null, null);
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"amount\":{\"subtotalIva0\":0,\"iva\":12,\"subtotalIva\":100,\"ice\":0,\"extraTaxes\":" +
                            "{\"agenciaDeViaje\":3,\"propina\":1,\"iac\":4,\"tasaAeroportuaria\":2***REMOVED***,\"currency\":\"" + kushki.getCurrency() + "\"***REMOVED***,\"token\":\"" + token + "\"***REMOVED***", response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***


***REMOVED***
    public void happyTestWithoutMetadataAndMonthWithCurrency() {
        String token = randomAlphabetic(10);
***REMOVED***
            JSONObject response = ParametersBuilder.getChargeParameters(this.kushki, token, new Amount(100d, 12d, 0d, 0d), null, null);
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"amount\":{\"subtotalIva0\":0,\"iva\":12,\"subtotalIva\":100,\"ice\":0,\"currency\":\"" + kushki.getCurrency() + "\"***REMOVED***,\"token\":\"" + token + "\"***REMOVED***", response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***

***REMOVED***
    public void happyTestMetadataAndMonth() {
        String token = randomAlphabetic(10);
***REMOVED***

            HashMap<String, String> metadata = new HashMap<String, String>();
            metadata.put("a", "b");
            metadata.put("c", "d");
            metadata.put("c", "d");
            JSONObject response = ParametersBuilder.getChargeParameters(this.kushki, token, new Amount(100d, 12d, 0d, 0d), 3, new JSONObject(metadata));
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"months\":3,\"amount\":{\"subtotalIva0\":0,\"iva\":12,\"subtotalIva\":100,\"ice\":0,\"currency\":\"" + kushki.getCurrency() + "\"***REMOVED***,\"token\":\"" + token + "\",\"metadata\":{\"a\":\"b\",\"c\":\"d\"***REMOVED******REMOVED***", response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***

***REMOVED***
    public void ARequiredFieldIsNull() {
        String token = randomAlphabetic(10);
***REMOVED***
            HashMap<String, String> metadata = new HashMap<String, String>();
            metadata.put("a", "b");
            metadata.put("c", "d");
            metadata.put("c", "d");
            JSONObject response = ParametersBuilder.getChargeParameters(this.kushki, token, null, null, new JSONObject(metadata));
            assertThat("this line must be unreachable", false);
***REMOVED*** catch (KushkiException e) {
            assertThat("this must ***REMOVED***re a exception", true);
***REMOVED***
***REMOVED***
***REMOVED***

