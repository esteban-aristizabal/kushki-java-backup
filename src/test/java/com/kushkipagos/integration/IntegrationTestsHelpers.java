***REMOVED***

import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiEnvironment;
import com.kushkipagos.Transaction;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
***REMOVED***

***REMOVED***nal class IntegrationTestsHelpers {

    ***REMOVED***nal static int THREAD_SLEEP = 1000;
    ***REMOVED***nal static int THREAD_SLEEP_VOID = 4000;

    public static ***REMOVED***nal String MERCHANT_ID = "10000001641310597258111220";
    private static ***REMOVED***nal String SECRET_MERCHANT_ID = "10000001641344874123111220";

    private static ***REMOVED***nal Logger LOG = Logger.getLogger(IntegrationTestsHelpers.class.getName());

    private IntegrationTestsHelpers() {
***REMOVED***

    static Kushki setupKushki(Boolean isSecret) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        String merchantId = MERCHANT_ID;
        if (isSecret) {
            merchantId = SECRET_MERCHANT_ID;
***REMOVED***
        return new Kushki(merchantId, "es", "USD", KushkiEnvironment.TESTING);
***REMOVED***

    static void assertsTransaction(Transaction transaction, Boolean isSuccessful,
                                   String expectedMessage, String expectedCode) {
        Boolean resultSuccessful = transaction.isSuccessful();
        String resultMessage = transaction.getResponseText();
        String resultCode = transaction.getResponseCode();
        if (!isSuccessful.equals(resultSuccessful) || !expectedMessage.equals(resultMessage) || !expectedCode.equals(resultCode)) {
            LOG.warning("\n\nIs successful? " + resultSuccessful + " Expected: " + isSuccessful);
            LOG.warning("Failed ticket number: " + transaction.getTicketNumber());
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
