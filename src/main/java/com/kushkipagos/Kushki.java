package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

***REMOVED***
***REMOVED***
***REMOVED***

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public class Kushki {
    public static ***REMOVED***nal String BASE_URL = "https://ping.aurusinc.com/kushki/api/v1";

    public static ***REMOVED***nal String TOKENS_URL = "tokens";
    public static ***REMOVED***nal String CHARGE_URL = "charge";
    public static ***REMOVED***nal String DEFERRED_CHARGE_URL = "deferred";
    public static ***REMOVED***nal String VOID_URL = "void";
    public static ***REMOVED***nal String REFUND_URL = "refund";

    private ***REMOVED***nal Client client;
    private String merchantId;
    private String language;
    private String currency;
    private AurusEncryption encryption;

    public Kushki(String merchantId, String language, String currency) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidKeySpecException {
        this.merchantId = merchantId;
        this.language = language;
        this.currency = currency;
        this.encryption = new AurusEncryption();
        this.client = ClientBuilder.newClient();
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

    public Transaction charge(String token, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Map<String, String> parameters = ParametersBuilder.getChargeParameters(this, token, amount);
        return post(CHARGE_URL, parameters);
***REMOVED***

    public Transaction deferredCharge(String token, Amount amount, Integer months) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String validMonths = Validations.validateMonths(months);
        Map<String, String> parameters = ParametersBuilder.getDeferredChargeParameters(this, token, amount, validMonths);
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
        WebTarget target = client.target(BASE_URL).path(url);

***REMOVED***
        Response response = invocationBuilder.post(Entity.entity(parameters, MediaType.APPLICATION_JSON_TYPE));

        return new Transaction(response);
***REMOVED***
***REMOVED***
