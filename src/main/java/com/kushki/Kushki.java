package com.kushki;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushki.enums.KushkiAdjustSubscription;
***REMOVED***
import com.kushki.enums.KushkiTransaccionType;
***REMOVED***
import com.kushki.to.SuscriptionInfo;
import com.kushki.to.Transaction;
***REMOVED***

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

public class Kushki {
    public static ***REMOVED***nal String TOKENS_URL = "tokens";
    public static ***REMOVED***nal String CHARGE_URL = "charge";
    public static ***REMOVED***nal String DEFERRED_CHARGE_URL = "deferred";
    public static ***REMOVED***nal String VOID_URL = "void";
    public static ***REMOVED***nal String REFUND_URL = "refund";

    private ***REMOVED***nal Client client;
    private ***REMOVED***nal KushkiEnvironment environment;
    private static ***REMOVED***nal String defaultLanguage = "es";
    private static ***REMOVED***nal String defaultCurrency = "USD";
    private ***REMOVED***nal KushkiEnvironment defaultEnvironment = KushkiEnvironment.PRODUCTION;
    private ***REMOVED***nal String merchantId;
    private ***REMOVED***nal String language;
    private ***REMOVED***nal String currency;
    private Gateway gateway;

    public Kushki(String merchantId) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        this.merchantId = merchantId;
        this.language = defaultLanguage;
        this.currency = defaultCurrency;
        this.client = ClientBuilder.newClient();
        this.environment = defaultEnvironment;
        this.gateway = new Gateway(this.environment);
***REMOVED***

    public Kushki(String merchantId, KushkiEnvironment environment) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        this.merchantId = merchantId;
        this.language = defaultLanguage;
        this.currency = defaultCurrency;
        this.client = ClientBuilder.newClient();
        this.environment = environment;
        this.gateway = new Gateway(this.environment);
***REMOVED***

    public Kushki(String merchantId, KushkiEnvironment environment, String currency) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        this.merchantId = merchantId;
        this.language = defaultLanguage;
        this.currency = currency;
        this.client = ClientBuilder.newClient();
        this.environment = environment;
        this.gateway = new Gateway(this.environment);
***REMOVED***

