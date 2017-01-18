***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
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
        return getValidTokenTransaction(kushki, 4d);
***REMOVED***

    static Transaction getValidTokenTransaction(Kushki kushki, Double totalAmount) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        return kushki.requestToken(TestsHelpers.getValidCard(), totalAmount);
***REMOVED***

    static Transaction getValidTokenTransactionColombia(Kushki kushki) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        return kushki.requestTokenColombia(TestsHelpers.getValidCardColombia(), 3200d);
***REMOVED***

    static Transaction getValidTokenTransactionColombia(Kushki kushki, Double totalAmount) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException {
        return kushki.requestTokenColombia(TestsHelpers.getValidCardColombia(), totalAmount);
***REMOVED***
***REMOVED***
