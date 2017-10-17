package com.kushki;

import com.kushki.enums.KushkiAdjustSubscription;
***REMOVED***
import com.kushki.to.ContactDetail;
import com.kushki.to.SuscriptionInfo;
import org.json.JSONException;
***REMOVED***

import java.text.SimpleDateFormat;
import java.util.Date;

public ***REMOVED***nal class ParametersBuilder {


    public static ***REMOVED***nal String TOKEN = "token";
    public static ***REMOVED***nal String MONTHS = "months";
    public static ***REMOVED***nal String METADATA = "metadata";
    public static ***REMOVED***nal String AMOUNT = "amount";
    public static ***REMOVED***nal String REQUIRED_FIELD_IS_NULL = "A required ***REMOVED***eld is null";
    public static ***REMOVED***nal String LANGUAGE = "language";
    public static ***REMOVED***nal String START_DATE = "startDate";
    public static ***REMOVED***nal String PERIODICITY = "periodicity";
    public static ***REMOVED***nal String PLAN_NAME = "planName";
    public static ***REMOVED***nal String CONTACT_DETAILS = "contactDetails";
    public static ***REMOVED***nal String YYYY_MM_DD = "yyyy-MM-dd";

    public static JSONObject getChargeParameters(Kushki kushki, String token, Amount amount, Integer month, JSONObject metadata) throws KushkiException {
        JSONObject responseObject = new JSONObject();
***REMOVED***
            responseObject.put(TOKEN, token);
            JSONObject amountObject = getAmountJson(kushki, amount);
            if (month != null)
                responseObject.put(MONTHS, (int) month);
            if (metadata != null) {
                responseObject.put(METADATA, metadata);
    ***REMOVED***
            responseObject.put(AMOUNT, amountObject);
***REMOVED***
            throw new KushkiException(REQUIRED_FIELD_IS_NULL);
***REMOVED***
        return responseObject;
***REMOVED***

    private static JSONObject getAmountJson(Kushki kushki, Amount amount) {
        JSONObject amountObject = new JSONObject();
        amountObject.put("subtotalIva", amount.getSubtotalIVA());
        amountObject.put("subtotalIva0", amount.getSubtotalIVA0());
        amountObject.put("ice", amount.getIce());
        amountObject.put("iva", amount.getIva());
        if (kushki.getCurrency() != null && kushki.getCurrency().length() > 0)
            amountObject.put("currency", kushki.getCurrency());
        if (amount.getExtraTaxes() != null && getJSONExtraTax(amount).length() > 0)
            amountObject.put("extraTaxes", getJSONExtraTax(amount));
        return amountObject;
***REMOVED***


    private static JSONObject getContactDetailJson(ContactDetail contactInfo) throws JSONException {
        JSONObject contactObject = new JSONObject();
        contactObject.put("***REMOVED***rstName", contactInfo.getFirstName());
        contactObject.put("lastName", contactInfo.getLastName());
        contactObject.put("email", contactInfo.getEmail());
        return contactObject;
***REMOVED***


    private static JSONObject getJSONExtraTax(Amount amount) throws JSONException {
        JSONObject extraTax = new JSONObject();
        if (amount.getExtraTaxes().getPropina().getAmount() != 0)
            extraTax.put("propina", amount.getExtraTaxes().getPropina().getAmount());
        if (amount.getExtraTaxes().getIac().getAmount() != 0)
            extraTax.put("iac", amount.getExtraTaxes().getIac().getAmount());
        if (amount.getExtraTaxes().getTasaAeroportuaria().getAmount() != 0)
            extraTax.put("tasaAeroportuaria", amount.getExtraTaxes().getTasaAeroportuaria().getAmount());
        if (amount.getExtraTaxes().getAgenciaDeViaje().getAmount() != 0)
            extraTax.put("agenciaDeViaje", amount.getExtraTaxes().getAgenciaDeViaje().getAmount());
        return extraTax;
***REMOVED***

    public static JSONObject getSubscriptionChargeParams(String cvv, Amount amount, JSONObject metadata, Kushki kushki) throws KushkiException {
        JSONObject responseObject = new JSONObject();
***REMOVED***
            if (cvv != null && cvv.length() > 0)
                responseObject.put("cvv", cvv);
            if (kushki.getLanguage() != null)
                responseObject.put(LANGUAGE, kushki.getLanguage());
            if (metadata != null) {
                responseObject.put(METADATA, metadata);
    ***REMOVED***
            if (amount != null) {
                JSONObject amountObject = getAmountJson(kushki, amount);
                responseObject.put(AMOUNT, amountObject);
    ***REMOVED***
***REMOVED***
            throw new KushkiException(REQUIRED_FIELD_IS_NULL);
***REMOVED***
        return responseObject;
***REMOVED***

    public static JSONObject getSubscriptionParams(Kushki kushki, String token, Amount amount, JSONObject metadata, SuscriptionInfo suscriptionInfo) throws KushkiException {
        JSONObject responseObject = new JSONObject();
***REMOVED***
            responseObject.put(TOKEN, token);
            responseObject.put(PLAN_NAME, suscriptionInfo.getPlanName());
            responseObject.put(PERIODICITY, suscriptionInfo.getPeriodicity().getName());
            SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
            responseObject.put(START_DATE, dateFormat.format(suscriptionInfo.getStartDate()));
            if (kushki.getLanguage() != null)
                responseObject.put(LANGUAGE, kushki.getLanguage());
            JSONObject contactObject = getContactDetailJson( suscriptionInfo.getContactDetail());
            JSONObject amountObject = getAmountJson(kushki, amount);
            if (metadata != null) {
                responseObject.put(METADATA, metadata);
    ***REMOVED***
            responseObject.put(AMOUNT, amountObject);
            responseObject.put(CONTACT_DETAILS, contactObject);
***REMOVED***
            throw new KushkiException(REQUIRED_FIELD_IS_NULL);
***REMOVED***
        return responseObject;
***REMOVED***

    public static JSONObject getSubscriptionAdjustmentParams(Kushki kushki, Date date, int periods, KushkiAdjustSubscription type, Amount amount) throws KushkiException {
        JSONObject responseObject = new JSONObject();
***REMOVED***
            responseObject.put("type", type.getName());
            SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
            responseObject.put("date", dateFormat.format(date));
            responseObject.put("periods", periods);
            JSONObject amountObject = getAmountJson(kushki, amount);
            responseObject.put(AMOUNT, amountObject);
***REMOVED***
            throw new KushkiException(REQUIRED_FIELD_IS_NULL);
***REMOVED***
        return responseObject;
***REMOVED***

    public static JSONObject getUpdateSubscriptionParams(Kushki kushki, Amount amount, JSONObject metadata, SuscriptionInfo suscriptionInfo) throws KushkiException {
        JSONObject responseObject = new JSONObject();
***REMOVED***
            if (suscriptionInfo != null) {
                JSONObject contactObject = getContactDetailJson( suscriptionInfo.getContactDetail());
                if (contactObject != null) {
                    responseObject.put(CONTACT_DETAILS, contactObject);
        ***REMOVED***
                if (suscriptionInfo.getPlanName() != null && suscriptionInfo.getPlanName().length() > 0)
                    responseObject.put(PLAN_NAME, suscriptionInfo.getPlanName());
                if (suscriptionInfo.getPeriodicity() != null)
                    responseObject.put(PERIODICITY, suscriptionInfo.getPeriodicity().getName());
                SimpleDateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
                if (suscriptionInfo.getStartDate() != null)
                    responseObject.put(START_DATE, dateFormat.format(suscriptionInfo.getStartDate()));
    ***REMOVED***
            if (kushki.getLanguage() != null)
                responseObject.put(LANGUAGE, kushki.getLanguage());

            if (metadata != null) {
                responseObject.put(METADATA, metadata);
    ***REMOVED***
            if (amount != null) {
                JSONObject amountObject = getAmountJson(kushki, amount);
                responseObject.put(AMOUNT, amountObject);
    ***REMOVED***

***REMOVED***
            throw new KushkiException(REQUIRED_FIELD_IS_NULL);
***REMOVED***
        return responseObject;
***REMOVED***

    public static JSONObject getUpdateCardParams(String subscriptionId) throws KushkiException {
        JSONObject responseObject = new JSONObject();
***REMOVED***
            responseObject.put(TOKEN, subscriptionId);
***REMOVED***
            throw new KushkiException(REQUIRED_FIELD_IS_NULL);
***REMOVED***
        return responseObject;
***REMOVED***
***REMOVED***
