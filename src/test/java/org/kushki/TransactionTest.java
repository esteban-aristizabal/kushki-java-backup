package org.kushki;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.jersey.api.client.ClientResponse;
import org.junit.Before;
***REMOVED***

***REMOVED***
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionTest {
    private ClientResponse response;
    private Transaction transaction;

    @Before
    public void setUp() throws Exception {
        response = mock(ClientResponse.class);
        transaction = new Transaction(response);
***REMOVED***

***REMOVED***
    public void shouldHaveHttpResponse() {
        assertThat(transaction.getResponse(), is(response));
***REMOVED***

***REMOVED***
    public void shouldReturnTrueIfResponseCodeIs200() {
        when(response.getStatus()).thenReturn(200);
        assertThat(transaction.isSuccessful(), is(true));
***REMOVED***

***REMOVED***
    public void shouldReturnFalseIfResponseCodeIsNot200() {
        when(response.getStatus()).thenReturn(402);
        assertThat(transaction.isSuccessful(), is(false));
***REMOVED***

***REMOVED***
    public void shouldReturnResponseBodyAsJsonObject() {
        JsonNode json = mock(JsonNode.class);
        when(response.getEntity(JsonNode.class)).thenReturn(json);
        assertThat(transaction.getResponseBody(), is(json));
***REMOVED***
***REMOVED***