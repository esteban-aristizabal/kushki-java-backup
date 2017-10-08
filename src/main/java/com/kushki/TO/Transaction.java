package com.kushki.TO;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Transaction {
    private JsonNode body;
    private int status;


    public Transaction(HttpResponse<JsonNode> response) {
        this.status = response.getStatus();
        body = response.getBody();
***REMOVED***

    public Transaction(int statusCode, JsonNode body) {
        this.status = statusCode;
        this.body = body;
***REMOVED***


    public boolean isSuccessful() {
        return status == 200 || status == 201 || status == 204;
***REMOVED***

    public JsonNode getResponseBody() {
        return body;
***REMOVED***

    public String getTicketNumber() {
        return getResponseAttribute("ticketNumber");
***REMOVED***

    public String getSubscriptionId() {
        return getResponseAttribute("subscriptionId");
***REMOVED***

    public String getResponseText() {
        return getResponseAttribute("message");
***REMOVED***

    public String getToken() {
        return getResponseAttribute("transaction_token");
***REMOVED***

    public String getResponseCode() {
        return getResponseAttribute("code");
***REMOVED***

    private String getResponseAttribute(String attribute) {
***REMOVED***
            return body.getObject().getString(attribute);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***

    @Override
    public String toString() {
        return "isSuccessful: " + isSuccessful() +
                ", getTicketNumber: " + getTicketNumber() +
                ", getResponseText: " + getResponseText() +
                ", getToken: " + getToken() +
                ", getResponseCode: " + getResponseCode() +
                ", getSubscriptionId: " + getSubscriptionId()
                ;
***REMOVED***
***REMOVED***
