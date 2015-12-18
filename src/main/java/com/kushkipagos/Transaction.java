package com.kushkipagos;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.jersey.api.client.ClientResponse;

public class Transaction {
    private ClientResponse response;
    private JsonNode body;

    public Transaction(ClientResponse response) {
        this.response = response;
        body = response.getEntity(JsonNode.class);
***REMOVED***

    public ClientResponse getResponse() {
        return response;
***REMOVED***

    public boolean isSuccessful() {
        return response.getStatus() == 200;
***REMOVED***

    public JsonNode getResponseBody() {
        return body;
***REMOVED***

    public String getTicketNumber() {
        return getResponseAttribute("ticket_number");
***REMOVED***

    public String getResponseText() {
        return getResponseAttribute("response_text");
***REMOVED***

    private String getResponseAttribute(String attribute) {
        return body.get(attribute).asText();
***REMOVED***
***REMOVED***
