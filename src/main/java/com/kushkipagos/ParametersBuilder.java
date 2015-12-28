package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lmunda on 12/28/15 12:22.
 */
public class ParametersBuilder {

    public static Map<String, String> getTokenParameters(Kushki kushki, Map<String, String> cardParams) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException {
        ObjectMapper mapper = new ObjectMapper();
        String params = mapper.writeValueAsString(cardParams);
        params = buildAndStringifyTokenParameters(kushki, params);
        return encryptParams(kushki, params);
***REMOVED***

    public static Map<String, String> getChargeParameters(Kushki kushki, String token, String amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException {
        String params = buildAndStringifyChargeParameters(kushki, token, amount);
        return encryptParams(kushki, params);
***REMOVED***

    public static Map<String, String> getVoidRefundParameters(Kushki kushki, String token, String ticket, String amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException {
        String params = buildAndStringifyVoidRefundParameters(kushki, token, ticket, amount);
        return encryptParams(kushki, params);
***REMOVED***

    private static Map<String, String> encryptParams(Kushki kushki, String params) throws BadPaddingException, IllegalBlockSizeException {
        String encString = kushki.getEncryption().encryptMessageChunk(params);
        Map<String, String> encryptedParameters = new HashMap<>(1);
        encryptedParameters.put("request", encString);
        return encryptedParameters;
***REMOVED***

    private static String buildAndStringifyTokenParameters(Kushki kushki, String cardParams) throws JsonProcessingException {
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("card", cardParams);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyChargeParameters(Kushki kushki, String token, String amount) throws JsonProcessingException {
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("transaction_token", token);
        parameters.put("transaction_amount", amount);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static String buildAndStringifyVoidRefundParameters(Kushki kushki, String token, String ticket, String amount) throws JsonProcessingException {
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("ticket_number", ticket);
        parameters.put("transaction_token", token);
        parameters.put("transaction_amount", amount);

        ObjectMapper mapper = new ObjectMapper();
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
