package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.util.HashMap;
import java.util.Map;

public ***REMOVED***nal class ParametersBuilder {

    private ParametersBuilder() {
***REMOVED***

    static Map<String, String> getChargeParameters(Kushki kushki, String token, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyChargeParameters(kushki, token, amount);
        return encryptParams(kushki, params);
***REMOVED***

    static Map<String, String> getChargeParametersColombia(Kushki kushki, String token, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyChargeParametersColombia(kushki, token, amount);
        return encryptParams(kushki, params);
***REMOVED***

    static Map<String, String> getDeferredChargeParameters(Kushki kushki, String token, Amount amount, String months) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyDeferredChargeParameters(kushki, token, amount, months);
        return encryptParams(kushki, params);
***REMOVED***

    static Map<String, String> getDeferredChargeParametersColombia(Kushki kushki, String token, Amount amount, String months) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyDeferredChargeParametersColombia(kushki, token, amount, months);
        return encryptParams(kushki, params);
***REMOVED***

    static Map<String, String> getVoidRefundParameters(Kushki kushki, String ticket, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyVoidRefundParameters(kushki, ticket, amount);
        return encryptParams(kushki, params);
***REMOVED***

    static Map<String, String> getVoidRefundParametersColombia(Kushki kushki, String ticket, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyVoidRefundParametersColombia(kushki, ticket, amount);
        return encryptParams(kushki, params);
***REMOVED***

    static Map<String, String> getTokenParameters(Kushki kushki, Card card, Double totalAmount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyTokenParameters(kushki, card, totalAmount);
        return encryptParams(kushki, params);
***REMOVED***

    static Map<String, String> getTokenParametersColombia(Kushki kushki, Card card, Integer totalAmount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        String params = buildAndStringifyTokenParametersColombia(kushki, card, totalAmount);
        return encryptParams(kushki, params);
***REMOVED***

    private static Map<String, String> encryptParams(Kushki kushki, String params) throws BadPaddingException, IllegalBlockSizeException {
        String encString = kushki.getEncryption().encryptMessageChunk(params);
        Map<String, String> encryptedParameters = new HashMap<>(1);
        encryptedParameters.put("request", encString);
        return encryptedParameters;
***REMOVED***

    private static String buildAndStringifyChargeParameters(Kushki kushki, String token, Amount amount) throws JsonProcessingException, KushkiException {
        ObjectMapper mapperAmount = new ObjectMapper();
        String stringi***REMOVED***edAmount = mapperAmount.writeValueAsString(amount.toHash());
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("transaction_token", token);
        parameters.put("transaction_amount", stringi***REMOVED***edAmount);

        ObjectMapper mapperParameters = new ObjectMapper();
        return mapperParameters.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyChargeParametersColombia(Kushki kushki, String token, Amount amount) throws JsonProcessingException, KushkiException {
        ObjectMapper mapperAmount = new ObjectMapper();
        String stringi***REMOVED***edAmount = mapperAmount.writeValueAsString(amount.toHashColombia());
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("transaction_token", token);
        parameters.put("transaction_amount", stringi***REMOVED***edAmount);

        ObjectMapper mapperParameters = new ObjectMapper();
        return mapperParameters.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyDeferredChargeParameters(Kushki kushki, String token, Amount amount, String months) throws JsonProcessingException, KushkiException {
        ObjectMapper mapperAmount = new ObjectMapper();
        String stringi***REMOVED***edAmount = mapperAmount.writeValueAsString(amount.toHash());

        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("transaction_token", token);
        parameters.put("transaction_amount", stringi***REMOVED***edAmount);
        parameters.put("months", months);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyDeferredChargeParametersColombia(Kushki kushki, String token, Amount amount, String months) throws JsonProcessingException, KushkiException {
        ObjectMapper mapperAmount = new ObjectMapper();
        String stringi***REMOVED***edAmount = mapperAmount.writeValueAsString(amount.toHashColombia());

        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("transaction_token", token);
        parameters.put("transaction_amount", stringi***REMOVED***edAmount);
        parameters.put("months", months);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyVoidRefundParameters(Kushki kushki, String ticket, Amount amount) throws JsonProcessingException, KushkiException {
        ObjectMapper mapperAmount = new ObjectMapper();
        String stringi***REMOVED***edAmount = mapperAmount.writeValueAsString(amount.toHash());

        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("ticket_number", ticket);
        parameters.put("transaction_amount", stringi***REMOVED***edAmount);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyVoidRefundParametersColombia(Kushki kushki, String ticket, Amount amount) throws JsonProcessingException, KushkiException {
        ObjectMapper mapperAmount = new ObjectMapper();
        String stringi***REMOVED***edAmount = mapperAmount.writeValueAsString(amount.toHashColombia());

        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("ticket_number", ticket);
        parameters.put("transaction_amount", stringi***REMOVED***edAmount);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyTokenParameters(Kushki kushki, Card card, Double totalAmount) throws JsonProcessingException, KushkiException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("card", mapper.writeValueAsString(card));
        parameters.put("amount", Validations.validateNumber(totalAmount, 0, 12, "El total"));
        parameters.put("remember_me", "0");
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyTokenParametersColombia(Kushki kushki, Card card, Integer totalAmount) throws JsonProcessingException, KushkiException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("card", mapper.writeValueAsString(card));
        parameters.put("amount", Validations.validateNumber(totalAmount, 0, 12, "El total"));
        parameters.put("remember_me", "0");
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static Map<String, String> getCommonParameters(Kushki kushki) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("currency_code", kushki.getCurrency());
        parameters.put("merchant_identi***REMOVED***er", kushki.getMerchantId());
        parameters.put("language_indicator", kushki.getLanguage());
        return parameters;
***REMOVED***
***REMOVED***
