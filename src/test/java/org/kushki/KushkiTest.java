package org.kushki;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Before;
***REMOVED***
import org.mockito.ArgumentCaptor;

***REMOVED***
import java.lang.reflect.Field;
import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextDouble;
***REMOVED***
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class KushkiTest {
    private String merchantId;
    private Kushki kushki;
    private String language;
    private String currency;

    @Before
    public void setUp() throws Exception {
        merchantId = randomAlphabetic(10);
        language = randomAlphabetic(2);
        currency = randomAlphabetic(10);
        kushki = new Kushki(merchantId, language, currency);
***REMOVED***

***REMOVED***
    public void shouldCreateInstanceWithMerchantId() {
        assertThat(kushki.getMerchantId(), is(merchantId));
***REMOVED***

***REMOVED***
    public void shouldHaveAPIURL() {
        assertThat(Kushki.URL, is("https://kushki-api.herokuapp.com/v1/charge"));
***REMOVED***

***REMOVED***
    public void shouldCreateInstanceWithLanguage() {
        assertThat(kushki.getLanguage(), is(language));
***REMOVED***

***REMOVED***
    public void shouldChargeACardWithToken() throws NoSuchFieldException, IllegalAccessException {
        String token = randomAlphabetic(10);
        String amount = String.valueOf(nextDouble(1, 99));
        WebResource.Builder builder = mockClient();
        kushki.charge(token, amount);
        verify(builder).post(eq(ClientResponse.class), any(Map.class));
***REMOVED***

***REMOVED***
    public void shouldSendRightParametersToChargeCard() throws NoSuchFieldException, IllegalAccessException {
        String token = randomAlphabetic(10);
        String amount = String.valueOf(nextDouble(1, 99));
        WebResource.Builder builder = mockClient();
        kushki.charge(token, amount);

        ArgumentCaptor<Map> captor = ArgumentCaptor.forClass(Map.class);

        verify(builder).post(eq(ClientResponse.class), captor.capture());
        Map<String, String> parameters = captor.getValue();

        assertThat(parameters.get("merchant_identi***REMOVED***er"), is(merchantId));
        assertThat(parameters.get("language_indicator"), is(language));
        assertThat(parameters.get("transaction_token"), is(token));
        assertThat(parameters.get("currency_code"), is(currency));
        assertThat(parameters.get("transaction_amount"), is(amount));
***REMOVED***

***REMOVED***
    public void shouldReturnTransactionObjectAfterChargingCard() throws NoSuchFieldException, IllegalAccessException {
        String token = randomAlphabetic(10);
        String amount = String.valueOf(nextDouble(1, 99));
        WebResource.Builder builder = mockClient();
        ClientResponse response = mock(ClientResponse.class);
        when(builder.post(eq(ClientResponse.class), any())).thenReturn(response);
        Transaction transaction = kushki.charge(token, amount);
        assertThat(transaction.getResponse(), is(response));
***REMOVED***

    private WebResource.Builder mockClient() throws NoSuchFieldException, IllegalAccessException {
        Client client = mock(Client.class);
        injectMockClient(client);
        WebResource webResource = mock(WebResource.class);
        WebResource.Builder requestWithType = mock(WebResource.Builder.class);
        WebResource.Builder requestWithAccept = mock(WebResource.Builder.class);
        when(client.resource(Kushki.URL)).thenReturn(webResource);
        when(webResource.type(MediaType.APPLICATION_JSON_TYPE)).thenReturn(requestWithType);
        when(requestWithType.accept(MediaType.APPLICATION_JSON_TYPE)).thenReturn(requestWithAccept);
        return requestWithAccept;
***REMOVED***

    private void injectMockClient(Client client) throws NoSuchFieldException, IllegalAccessException {
        Class<?> klass = kushki.getClass();
        Field ***REMOVED***eld = klass.getDeclaredField("client");
        ***REMOVED***eld.setAccessible(true);
        ***REMOVED***eld.set(kushki, client);
***REMOVED***
***REMOVED***