    public Kushki(String merchantId, String language, String currency) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidKeySpecException {
        this.merchantId = merchantId;
        this.language = language;
        this.currency = currency;
        this.client = ClientBuilder.newClient();
        this.environment = defaultEnvironment;
        this.gateway = new Gateway(this.environment);
***REMOVED***

    public Kushki(String merchantId, String language, String currency, KushkiEnvironment environment) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidKeySpecException {
        this.merchantId = merchantId;
        this.language = language;
        this.currency = currency;
        this.client = ClientBuilder.newClient();
        this.environment = environment;
        this.gateway = new Gateway(this.environment);
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

    /**
     * Perform a  charge in com.kushki.Kushki using a valid token for the given amount.
     * @deprecated this method  was replace by charge(String token, Amount amount, Integer months, JSONObject metadata)
     * @param token  A token obtained from the frontend or using the method.
     * @param amount The detailed {@link Amount***REMOVED*** to be charged.
     * @return A {@link Transaction***REMOVED*** which contains the result of the operation.
     * @throws KushkiException when the imput fail
     * @since 1.0.0
     */
    @Deprecated
    public Transaction charge(String token, Amount amount) throws KushkiException {
        return this.gateway.post(KushkiTransaccionType.CHARGE.toString()
                , ParametersBuilder.getChargeParameters(this, token, amount, null, null), this);
***REMOVED***

    /**
     * Perform a deferred charge in com.kushki.Kushki using a valid token for the given amount.
     *
     * @deprecated this method  was replace by charge(String token, Amount amount, Integer months, JSONObject metadata)
     * @param token  A token obtained from the frontend or using the method.
     * @param amount The detailed {@link Amount***REMOVED*** to be charged.
     * @param metadata The JSONObject with transaction's metadata
     * @return A {@link Transaction***REMOVED*** which contains the result of the operation.
     * @throws JsonProcessingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws KushkiException
     * @since 1.0.0
     */
    @Deprecated
    public Transaction charge(String token, Amount amount, JSONObject metadata) throws KushkiException {
        return this.gateway.post(KushkiTransaccionType.CHARGE.toString()
                , ParametersBuilder.getChargeParameters(this, token, amount, null, metadata), this);
***REMOVED***

    /**
     * Perform a deferred charge in com.kushki.Kushki using a valid token for the given amount.
     *
     * @deprecated this method  was replace by charge(String token, Amount amount, Integer months, JSONObject metadata)
     * @param token  A token obtained from the frontend or using the method.
     * @param amount The detailed {@link Amount***REMOVED*** to be charged.
     * @param months The number of months to defer the payment.
     * @return A {@link Transaction***REMOVED*** which contains the result of the operation.
     * @throws JsonProcessingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws KushkiException
     * @since 1.0.0
     */

    @Deprecated
    public Transaction charge(String token, Amount amount, Integer months) throws  KushkiException {
        return this.gateway.post(KushkiTransaccionType.CHARGE.toString()
                , ParametersBuilder.getChargeParameters(this, token, amount, months, null), this);
***REMOVED***

    /**
     * Perform a deferred o normal charge in com.kushki.Kushki using a valid token for the given amount.
     *
     * @param token    A token obtained from the frontend or using the  method.
     * @param amount   The detailed {@link Amount***REMOVED*** to be charged.
     * @param months   The number of months to defer the payment (could by null).
     * @param metadata JSONObject with Metadata (could by null).
     * @return A {@link Transaction***REMOVED*** which contains the result of the operation.
     * @throws JsonProcessingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws KushkiException
     * @since 1.0.0
     */
    public Transaction charge(String token, Amount amount, Integer months, JSONObject metadata) throws KushkiException {
        return this.gateway.post(KushkiTransaccionType.CHARGE.toString()
                , ParametersBuilder.getChargeParameters(this, token, amount, months, metadata), this);
***REMOVED***

    /**
     * Void a transaction previously performed in com.kushki.Kushki.
     *
     * @param ticket The ticket number of the transaction to be voided.
     * @param amount The detailed {@link Amount***REMOVED*** to be voided.
     * @return A {@link Transaction***REMOVED*** which contains the result of the operation.
     * @throws JsonProcessingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws KushkiException
     * @since 1.0.0
     */
    public Transaction voidCharge(String ticket) throws KushkiException {
        return this.gateway.delete(KushkiTransaccionType.VOID.toString(), ticket, this);
***REMOVED***

    public Transaction refundCharge(String ticket) throws  KushkiException {
        return this.gateway.delete(KushkiTransaccionType.REFUND.toString(), ticket, this);
***REMOVED***

    public Transaction subscription(String token, Amount amount, JSONObject metadata, SuscriptionInfo suscriptionInfo) throws KushkiException {
        return this.gateway.post(KushkiTransaccionType.SUSCRIPTION.toString()
                , ParametersBuilder.getSubscriptionParams(this, token, amount, metadata, suscriptionInfo), this);
***REMOVED***

    public Transaction updateSubscription(Amount amount, JSONObject metadata, SuscriptionInfo suscriptionInfo, String subscriptionId) throws KushkiException {
        return this.gateway.patch(KushkiTransaccionType.SUSCRIPTION.toString() + "/" + subscriptionId
                , ParametersBuilder.getUpdateSubscriptionParams(this, amount, metadata, suscriptionInfo), this);
***REMOVED***

    public Transaction updateSubscriptionCard(String newToken, String subscriptionId) throws KushkiException {
        return this.gateway.put(KushkiTransaccionType.SUSCRIPTION.toString() + "/" + subscriptionId + KushkiTransaccionType.SUSCRIPTION_CARD
                , ParametersBuilder.getUpdateCardParams(newToken), this);
***REMOVED***

    public Transaction adjustSubscription(String subscriptionId, Date date, int periods, Amount amount, KushkiAdjustSubscription adjustPeriod) throws KushkiException {
        return this.gateway.put(KushkiTransaccionType.SUSCRIPTION + "/" + subscriptionId + KushkiTransaccionType.SUSCRIPTION_ADJUSTMENT,
                ParametersBuilder.getSubscriptionAdjustmentParams(this, date, periods, adjustPeriod, amount), this);

***REMOVED***

    public Transaction subscriptionCharge(String cvv, Amount amount, JSONObject metadata, String subscriptionId) throws KushkiException {
        return this.gateway.post(KushkiTransaccionType.SUSCRIPTION.toString() + "/" + subscriptionId + KushkiTransaccionType.CHARGE
                , ParametersBuilder.getSubscriptionChargeParams(cvv, amount, metadata, this), this);
***REMOVED***

    public Transaction deleteSubscription(String subscriptionId) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        return this.gateway.delete(KushkiTransaccionType.SUSCRIPTION.toString(), subscriptionId, this);
***REMOVED***

***REMOVED***
