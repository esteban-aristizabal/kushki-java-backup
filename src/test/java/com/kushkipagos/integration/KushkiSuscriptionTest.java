***REMOVED***

import com.kushki.Enum.KushkiAdjustSuscriptionEnum;
import com.kushki.Enum.KushkiPeriodicitySuscriptionEnum;
***REMOVED***
import com.kushki.TO.Amount;
import com.kushki.TO.ContactDetail;
import com.kushki.TO.SuscriptionInfo;
import com.kushki.TO.Transaction;
***REMOVED***
import org.junit.Before;
***REMOVED***

import java.util.Date;

import static com.kushkipagos.integration.IntegrationHelper.getKushkiTESTECCommerce;
***REMOVED***

public class KushkiSuscriptionTest {


    private JSONObject longTestJSON;

    @Before
    public void setUp() throws Exception {
        longTestJSON = new JSONObject("{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":{\"GlossEntry\":{\"ID\":\"SGML\",\"SortAs\":\"SGML\",\"GlossTerm\":\"Standard Generalized Markup Language\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\",\"GlossDef\":{\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]***REMOVED***,\"GlossSee\":\"markup\"***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***");
***REMOVED***

***REMOVED***
    public void goodSubscriptionTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            assertThat("Good subscription", transaction.isSuccessful());
            assertThat("get the subscription id", transaction.getSubscriptionId().length() > 0);
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodSubscriptionUpdateCardTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            assertThat("Good Subscription", transaction.isSuccessful());
            String subscriptionId = transaction.getSubscriptionId();
            assertThat("get the subscription id", transaction.getSubscriptionId().length() > 0);
            String tokenUpdate = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
            transaction = kushki.updateSubscriptionCard(tokenUpdate, subscriptionId);
            assertThat("Good subscription", transaction.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodSubscriptionAdjustmentTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            assertThat("Good Subscription", transaction.isSuccessful());
            String subscriptionId = transaction.getSubscriptionId();
            assertThat("get the subscription id", subscriptionId.length() > 0);
            transaction = kushki.adjustSubscription(subscriptionId, new Date(), 2, new Amount(10d, 1d, 0d, 0d), KushkiAdjustSuscriptionEnum.DISCOUNT);
            assertThat("Good subscription", transaction.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodUpdateSubscriptionTestNullMetadata() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            String transaccionId = transaction.getSubscriptionId();
            transaction = kushki.updateSubscription(amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")), transaccionId);
            assertThat("Good update", transaction.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodUpdateSubscriptionTestAmountNull() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            String transaccionId = transaction.getSubscriptionId();
            transaction = kushki.updateSubscription(null, longTestJSON, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")), transaccionId);
            assertThat("Good update", transaction.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***


    //TODO check the reason of fail of this when run with others test.
    public void deleteSubscription() {
***REMOVED***
            Kushki kushki = getKushkiTESTECCommerce();
            Amount amount = new Amount(100d, 12d, 0d, 0d);
            String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            String subscriptionId = transaction.getSubscriptionId();
            Thread.sleep(10000);
            Transaction deleteSubscription = kushki.deleteSubscription(subscriptionId);
            assertThat("Error in delete transaction:"+transaction+" / subsc:"+deleteSubscription, deleteSubscription.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***


***REMOVED***
    public void goodUpdateSubscriptionTestNullSubscriptionInfo() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, longTestJSON,  new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            String transaccionId = transaction.getSubscriptionId();
            transaction = kushki.updateSubscription(amount, longTestJSON, null, transaccionId);
            assertThat("Good update", transaction.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***


***REMOVED***
    public void badUpdateSubscriptionTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.updateSubscription(amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")), "123");
            assertThat("Good Charge", !transaction.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodSubscriptionChargeTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            assertThat("Good Charge", transaction.isSuccessful());
            assertThat("get the ticket of a wonderful charge", transaction.getSubscriptionId().length() > 0);
            String subscriptionId = transaction.getSubscriptionId();
            transaction = kushki.subscriptionCharge("123", new Amount(100d, 12d, 0d, 0d), longTestJSON, subscriptionId);
            assertThat("Good Charge", transaction.isSuccessful());
            assertThat("get the ticket of a wonderful charge", transaction.getTicketNumber().length() > 0);
            transaction = kushki.subscriptionCharge(null, new Amount(100d, 12d, 0d, 0d), longTestJSON, subscriptionId);
            assertThat("Good Charge", transaction.isSuccessful());
            assertThat("get the ticket of a wonderful charge", transaction.getTicketNumber().length() > 0);
            transaction = kushki.subscriptionCharge("123", null, longTestJSON, subscriptionId);
            assertThat("Good Charge", transaction.isSuccessful());
            transaction = kushki.subscriptionCharge("123", new Amount(100d, 12d, 0d, 0d), null, subscriptionId);
            assertThat("Good Charge", transaction.isSuccessful());
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void badSubscriptionChargeTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidSubscriptionChargeToken(getKushkiTESTECCommerce());
***REMOVED***
            Transaction transaction = kushki.subscription(token, amount, null, new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                    new Date(), new ContactDetail("Heidi", "Nino", "user@user.com")));
            assertThat("Good Charge", transaction.isSuccessful());
            assertThat("get the ticket of a wonderful charge", transaction.getSubscriptionId().length() > 0);
            transaction = kushki.subscriptionCharge("123", new Amount(100d, 12d, 0d, 0d), longTestJSON, null);
            assertThat("normal fail Charge", !transaction.isSuccessful());
            assertThat("must be Empty thischarge", transaction.getTicketNumber() == "");
***REMOVED***
            assertThat("The test throw a exception", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
