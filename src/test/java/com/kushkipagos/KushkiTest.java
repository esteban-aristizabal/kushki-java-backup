package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Before;
***REMOVED***
import org.mockito.ArgumentCaptor;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
***REMOVED***
import java.io.IOException;
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
        assertThat(Kushki.URL, is("https://ping.auruspay.com/kushki/api/v1/charge"));
***REMOVED***

***REMOVED***
    public void shouldCreateInstanceWithLanguage() {
        assertThat(kushki.getLanguage(), is(language));
***REMOVED***

***REMOVED***
    public void shouldChargeACardWithToken() throws NoSuchFieldException, IllegalAccessException, JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String token = randomAlphabetic(10);
        String amount = String.valueOf(nextDouble(1, 99));
        WebResource.Builder builder = mockClient();
        kushki.charge(token, amount);
        verify(builder).post(eq(ClientResponse.class), any(Map.class));
***REMOVED***

***REMOVED***
    public void shouldSendRightParametersToChargeCard() throws NoSuchFieldException, IllegalAccessException, IOException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String token = randomAlphabetic(10);
        String amount = String.valueOf(nextDouble(1, 99));
        Encryption encryption = mock(Encryption.class);
        String encrypted = randomAlphabetic(10);
        mockEncryption(encryption, encrypted);
        WebResource.Builder builder = mockClient();
        kushki.charge(token, amount);

        ArgumentCaptor<Map> encryptedParams = ArgumentCaptor.forClass(Map.class);
        ArgumentCaptor<String> unencryptedParams = ArgumentCaptor.forClass(String.class);

        verify(builder).post(eq(ClientResponse.class), encryptedParams.capture());
        Map<String, String> parameters = encryptedParams.getValue();
        assertThat(parameters.get("request"), is(encrypted));

        verify(encryption).encryptMessageChunk(unencryptedParams.capture());
        parameters = new ObjectMapper().readValue(unencryptedParams.getValue(), Map.class);
        assertThat(parameters.get("transaction_token"), is(token));
        assertThat(parameters.get("transaction_amount"), is(amount));
***REMOVED***

***REMOVED***
    public void shouldReturnTransactionObjectAfterChargingCard() throws NoSuchFieldException, IllegalAccessException, JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String token = randomAlphabetic(10);
        String amount = String.valueOf(nextDouble(1, 99));
        WebResource.Builder builder = mockClient();
        ClientResponse response = mock(ClientResponse.class);
        when(builder.post(eq(ClientResponse.class), any())).thenReturn(response);
        Transaction transaction = kushki.charge(token, amount);
        assertThat(transaction.getResponse(), is(response));
***REMOVED***

    private void mockEncryption(Encryption encryption, String encrypted) throws NoSuchFieldException, IllegalAccessException, BadPaddingException, IllegalBlockSizeException {
        injectMockEncryption(encryption);
        when(encryption.encryptMessageChunk(any(String.class))).thenReturn(encrypted);
***REMOVED***

    private void injectMockEncryption(Encryption encryption) throws NoSuchFieldException, IllegalAccessException {
        Class<?> klass = kushki.getClass();
        Field ***REMOVED***eld = klass.getDeclaredField("encryption");
        ***REMOVED***eld.setAccessible(true);
        ***REMOVED***eld.set(kushki, encryption);
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