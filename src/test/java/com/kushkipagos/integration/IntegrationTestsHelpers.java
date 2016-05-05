***REMOVED***

import com.kushkipagos.Kushki;
import com.kushkipagos.Transaction;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
***REMOVED***

/**
 * Created by lmunda on 1/21/16 16:16.
 */
***REMOVED***nal class IntegrationTestsHelpers {

    ***REMOVED***nal static int THREAD_SLEEP = 600;

    private static ***REMOVED***nal String SECRET_MERCHANT_ID = "10000001641088709280111217";
    public static ***REMOVED***nal String MERCHANT_ID = "10000001641080185390111217";

    private static ***REMOVED***nal Logger LOG = Logger.getLogger(IntegrationTestsHelpers.class.getName());

    private IntegrationTestsHelpers() {
***REMOVED***

    static Kushki setupKushki(Boolean isSecret) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        String merchantId = MERCHANT_ID;
        if (isSecret) {
            merchantId = SECRET_MERCHANT_ID;
***REMOVED***
        String language = "es";
        String currency = "USD";
        return new Kushki(merchantId, language, currency);
***REMOVED***

    static void assertsTransaction(Transaction transaction, Boolean isSuccessful,
                                   String expectedMessage, String expectedCode) {
        Boolean resultSuccessful = transaction.isSuccessful();
        String resultMessage = transaction.getResponseText();
        String resultCode = transaction.getResponseCode();
        if (!isSuccessful.equals(resultSuccessful) || !expectedMessage.equals(resultMessage) || !expectedCode.equals(resultCode)) {
            LOG.warning("\n\nIs successful? " + resultSuccessful + " Expected: " + isSuccessful);
            LOG.warning("Response text: " + resultMessage + " Expected: " + expectedMessage);
            LOG.warning("Response code: " + resultCode + " Expected: " + expectedCode + "\n\n");
***REMOVED***
        assertThat(resultSuccessful, is(isSuccessful));
        assertThat(resultMessage, is(expectedMessage));
        assertThat(resultCode, is(expectedCode));
***REMOVED***

    static void assertsValidTransaction(Transaction transaction) {
        assertsTransaction(transaction, true, "Transacción aprobada", "000");
***REMOVED***


***REMOVED***
