***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Amount;
import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiEnvironment;
import com.kushkipagos.KushkiException;
import com.kushkipagos.Transaction;
import com.kushkipagos.commons.TestsHelpers;
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
import static com.kushkipagos.integration.TokenHelper.getValidTokenTransaction;

public class KushkiChargeIntegrationTest006to008and023 {
    private Kushki kushki;
    private Kushki secretKushki;

    private Transaction tokenTransaction;
    private Transaction chargeTransaction;
    private Amount amount;
    private String token;

    @Before
    public void setUp() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InterruptedException {
        kushki = setupKushki(false);
        secretKushki = setupKushki(true);

        amount = TestsHelpers.getRandomAmount();
        tokenTransaction = getValidTokenTransaction(kushki, amount.getTotalAmount());
        token = tokenTransaction.getToken();
        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        chargeTransaction = secretKushki.charge(token, amount);
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulChargeTransactionTC006() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException {
        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(chargeTransaction);
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulChargeTransactionUsedTokenTC007() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException, InterruptedException {
        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction secondChargeTransaction = secretKushki.charge(token, amount);

        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(chargeTransaction);
        assertsTransaction(secondChargeTransaction, false, "El token de la transacción ha expirado", "578");
***REMOVED***

***REMOVED***
    public void shouldReturnNonSuccessfulChargeTransactionInvalidTokenTC008() throws JsonProcessingException, BadPaddingException, IllegalBlockSizeException, KushkiException, InterruptedException {
        String token = "k7jwynu59sd28wu81i2ygsyvlly***REMOVED***mju";

        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction chargeTransaction = secretKushki.charge(token, amount);

        assertsTransaction(chargeTransaction, false, "ID de comercio no válido", "201");
***REMOVED***

***REMOVED***
    public void shouldReturnFailedChargeTransactionInvalidCurrencyTC023() throws IOException, BadPaddingException, IllegalBlockSizeException, KushkiException, InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InterruptedException {
        String merchantId = IntegrationTestsHelpers.MERCHANT_ID;
        String language = "es";
        String currency = "USD";
        String invalidCurrency = "XYZ";
        Kushki tokenKushki = new Kushki(merchantId, language, currency, KushkiEnvironment.TESTING);
        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction tokenTransaction = getValidTokenTransaction(tokenKushki, amount.getTotalAmount());
        String token = tokenTransaction.getToken();

        kushki = new Kushki(merchantId, language, invalidCurrency, KushkiEnvironment.TESTING);
        Transaction chargeTransaction = kushki.charge(token, amount);

        assertsValidTransaction(tokenTransaction);
        assertsTransaction(chargeTransaction, false, "Tipo de moneda no válida", "205");
***REMOVED***
***REMOVED***
