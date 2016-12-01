package com.kushkipagos.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kushkipagos.Card;
***REMOVED***

import static org.hamcrest.CoreMatchers.is;
***REMOVED***

public class CardTest {
***REMOVED***
    public void shouldSerializeToJson() throws Exception {
        Card card = new Card("SOME NAME", "4242424242424242", "718", "05", "19");
        ObjectMapper objectMapper = new ObjectMapper();
        String cardJson = objectMapper.writeValueAsString(card);
        String expectedJson = "{" +
                "\"name\":\"SOME NAME\"," +
                "\"number\":\"4242424242424242\"," +
                "\"cvv\":\"718\"," +
                "\"expiry_month\":\"05\"," +
                "\"expiry_year\":\"19\"," +
                "\"card_present\":\"1\"" +
                "***REMOVED***";
        assertThat(cardJson, is(expectedJson));
***REMOVED***
***REMOVED***