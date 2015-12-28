package com.kushkipagos;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import org.junit.Before;
***REMOVED***

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
***REMOVED***
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionTest {
    private ClientResponse response;
    private Transaction transaction;
    private static ***REMOVED***nal ObjectMapper OBJECT_MAPPER = new ObjectMapper();

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
        transaction = new Transaction(response);
        assertThat(transaction.getResponseBody(), is(json));
***REMOVED***

***REMOVED***
    public void shouldReturnTicketNumber() throws IOException {
        Map<String, String> jsonMap = new HashMap<>(1);
        String ticket_number = randomAlphabetic(10);
        jsonMap.put("ticket_number", ticket_number);
        JsonNode node = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(jsonMap), JsonNode.class);
        when(response.getEntity(JsonNode.class)).thenReturn(node);
        transaction = new Transaction(response);
        assertThat(transaction.getTicketNumber(), is(ticket_number));
***REMOVED***

***REMOVED***
    public void shouldReturnResponseText() throws IOException {
        Map<String, String> jsonMap = new HashMap<>(1);
        String response_text = randomAlphabetic(10);
        jsonMap.put("response_text", response_text);
        JsonNode node = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(jsonMap), JsonNode.class);
        when(response.getEntity(JsonNode.class)).thenReturn(node);
        transaction = new Transaction(response);
        assertThat(transaction.getResponseText(), is(response_text));
***REMOVED***

***REMOVED***
    public void shouldReturnToken() throws IOException {
        Map<String, String> jsonMap = new HashMap<>(1);
        String token = randomAlphabetic(10);
        jsonMap.put("transaction_token", token);
        JsonNode node = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(jsonMap), JsonNode.class);
        when(response.getEntity(JsonNode.class)).thenReturn(node);
        transaction = new Transaction(response);
        assertThat(transaction.getToken(), is(token));
***REMOVED***

***REMOVED***
    public void shouldApprovedAmount() throws IOException {
        Map<String, String> jsonMap = new HashMap<>(1);
        Double amount = TestsHelpers.getRandomAmount();
        jsonMap.put("approved_amount", String.valueOf(amount));
        JsonNode node = OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(jsonMap), JsonNode.class);
        when(response.getEntity(JsonNode.class)).thenReturn(node);
        transaction = new Transaction(response);
        assertThat(transaction.getApprovedAmount(), is(amount));
***REMOVED***
***REMOVED***