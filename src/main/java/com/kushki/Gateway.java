package com.kushki;

import com.kushki.Enum.KushkiEnvironment;
import com.kushki.TO.Transaction;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
***REMOVED***


***REMOVED***


public class Gateway {

    private KushkiEnvironment enviroment;
    private ***REMOVED***nal Client client;

    public Gateway(KushkiEnvironment enviroment) {
        this.enviroment = enviroment;
        this.client = ClientBuilder.newClient();
***REMOVED***

    public Transaction post(String url, JSONObject data, Kushki kushki) {
***REMOVED***
            com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = Unirest.post(this.enviroment.getUrl() + url)
                    .header("Private-Merchant-Id", kushki.getMerchantId())
                    .body(data.toString())
                    .asJson();
            return new Transaction(jsonResponse);
***REMOVED*** catch (UnirestException e) {
***REMOVED***
            return new Transaction(null);
***REMOVED***
***REMOVED***

    public Transaction patch(String url, JSONObject data, Kushki kushki) {
***REMOVED***
            com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = Unirest.patch(this.enviroment.getUrl() + url)
                    .header("Private-Merchant-Id", kushki.getMerchantId())
                    .body(data.toString())
                    .asJson();
            return new Transaction(jsonResponse.getStatus(), jsonResponse.getBody());
***REMOVED*** catch (UnirestException e) {
***REMOVED***
            return new Transaction(null);
***REMOVED***
***REMOVED***

    public Transaction put(String url, JSONObject data, Kushki kushki) {
***REMOVED***
            com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = Unirest.put(this.enviroment.getUrl() + url)
                    .header("Private-Merchant-Id", kushki.getMerchantId())
                    .body(data.toString())
                    .asJson();
            return new Transaction(jsonResponse.getStatus(), jsonResponse.getBody());
***REMOVED*** catch (UnirestException e) {
***REMOVED***
            return new Transaction(null);
***REMOVED***
***REMOVED***

    public Transaction delete(String url, String id, Kushki kushki) {
***REMOVED***
            com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = Unirest.delete(this.enviroment.getUrl() + url + id)
                    .header("Private-Merchant-Id", kushki.getMerchantId())
                    .asJson();
            return new Transaction(jsonResponse);
***REMOVED*** catch (UnirestException e) {
***REMOVED***
            return new Transaction(null);
***REMOVED***
***REMOVED***

***REMOVED***
