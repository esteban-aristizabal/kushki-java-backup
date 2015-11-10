package org.kushki;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

***REMOVED***
import java.util.HashMap;
import java.util.Map;

public class Kushki {
    public static ***REMOVED***nal String URL = "https://kushki-api.herokuapp.com/v1/charge";
    private ***REMOVED***nal Client client;
    private String merchantId;
    private String language;
    private String currency;

    public Kushki(String merchantId, String language, String currency) {
        this.merchantId = merchantId;
        this.language = language;
        this.currency = currency;
        this.client = Client.create();
***REMOVED***

    public String getMerchantId() {
        return merchantId;
***REMOVED***

    public Transaction charge(String token, String amount) {
        Map<String, String> parameters = buildParameters(token, amount);
        return post(parameters);
***REMOVED***

    private Map<String, String> buildParameters(String token, String amount) {
        Map<String, String> parameters = new HashMap<String, String>(5);
        parameters.put("merchant_identi***REMOVED***er", merchantId);
        parameters.put("language_indicator", language);
        parameters.put("transaction_token", token);
        parameters.put("currency_code", currency);
        parameters.put("transaction_amount", amount);
        return parameters;
***REMOVED***

    private Transaction post(Map<String, String> parameters) {
        WebResource resource = client.resource(URL);
        WebResource.Builder builder = resource.type(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE);
        ClientResponse response = builder.post(ClientResponse.class, parameters);
        return new Transaction(response);
***REMOVED***

    public String getLanguage() {
        return language;
***REMOVED***
***REMOVED***
