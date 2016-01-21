package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.Map;

public class Kushki {
    public static ***REMOVED***nal String URL = "https://ping.auruspay.com/kushki/api/v1";

    public static ***REMOVED***nal String TOKENS_URL = URL + "/tokens";
    public static ***REMOVED***nal String CHARGE_URL = URL + "/charge";
    public static ***REMOVED***nal String DEFERRED_CHARGE_URL = URL + "/deferred";
    public static ***REMOVED***nal String VOID_URL = URL + "/void";
    public static ***REMOVED***nal String REFUND_URL = URL + "/refund";

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

    public String getLanguage() {
        return language;
***REMOVED***

    public String getCurrency() {
        return currency;
***REMOVED***

    public AurusEncryption getEncryption() {
        return encryption;
***REMOVED***

    public Transaction requestToken(Map<String, String> cardParams) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException {
        Map<String, String> parameters = ParametersBuilder.getTokenParameters(this, cardParams);
        return post(TOKENS_URL, parameters);
***REMOVED***

    public Transaction charge(String token, Double amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String validAmount = Validations.validateAmount(amount);
        Map<String, String> parameters = ParametersBuilder.getChargeParameters(this, token, validAmount);
        return post(CHARGE_URL, parameters);
***REMOVED***

    public Transaction deferredCharge(String token, Double amount, Integer months, Double interest) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String validAmount = Validations.validateAmount(amount);
        String validMonths = Validations.validateMonths(months);
        String validInterest = Validations.validateInterest(interest);
        Map<String, String> parameters = ParametersBuilder.getDeferredChargeParameters(this, token, validAmount, validMonths, validInterest);
        return post(DEFERRED_CHARGE_URL, parameters);
***REMOVED***

    public Transaction voidCharge(String ticket, Double amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String validAmount = Validations.validateAmount(amount);
        Map<String, String> parameters = ParametersBuilder.getVoidRefundParameters(this, ticket, validAmount);
        return post(VOID_URL, parameters);
***REMOVED***

    public Transaction refundCharge(String ticket, Double amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String validAmount = Validations.validateAmount(amount);
        Map<String, String> parameters = ParametersBuilder.getVoidRefundParameters(this, ticket, validAmount);
        return post(REFUND_URL, parameters);
***REMOVED***

    private Transaction post(String url, Map<String, String> parameters) {
        WebResource resource = client.resource(url);

        WebResource.Builder builder = resource.type(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE);
        ClientResponse response = builder.post(ClientResponse.class, parameters);
        return new Transaction(response);
***REMOVED***
***REMOVED***
