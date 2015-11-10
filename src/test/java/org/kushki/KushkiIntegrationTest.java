package org.kushki;

import org.junit.Before;
***REMOVED***

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextDouble;
import static org.hamcrest.CoreMatchers.is;
***REMOVED***

public class KushkiIntegrationTest {
    private Kushki kushki;
    private static String currency = "USD";

    @Before
    public void setUp() throws Exception {
        String merchantId = randomAlphabetic(10);
        String language = "es";
        kushki = new Kushki(merchantId, language, currency);
***REMOVED***

***REMOVED***
    public void shouldReturnASuccessfulTransaction() {
        String token = randomAlphabetic(10);
        String amount = String.valueOf(nextDouble(1, 100));
        Transaction transaction = kushki.charge(token, amount);
        assertThat(transaction.isSuccessful(), is(true));
***REMOVED***

***REMOVED***
    public void shouldReturnANonSuccessfulTransaction() {
        String token = "123456789-declined";
        String amount = String.valueOf(nextDouble(1, 100));
        Transaction transaction = kushki.charge(token, amount);
        assertThat(transaction.isSuccessful(), is(false));
***REMOVED***
***REMOVED***
