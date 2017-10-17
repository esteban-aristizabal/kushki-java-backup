***REMOVED***

import com.kushki.*;
***REMOVED***
import com.kushki.to.ExtraTaxes;
import com.kushki.to.Transaction;
***REMOVED***
import org.junit.Before;
***REMOVED***

import static com.kushkipagos.integration.IntegrationHelper.getKushkiTESTCOCommerce;
import static org.hamcrest.MatcherAssert.*;

import static com.kushkipagos.integration.IntegrationHelper.getKushkiTESTECCommerce;

public class KushkiChargeTest {


    private JSONObject longTestJSON;

    @Before
    public void setUp() throws Exception {
        longTestJSON = new JSONObject("{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":{\"GlossEntry\":{\"ID\":\"SGML\",\"SortAs\":\"SGML\",\"GlossTerm\":\"Standard Generalized Markup Language\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\",\"GlossDef\":{\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]***REMOVED***,\"GlossSee\":\"markup\"***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***");
***REMOVED***


***REMOVED***
    public void goodChargeTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount ammount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTECCommerce(), ammount);
***REMOVED***
            Transaction charge = kushki.charge(token, ammount, null, null);
            assertThat("Good Charge", charge.isSuccessful());
            assertThat("get the ticket of a wonderfull charge", charge.getTicketNumber().length() > 0);
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodChargeTestWithExtraTax() {
        Kushki kushki = getKushkiTESTCOCommerce();
        Amount amount = new Amount(90d, 12d, 0d, 0d);
        amount.setExtraTaxes(new ExtraTaxes(1d, 2d, 3d, 4d));
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTCOCommerce(), amount);
***REMOVED***
            Transaction charge = kushki.charge(token, amount, null, null);
            assertThat("Good Charge with Extra Tax" + amount.getTotalAmount(), charge.isSuccessful());
            assertThat("get the ticket of a wonderful charge with extra tax", charge.getTicketNumber().length() > 0);
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodChargeTestWithMetadata() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTECCommerce(), amount);
***REMOVED***
            Transaction charge = kushki.charge(token, amount, null, longTestJSON);
            assertThat("Good Charge", charge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodChargeWithDeferredTest() {
        Kushki kushki = getKushkiTESTCOCommerce();
        Amount ammount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTCOCommerce(), ammount);
***REMOVED***
            Transaction charge = kushki.charge(token, ammount, 12, null);
            assertThat("Good Charge", charge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void goodChargeWithDeferredAndMetadataTest() {
        Kushki kushki = getKushkiTESTCOCommerce();
        Amount ammount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTCOCommerce(), ammount);
***REMOVED***
            Transaction charge = kushki.charge(token, ammount, 12, longTestJSON);
            assertThat("Good Charge", charge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void badCommerceCharge() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount ammount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTCOCommerce(), ammount);
***REMOVED***
            Transaction charge = kushki.charge(token, ammount, 12, null);
            assertThat("Good Charge", !charge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***


***REMOVED***
    public void invalidTotalChargeTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount ammount = new Amount(100d, 12d, 0d, 0d);
        Amount ammountChanged = new Amount(120d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTECCommerce(), ammount);
***REMOVED***
            Transaction charge = kushki.charge(token, ammountChanged, null, null);
            assertThat("The total Amount of the Charge was broken", !charge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void invalidTokenChargeTest() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTECCommerce(), amount);
***REMOVED***
            Transaction charge = kushki.charge(token.concat("AA"), amount, null, null);
            assertThat("The total Amount of the Charge was broken", !charge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void testGoodVoidCharge() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTECCommerce(), amount);
***REMOVED***
            Transaction charge = kushki.charge(token, amount, null, null);
            assertThat("Good Charge", charge.isSuccessful());
            Thread.sleep(5000);
            Transaction voidCharge = kushki.voidCharge(charge.getTicketNumber());
            assertThat("Good Void", voidCharge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
    public void testRefundCharge() {
        Kushki kushki = getKushkiTESTECCommerce();
        Amount amount = new Amount(100d, 12d, 0d, 0d);
        String token = IntegrationHelper.getValidChargeToken(getKushkiTESTECCommerce(), amount);
***REMOVED***
            Transaction charge = kushki.charge(token, amount, null, null);
            assertThat("Fail the charge", charge.isSuccessful());
            Thread.sleep(5000);
            Transaction refundCharge = kushki.refundCharge(charge.getTicketNumber());
            System.out.println(refundCharge);
            assertThat("Fail de refund", refundCharge.isSuccessful());
***REMOVED***
            assertThat("The test break", false);
***REMOVED***
***REMOVED***
***REMOVED***


***REMOVED***
