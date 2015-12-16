package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
***REMOVED***
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class Kushki {
    public static ***REMOVED***nal String URL = "https://ping.auruspay.com/kushki/api/v1/charge";
    private ***REMOVED***nal Client client;
    private String merchantId;
    private String language;
    private String currency;
    private AurusEncryption encryption;

    public Kushki(String merchantId, String language, String currency) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidKeySpecException {
        this.merchantId = merchantId;
        this.language = language;
        this.currency = currency;
        this.client = Client.create();
        this.encryption = new AurusEncryption();
***REMOVED***

    public String getMerchantId() {
        return merchantId;
***REMOVED***

    public Transaction charge(String token, Double amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String validAmount = validateAmount(amount);
        Map<String, String> parameters = buildParameters(token, validAmount);
        return post(parameters);
***REMOVED***

    private Map<String, String> buildParameters(String token, String amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException {
        String params = buildAndStringifyParameters(token, amount);
        String encString = encryption.encryptMessageChunk(params);
        Map<String, String> parameters = new HashMap<>(1);
        parameters.put("request", encString);
        return parameters;
***REMOVED***

    private String buildAndStringifyParameters(String token, String amount) throws JsonProcessingException {
        Map<String, String> parameters = new HashMap<>(5);
        parameters.put("transaction_token", token);
        parameters.put("transaction_amount", amount);
        parameters.put("currency_code", currency);
        parameters.put("merchant_identi***REMOVED***er", merchantId);
        parameters.put("language_indicator", language);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(parameters);
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

    private String validateAmount(Double amount) throws KushkiException {
        if (amount == null) {
            throw new KushkiException("El monto no puede ser nulo");
***REMOVED***
        if (amount <= 0) {
            throw new KushkiException("El monto debe ser superior a 0");
***REMOVED***
        String validAmount = String.format("%.2f", amount);
        if (validAmount.length() > 12) {
            throw new KushkiException("El monto debe tener menos de 12 dígitos");
***REMOVED***
        return validAmount;
***REMOVED***
***REMOVED***
