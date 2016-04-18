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
//    public static ***REMOVED***nal String SECRET_MERCHANT_ID = "10000001604093396985111213";
//    public static ***REMOVED***nal String MERCHANT_ID = "10000001604093396985111213";

    public static ***REMOVED***nal String SECRET_MERCHANT_ID = "10000001641088709280111217";
    public static ***REMOVED***nal String MERCHANT_ID = "10000001641080185390111217";

    private IntegrationTestsHelpers() {
***REMOVED***

    public static Kushki setupKushki(Boolean isSecret) throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        String merchantId = MERCHANT_ID;
        if (isSecret) {
            merchantId = SECRET_MERCHANT_ID;
***REMOVED***
        // String merchantId = "10000001408518323354818001"; //TW 7 fails: 006, 007, 026, 025, 009, 014, 024: 006: Transacción rechazada
        // String merchantId = "10000001604958481814111215"; //GMS OK
        // String merchantId = "10000001604093396985111213"; //fybeca OK
        // String merchantId = "10000001605036059475111214"; //ya esta OK
        // String merchantId = "10000001605199764649111216"; //latam
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
        if (isSuccessful != transaction.isSuccessful()) {
            System.out.println("Is successful? " + transaction.isSuccessful() + " Expected: " + isSuccessful);
            System.out.println("Response text: " + transaction.getResponseText() + " Expected: " + expectedMessage);
            System.out.println("Response code: " + transaction.getResponseCode() + " Expected: " + expectedCode);
***REMOVED***
        assertThat(transaction.isSuccessful(), is(isSuccessful));
        assertThat(transaction.getResponseText(), is(expectedMessage));
        assertThat(transaction.getResponseCode(), is(expectedCode));
***REMOVED***

    public static void assertsValidTransaction(Transaction transaction) {
        assertsTransaction(transaction, true, "Transacción aprobada", "000");
***REMOVED***

***REMOVED***
