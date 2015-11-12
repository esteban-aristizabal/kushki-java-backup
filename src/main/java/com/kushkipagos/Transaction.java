package com.kushkipagos;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.jersey.api.client.ClientResponse;

public class Transaction {
    private ClientResponse response;

    public Transaction(ClientResponse response) {
        this.response = response;
***REMOVED***

    public ClientResponse getResponse() {
        return response;
***REMOVED***

    public boolean isSuccessful() {
        return response.getStatus() == 200;
***REMOVED***

    public JsonNode getResponseBody() {
        return response.getEntity(JsonNode.class);
***REMOVED***
***REMOVED***
