***REMOVED***

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kushkipagos.Amount;
import com.kushkipagos.Kushki;
import com.kushkipagos.KushkiException;
import com.kushkipagos.Transaction;
import org.junit.Before;
***REMOVED***

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import static com.kushkipagos.commons.TestsHelpers.*;
import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsValidTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.getValidTokenTransaction;
import static com.kushkipagos.integration.IntegrationTestsHelpers.setupKushki;

/**
 * Created by lmunda on 1/21/16 16:15.
 */
public class KushkiDeferredPaymentsIntegrationTest026 {

    private Kushki kushki;
    private Kushki secretKushki;

    @Before
    public void setUp() throws Exception {
        kushki = setupKushki(false);
        secretKushki = setupKushki(true);
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulDeferredChargeTransactionTC026() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException, InterruptedException {
        Transaction tokenTransaction = getValidTokenTransaction(kushki);
        Amount amount = getRandomAmount();
        Integer months = getRandomMonths();
        String token = tokenTransaction.getToken();

        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction deferredChargeTransaction = secretKushki.deferredCharge(token, amount, months);

        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(deferredChargeTransaction);
***REMOVED***
***REMOVED***
