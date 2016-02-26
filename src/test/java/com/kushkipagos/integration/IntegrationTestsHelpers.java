***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Kushki;
import com.kushkipagos.Transaction;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import static com.kushkipagos.commons.TestsHelpers.getValidCardData;
import static org.hamcrest.CoreMatchers.is;
***REMOVED***

/**
 * Created by lmunda on 1/21/16 16:16.
 */
public ***REMOVED***nal class IntegrationTestsHelpers {

    public ***REMOVED***nal static int THREAD_SLEEP = 600;

    private IntegrationTestsHelpers() {
***REMOVED***

    public static Kushki setupKushki() throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        String merchantId = "10000001408518323354818001"; //TW
//        String merchantId = "10000001604958481814111215"; //GMS
//        String merchantId = "10000001604093396985111213"; //fybeca
        String language = "es";
        String currency = "USD";
        return new Kushki(merchantId, language, currency);
***REMOVED***

    public static Transaction getValidTokenTransaction(Kushki kushki) throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException {
        Map<String, String> cardParams = getValidCardData();
        return kushki.requestToken(cardParams);
***REMOVED***

    public static void assertsTransaction(Transaction transaction, Boolean isSuccessful,
                                          String expectedMessage, String expectedCode) {
        assertThat(transaction.isSuccessful(), is(isSuccessful));
        assertThat(transaction.getResponseText(), is(expectedMessage));
        assertThat(transaction.getResponseCode(), is(expectedCode));
***REMOVED***

    public static void assertsValidTransaction(Transaction transaction) {
        assertsTransaction(transaction, true, "Transacción aprobada", "000");
***REMOVED***

***REMOVED***
