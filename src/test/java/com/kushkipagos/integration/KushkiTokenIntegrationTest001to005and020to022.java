***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Card;
import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiEnvironment;
import com.kushkipagos.KushkiException;
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

import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsValidTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.setupKushki;
import static com.kushkipagos.integration.IntegrationTestsHelpers.setupKushkiColombia;
import static com.kushkipagos.integration.TokenHelper.getValidTokenTransaction;
import static com.kushkipagos.integration.TokenHelper.getValidTokenTransactionColombia;

public class KushkiTokenIntegrationTest001to005and020to022 {
    private Kushki kushki;
    private Kushki kushkiColombia;
    private Transaction tokenTransaction;
    private Transaction tokenTransactionColombia;

    @Before
    public void setUp() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        kushki = setupKushki(false);
        kushkiColombia = setupKushkiColombia(false);
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulTokenTransactionTC001() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        tokenTransaction = getValidTokenTransaction(kushki);
        assertsValidTransaction(tokenTransaction);
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulTokenTransactionTC001Colombia() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        tokenTransactionColombia = getValidTokenTransactionColombia(kushkiColombia);
        assertsValidTransaction(tokenTransactionColombia);
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionInvalidCardTC002() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Card card = new Card("SOME NAME", "5411111111115854", "123", "12", "21");
        tokenTransaction = kushki.requestToken(card, 4d);
        assertsTransaction(tokenTransaction, false, "Tarjeta no válida", "017");
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionInvalidExpiryTC003() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Card card = new Card("SOME NAME", "4017779991118888", "123", "ab", "cd");
        tokenTransaction = kushki.requestToken(card, 4d);
        assertsTransaction(tokenTransaction, false, "Tarjeta no válida", "017");
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionCardExpiredTC004() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Card card = new Card("SOME NAME", "4017779991118888", "123", "12", "14");
        tokenTransaction = kushki.requestToken(card, 4d);
        assertsTransaction(tokenTransaction, false, "Tarjeta vencida", "018");
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulTokenTransactionInvalidCvvTC005() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        Card card = new Card("SOME NAME", "4017779991118888", "abc", "12", "21");
        tokenTransaction = kushki.requestToken(card, 4d);
        assertsTransaction(tokenTransaction, false, "CVC no válido", "007");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedTokenTransactionInvalidMerchantIdTC020() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        String merchantId = "abc";
        String language = "es";
        String currency = "USD";
        kushki = new Kushki(merchantId, language, currency, KushkiEnvironment.TESTING);
        Transaction tokenTransaction = getValidTokenTransaction(kushki);
        assertsTransaction(tokenTransaction, false, "ID de comercio no válido", "201");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedTokenTransactionInvalidLanguageTC021() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        String merchantId = "10000001408518323354818001";
        String language = "xyz";
        String currency = "USD";
        kushki = new Kushki(merchantId, language, currency, KushkiEnvironment.TESTING);
        Transaction tokenTransaction = getValidTokenTransaction(kushki);
        assertsTransaction(tokenTransaction, false, "Indicador de idioma no válido", "277");
***REMOVED***
***REMOVED***
