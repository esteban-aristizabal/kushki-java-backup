package com.kushkipagos.unit;


import com.kushki.Enum.KushkiEnvironment;
import com.kushki.Enum.KushkiPeriodicitySuscriptionEnum;
***REMOVED***
import com.kushki.KushkiException;
import com.kushki.ParametersBuilder;
import com.kushki.TO.Amount;
import com.kushki.TO.ContactDetail;
import com.kushki.TO.ExtraTaxes;
import com.kushki.TO.SuscriptionInfo;

***REMOVED***
import org.junit.Before;
***REMOVED***
import org.skyscreamer.jsonassert.JSONAssert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
***REMOVED***

public class KushkiSuscriptionParameterBuilderTest {
    private Kushki kushki;
    private JSONObject longTestJSON;

    @Before
    public void setUp() throws Exception {
        String merchantId = randomAlphabetic(10);
        String language = randomAlphabetic(2);
        String currency = randomAlphabetic(3);
        kushki = new Kushki(merchantId, language, currency, KushkiEnvironment.TESTING);
        longTestJSON = new JSONObject("{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":{\"GlossEntry\":{\"ID\":\"SGML\",\"SortAs\":\"SGML\",\"GlossTerm\":\"Standard Generalized Markup Language\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\",\"GlossDef\":{\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]***REMOVED***,\"GlossSee\":\"markup\"***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***");

***REMOVED***


***REMOVED***
    public void happySubscriptionTest() {
        String token = randomAlphabetic(10);
***REMOVED***
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse("30/07/1987");
            JSONObject response = ParametersBuilder.getSubscriptionParams(
                    this.kushki, token, new Amount(100d, 12d, 0d, 0d), longTestJSON,
                    new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                            date, new ContactDetail("Heidi", "Nino", "user@user.com")));
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"amount\":{\"subtotalIva0\":0,\"iva\":12,\"subtotalIva\":100,\"ice\":0,\"currency\":\"" + kushki.getCurrency() + "\"***REMOVED***," +
                            "\"periodicity\":\"monthly\",\"planName\":\"SuperPLAN\",\"language\":\"" + kushki.getLanguage() + "\"," +
                            "\"contactDetails\":{\"***REMOVED***rstName\":\"Heidi\",\"lastName\":\"Nino\",\"email\":\"user@user.com\"***REMOVED***," +
                            "\"startDate\":\"1987-07-30\",\"token\":\"" + token + "\"," +
                            " \"metadata\":{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":{\"GlossEntry\":{\"ID\":\"SGML\",\"SortAs\":\"SGML\",\"GlossTerm\":\"Standard Generalized Markup Language\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\",\"GlossDef\":{\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]***REMOVED***,\"GlossSee\":\"markup\"***REMOVED******REMOVED******REMOVED******REMOVED******REMOVED***" +
                            "***REMOVED***", response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***

***REMOVED***
    public void happyChargeSubscriptionTestWithOptionalData() {
***REMOVED***
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            JSONObject response = ParametersBuilder.getSubscriptionChargeParams("123", new Amount(100d, 12d, 0d, 0d), longTestJSON, kushki);
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"cvv\":\"123\"" +
                            ",\"amount\":{\"subtotalIva0\":0,\"iva\":12,\"subtotalIva\":100,\"ice\":0,\"currency\":\""+kushki.getCurrency()+"\"***REMOVED***" +
                            ",\"metadata\":{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"GlossList\":{\"GlossEntry\":{\"GlossTerm\":\"Standard Generalized Markup Language\",\"GlossSee\":\"markup\",\"SortAs\":\"SGML\",\"GlossDef\":{\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]***REMOVED***,\"ID\":\"SGML\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\"***REMOVED******REMOVED***,\"title\":\"S\"***REMOVED******REMOVED******REMOVED***" +
                            ",\"language\":\""+kushki.getLanguage()+"\"***REMOVED***\n"
                    , response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***
***REMOVED***
    public void happyChargeSubscriptionTestWithoutOptionalData() {
***REMOVED***
            JSONObject response = ParametersBuilder.getSubscriptionChargeParams(null,null,null, kushki);
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"language\":\""+kushki.getLanguage()+"\"***REMOVED***\n"
                    , response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***

***REMOVED***
    public void happySubscriptionTestWithoutMetadata() {
        String token = randomAlphabetic(10);
***REMOVED***
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse("30/07/1987");
            JSONObject response = ParametersBuilder.getSubscriptionParams(
                    this.kushki, token, new Amount(100d, 12d, 0d, 0d), null,
                    new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                            date, new ContactDetail("Heidi", "Nino", "user@user.com")));
            JSONAssert.assertEquals("Bad JSON answer. The answer is " + response.toString(),
                    "{\"amount\":{\"subtotalIva0\":0,\"iva\":12,\"subtotalIva\":100,\"ice\":0,\"currency\":\"" + kushki.getCurrency() + "\"***REMOVED***," +
                            "\"periodicity\":\"monthly\",\"planName\":\"SuperPLAN\",\"language\":\"" + kushki.getLanguage() + "\"," +
                            "\"contactDetails\":{\"***REMOVED***rstName\":\"Heidi\",\"lastName\":\"Nino\",\"email\":\"user@user.com\"***REMOVED***," +
                            "\"startDate\":\"1987-07-30\",\"token\":\"" + token + "\"" +
                            "***REMOVED***", response, true);
***REMOVED***
            assertThat("this line must be unreachable", false);
***REMOVED***
***REMOVED***

***REMOVED***
    public void SubscriptionTestWithoutDate() {
        String token = randomAlphabetic(10);
***REMOVED***
            JSONObject response = ParametersBuilder.getSubscriptionParams(
                    this.kushki, token, new Amount(100d, 12d, 0d, 0d), null,
                    new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                            null, new ContactDetail("Heidi", "Nino", "user@user.com")));
            assertThat("this line must be unreachable", false);
***REMOVED***
            assertThat("this line must be execute because Date is null", true);
***REMOVED***
***REMOVED***

***REMOVED***
    public void SubscriptionTestWithoutSubscription() {
        String token = randomAlphabetic(10);
***REMOVED***
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse("30/07/1987");
            JSONObject response = ParametersBuilder.getSubscriptionParams(
                    this.kushki, token, new Amount(100d, 12d, 0d, 0d), null,
                    null);
            assertThat("this line must be unreachable", false);
***REMOVED***
            assertThat("this line must be execute because Date is null", true);
***REMOVED***
***REMOVED***

***REMOVED***
    public void SubscriptionTestWithoutAmount() {
        String token = randomAlphabetic(10);
***REMOVED***
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse("30/07/1987");
            JSONObject response = ParametersBuilder.getSubscriptionParams(
                    this.kushki, token, null, null,
                    new SuscriptionInfo("SuperPLAN", KushkiPeriodicitySuscriptionEnum.MONTLY,
                            date, new ContactDetail("Heidi", "Nino", "user@user.com")));
            assertThat("this line must be unreachable", false);
***REMOVED***
            assertThat("this line must be execute because Date is null", true);
***REMOVED***
***REMOVED***

***REMOVED***

