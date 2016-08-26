package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
***REMOVED***
***REMOVED***
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public class Kushki {
    public static ***REMOVED***nal String TOKENS_URL = "tokens";
    public static ***REMOVED***nal String CHARGE_URL = "charge";
    public static ***REMOVED***nal String DEFERRED_CHARGE_URL = "deferred";
    public static ***REMOVED***nal String VOID_URL = "void";
    public static ***REMOVED***nal String REFUND_URL = "refund";

    private ***REMOVED***nal Client client;
    private ***REMOVED***nal KushkiEnvironment environment;

    private ***REMOVED***nal String defaultLanguage = "es";
    private ***REMOVED***nal String defaultCurrency = "USD";
    private ***REMOVED***nal KushkiEnvironment defaultEnvironment = KushkiEnvironment.PRODUCTION;

    private ***REMOVED***nal String merchantId;
    private ***REMOVED***nal String language;
    private ***REMOVED***nal String currency;
    private ***REMOVED***nal AurusEncryption encryption;

    public Kushki(String merchantId, String language, String currency) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidKeySpecException {
        this.merchantId = merchantId;
        this.language = language;
        this.currency = currency;
        this.encryption = new AurusEncryption();
        this.client = ClientBuilder.newClient();
        this.environment = defaultEnvironment;
***REMOVED***

    public Kushki(String merchantId, String language, String currency, KushkiEnvironment environment) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidKeySpecException {
        this.merchantId = merchantId;
        this.language = language;
        this.currency = currency;
        this.encryption = new AurusEncryption();
        this.client = ClientBuilder.newClient();
        this.environment = environment;
***REMOVED***

    public Kushki(String merchantId) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        this.merchantId = merchantId;
        this.language = defaultLanguage;
        this.currency = defaultCurrency;
        this.encryption = new AurusEncryption();
        this.client = ClientBuilder.newClient();
        this.environment = defaultEnvironment;
***REMOVED***

    public Kushki(String merchantId, KushkiEnvironment environment) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        this.merchantId = merchantId;
        this.language = defaultLanguage;
        this.currency = defaultCurrency;
        this.encryption = new AurusEncryption();
        this.client = ClientBuilder.newClient();
        this.environment = environment;
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

    public KushkiEnvironment getEnvironment() {
        return environment;
***REMOVED***

    public AurusEncryption getEncryption() {
        return encryption;
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

    public Transaction voidCharge(String ticket, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Map<String, String> parameters = ParametersBuilder.getVoidRefundParameters(this, ticket, amount);
        return post(VOID_URL, parameters);
***REMOVED***

    public Transaction requestToken(Card card, Double totalAmount) throws IllegalBlockSizeException, KushkiException, BadPaddingException, JsonProcessingException {
        Map<String, String> parameters = ParametersBuilder.getTokenParameters(this, card, totalAmount);
        return post(TOKENS_URL, parameters);
***REMOVED***

    private Transaction post(String url, Map<String, String> parameters) {
        WebTarget target = client.target(environment.getUrl()).path(url);
***REMOVED***
        Response response = invocationBuilder.post(Entity.entity(parameters, MediaType.APPLICATION_JSON_TYPE));
        return new Transaction(response);
***REMOVED***
***REMOVED***
