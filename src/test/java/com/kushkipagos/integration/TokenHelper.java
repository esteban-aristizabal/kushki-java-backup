***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kushkipagos.Amount;
import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiEnvironment;
import com.kushkipagos.KushkiException;
import com.kushkipagos.Transaction;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
***REMOVED***
***REMOVED***
import java.util.HashMap;
import java.util.Map;

import static com.kushkipagos.Kushki.TOKENS_URL;
import static com.kushkipagos.commons.TestsHelpers.getRandomAmount;
import static com.kushkipagos.commons.TestsHelpers.getValidCardData;

***REMOVED***nal class TokenHelper {

    private TokenHelper() {
***REMOVED***

    static Transaction getValidTokenTransaction(Kushki kushki) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        return getValidTokenTransaction(kushki, getRandomAmount());
***REMOVED***

    static Transaction getValidTokenTransaction(Kushki kushki, Amount amount) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        Map<String, String> cardParams = getValidCardData();
        return requestToken(kushki, cardParams, amount);
***REMOVED***

    static Transaction requestToken(Kushki kushki, Map<String, String> cardParams) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        return requestToken(kushki, cardParams, getRandomAmount());
***REMOVED***

    static Transaction requestToken(Kushki kushki, Map<String, String> cardParams, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Map<String, String> parameters = getTokenParameters(kushki, cardParams, amount);
        return post(parameters);
***REMOVED***

    private static Transaction post(Map<String, String> parameters) {
***REMOVED***
        WebTarget target = client.target(KushkiEnvironment.TESTING.getUrl()).path(TOKENS_URL);

***REMOVED***
        Response response = invocationBuilder.post(Entity.entity(parameters, MediaType.APPLICATION_JSON_TYPE));

        return new Transaction(response);
***REMOVED***

    private static Map<String, String> getTokenParameters(Kushki kushki, Map<String, String> cardParams, Amount amount) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        ObjectMapper mapper = new ObjectMapper();
        String params = mapper.writeValueAsString(cardParams);
        params = buildAndStringifyTokenParameters(kushki, params, amount);
        return encryptParams(kushki, params);
***REMOVED***

    private static String buildAndStringifyTokenParameters(Kushki kushki, String cardParams, Amount amount) throws JsonProcessingException, KushkiException {
        Map<String, String> parameters = getCommonParameters(kushki);
        parameters.put("card", cardParams);
        parameters.put("amount", amount.toHash().get("Total_amount"));

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(parameters);
***REMOVED***

    private static Map<String, String> encryptParams(Kushki kushki, String params) throws BadPaddingException, IllegalBlockSizeException {
        String encString = kushki.getEncryption().encryptMessageChunk(params);
        Map<String, String> encryptedParameters = new HashMap<>(1);
        encryptedParameters.put("request", encString);
        return encryptedParameters;
***REMOVED***

    private static Map<String, String> getCommonParameters(Kushki kushki) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("currency_code", kushki.getCurrency());
        parameters.put("merchant_identi***REMOVED***er", kushki.getMerchantId());
        parameters.put("language_indicator", kushki.getLanguage());
        parameters.put("remember_me", "0");
        return parameters;
***REMOVED***
***REMOVED***
