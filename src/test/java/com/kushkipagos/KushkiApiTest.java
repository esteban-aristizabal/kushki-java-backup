package com.kushkipagos;

import org.junit.Before;
***REMOVED***

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
***REMOVED***
import static org.hamcrest.core.Is.is;

/**
 * Created by lmunda on 2/16/16 12:09.
 */
public class KushkiApiTest {
    private String merchantId;
    private Kushki kushki;
    private String language;

    private static ***REMOVED***nal String URL = "https://ping.auruspay.com/kushki/api/v1";

    @Before
    public void setUp() throws Exception {
        merchantId = randomAlphabetic(10);
        language = randomAlphabetic(2);
        String currency = randomAlphabetic(10);
        kushki = new Kushki(merchantId, language, currency);
***REMOVED***


***REMOVED***
    public void shouldCreateInstanceWithMerchantId() {
        assertThat(kushki.getMerchantId(), is(merchantId));
***REMOVED***

***REMOVED***
    public void shouldHaveAPIURL() {
        assertThat(Kushki.URL, is(URL));
***REMOVED***

***REMOVED***
    public void shouldHaveTokensURL() {
        assertThat(Kushki.TOKENS_URL, is(URL + "/tokens"));
***REMOVED***

***REMOVED***
    public void shouldHaveChargeURL() {
        assertThat(Kushki.CHARGE_URL, is(URL + "/charge"));
***REMOVED***

***REMOVED***
    public void shouldHaveDeferredChargeURL() {
        assertThat(Kushki.DEFERRED_CHARGE_URL, is(URL + "/deferred"));
***REMOVED***

***REMOVED***
    public void shouldHaveVoidURL() {
        assertThat(Kushki.VOID_URL, is(URL + "/void"));
***REMOVED***

***REMOVED***
    public void shouldHaveRefundURL() {
        assertThat(Kushki.REFUND_URL, is(URL + "/refund"));
***REMOVED***

***REMOVED***
    public void shouldCreateInstanceWithLanguage() {
        assertThat(kushki.getLanguage(), is(language));
***REMOVED***

***REMOVED***
