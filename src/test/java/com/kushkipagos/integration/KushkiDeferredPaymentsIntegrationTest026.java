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

import static com.kushkipagos.integration.IntegrationTestsHelpers.assertsValidTransaction;
import static org.hamcrest.CoreMatchers.is;
***REMOVED***

/**
 * Created by lmunda on 1/21/16 16:15.
 */
public class KushkiDeferredPaymentsIntegrationTest026 {

    private Kushki kushki;

    @Before
    public void setUp() throws Exception {
        kushki = IntegrationTestsHelpers.setupKushki();
***REMOVED***

***REMOVED***
    public void shouldReturnSuccessfulDeferredChargeTransactionTC026() throws BadPaddingException, IllegalBlockSizeException, JsonProcessingException, KushkiException, InterruptedException {
        Transaction tokenTransaction = IntegrationTestsHelpers.getValidTokenTransaction(kushki);
        Double amount = TestsHelpers.getRandomAmount();
        Integer months = TestsHelpers.getRandomMonths();
        Double interest = TestsHelpers.getRandomInterest();
        String token = tokenTransaction.getToken();

        Thread.sleep(IntegrationTestsHelpers.THREAD_SLEEP);
        Transaction deferredChargeTransaction = kushki.deferredCharge(token, amount, months, interest);

        assertsValidTransaction(tokenTransaction);
        assertsValidTransaction(deferredChargeTransaction);
***REMOVED***
***REMOVED***
