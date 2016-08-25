***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Amount;
import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiException;
import com.kushkipagos.Transaction;
import com.kushkipagos.commons.TestsHelpers;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

***REMOVED***nal class TokenHelper {

    private TokenHelper() {
***REMOVED***

    static Transaction getValidTokenTransaction(Kushki kushki) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        return getValidTokenTransaction(kushki, TestsHelpers.getRandomAmount());
***REMOVED***

    static Transaction getValidTokenTransaction(Kushki kushki, Amount amount) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        return kushki.requestToken(TestsHelpers.getValidCard(), amount);
***REMOVED***
***REMOVED***
