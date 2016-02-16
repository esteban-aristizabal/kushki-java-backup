***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiException;
import com.kushkipagos.commons.TestsHelpers;
import com.kushkipagos.Transaction;
import org.junit.Before;
***REMOVED***

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsValidTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.getValidTokenTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.setupKushki;

/**
 * Created by lmunda on 1/22/16 09:47.
 */
public class KushkiTokenIntegrationTest001to005and020to022 {
    private Kushki kushki;
    Map<String, String> cardParams = new HashMap<>(5);
    private Transaction tokenTransaction;

    @Before
    public void setUp() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        kushki = setupKushki();
        cardParams = TestsHelpers.getValidCardData();
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulTokenTransactionTC001() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        tokenTransaction = getValidTokenTransaction(kushki);

        assertsValidTransaction(tokenTransaction);
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionInvalidCardTC002() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        cardParams.put("number", "5411111111115854");

        tokenTransaction = kushki.requestToken(cardParams);

        assertsTransaction(tokenTransaction, false, "Tarjeta no válida", "017");
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionInvalidExpiryTC003() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        cardParams.put("expiry_month", "ab");
        cardParams.put("expiry_year", "cd");

        tokenTransaction = kushki.requestToken(cardParams);

        assertsTransaction(tokenTransaction, false, "Tarjeta no válida", "017");
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionCardExpiredTC004() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        cardParams.put("expiry_month", "12");
        cardParams.put("expiry_year", "14");

        tokenTransaction = kushki.requestToken(cardParams);

        assertsTransaction(tokenTransaction, false, "Tarjeta vencida", "018");
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionInvalidCVVTC005() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        cardParams.put("cvv", "abc");

        tokenTransaction = kushki.requestToken(cardParams);

        assertsTransaction(tokenTransaction, false, "CVC no válido", "007");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedTokenTransactionInvalidMerchantIdTC020() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        String merchantId = "abc";
        String language = "es";
        String currency = "USD";
        kushki = new Kushki(merchantId, language, currency);

        Transaction tokenTransaction = getValidTokenTransaction(kushki);

        assertsTransaction(tokenTransaction, false, "ID de comercio no válido", "201");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedTokenTransactionInvalidLanguageTC021() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        String merchantId = "10000001408518323354818001";
        String language = "xyz";
        String currency = "USD";
        kushki = new Kushki(merchantId, language, currency);

        Transaction tokenTransaction = getValidTokenTransaction(kushki);

        assertsTransaction(tokenTransaction, false, "Indicador de idioma no válido", "277");
***REMOVED***
***REMOVED***
