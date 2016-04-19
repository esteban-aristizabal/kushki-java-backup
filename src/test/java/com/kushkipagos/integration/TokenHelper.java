***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Kushki;
import com.kushkipagos.ParametersBuilder;
import com.kushkipagos.Transaction;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
***REMOVED***
***REMOVED***
***REMOVED***
import java.util.Map;

import static com.kushkipagos.Kushki.BASE_URL;
import static com.kushkipagos.Kushki.TOKENS_URL;
import static com.kushkipagos.commons.TestsHelpers.getValidCardData;


/**
 * Created by dvillaci on 4/19/16.
 */

***REMOVED***nal class TokenHelper {

    private TokenHelper() {
***REMOVED***

    static Transaction getValidTokenTransaction(Kushki kushki) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException {
        Map<String, String> cardParams = getValidCardData();
        return requestToken(kushki, cardParams);
***REMOVED***

    static Transaction requestToken(Kushki kushki, Map<String, String> cardParams) throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException {
        Map<String, String> parameters = ParametersBuilder.getTokenParameters(kushki, cardParams);
        return post(TOKENS_URL, parameters);
***REMOVED***

    private static Transaction post(String url, Map<String, String> parameters) {
***REMOVED***
        WebTarget target = client.target(BASE_URL).path(url);

***REMOVED***
        Response response = invocationBuilder.post(Entity.entity(parameters, MediaType.APPLICATION_JSON_TYPE));

        return new Transaction(response);
***REMOVED***
***REMOVED***
