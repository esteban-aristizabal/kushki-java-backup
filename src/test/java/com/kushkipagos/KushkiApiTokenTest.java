package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Before;
***REMOVED***
import org.mockito.ArgumentCaptor;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
***REMOVED***
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lmunda on 2/16/16 12:11.
 */
public class KushkiApiTokenTest {
    private Kushki kushki;

    @Before
    public void setUp() throws Exception {
        String merchantId = randomAlphabetic(10);
        String language = randomAlphabetic(2);
        String currency = randomAlphabetic(10);
        kushki = new Kushki(merchantId, language, currency);
***REMOVED***

***REMOVED***
    public void shouldRequestToken() throws IllegalBlockSizeException, IllegalAccessException, BadPaddingException, NoSuchFieldException, JsonProcessingException {
        WebResource.Builder builder = TestsHelpers.mockWebBuilder(kushki, Kushki.TOKENS_URL);
        Map<String, String> cardParams = TestsHelpers.getValidCardData();
        kushki.requestToken(cardParams);
        verify(builder).post(eq(ClientResponse.class), any(Map.class));
***REMOVED***

***REMOVED***
    public void shouldSendRightParametersToRequestToken() throws IllegalBlockSizeException, IllegalAccessException, BadPaddingException, NoSuchFieldException, IOException {
        Map<String, String> cardParams = TestsHelpers.getValidCardData();
        ObjectMapper mapper = new ObjectMapper();
        String params = mapper.writeValueAsString(cardParams);

        AurusEncryption encryption = mock(AurusEncryption.class);
        String encrypted = randomAlphabetic(10);
        TestsHelpers.mockEncryption(kushki, encryption, encrypted);
        WebResource.Builder builder = TestsHelpers.mockWebBuilder(kushki, Kushki.TOKENS_URL);
        kushki.requestToken(cardParams);

        ArgumentCaptor<Map> encryptedParams = ArgumentCaptor.forClass(Map.class);
        ArgumentCaptor<String> unencryptedParams = ArgumentCaptor.forClass(String.class);

        verify(builder).post(eq(ClientResponse.class), encryptedParams.capture());
        Map<String, String> parameters = encryptedParams.getValue();
        assertThat(parameters.get("request"), is(encrypted));

        verify(encryption).encryptMessageChunk(unencryptedParams.capture());
        parameters = new ObjectMapper().readValue(unencryptedParams.getValue(), Map.class);
        assertThat(parameters.get("card"), is(params));
***REMOVED***

***REMOVED***
    public void shouldReturnTransactionObjectAfterGettingToken() throws NoSuchFieldException, IllegalAccessException, IllegalBlockSizeException, KushkiException, BadPaddingException, JsonProcessingException {
        WebResource.Builder builder = TestsHelpers.mockClient(kushki, Kushki.TOKENS_URL);
        ClientResponse response = mock(ClientResponse.class);
        when(builder.post(eq(ClientResponse.class), any())).thenReturn(response);
        Map<String, String> cardParams = TestsHelpers.getValidCardData();
        Transaction transaction = kushki.requestToken(cardParams);
        assertThat(transaction.getResponse(), is(response));
***REMOVED***


***REMOVED***
