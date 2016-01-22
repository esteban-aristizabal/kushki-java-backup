package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Assert;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
***REMOVED***
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextDouble;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.hamcrest.CoreMatchers.is;
***REMOVED***
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lmunda on 12/16/15 10:22.
 */
public ***REMOVED***nal class TestsHelpers {

    private TestsHelpers() {

***REMOVED***

    public static void mockEncryption(Kushki kushki, AurusEncryption encryption, String encrypted) throws NoSuchFieldException, IllegalAccessException, BadPaddingException, IllegalBlockSizeException {
        injectMockEncryption(kushki, encryption);
        when(encryption.encryptMessageChunk(any(String.class))).thenReturn(encrypted);
***REMOVED***

    private static void injectMockEncryption(Kushki kushki, AurusEncryption encryption) throws NoSuchFieldException, IllegalAccessException {
        Class<?> klass = kushki.getClass();
        Field ***REMOVED***eld = klass.getDeclaredField("encryption");
        ***REMOVED***eld.setAccessible(true);
        ***REMOVED***eld.set(kushki, encryption);
***REMOVED***

    public static WebResource.Builder mockClient(Kushki kushki, String url) throws NoSuchFieldException, IllegalAccessException {
        Client client = mock(Client.class);
        injectMockClient(kushki, client);
        WebResource webResource = mock(WebResource.class);
        WebResource.Builder requestWithType = mock(WebResource.Builder.class);
        WebResource.Builder requestWithAccept = mock(WebResource.Builder.class);
        when(client.resource(url)).thenReturn(webResource);
        when(webResource.type(MediaType.APPLICATION_JSON_TYPE)).thenReturn(requestWithType);
        when(requestWithType.accept(MediaType.APPLICATION_JSON_TYPE)).thenReturn(requestWithAccept);
        return requestWithAccept;
***REMOVED***

    public static WebResource.Builder mockWebBuilder(Kushki kushki, String url) throws NoSuchFieldException, IllegalAccessException, BadPaddingException, IllegalBlockSizeException {
        WebResource.Builder builder = TestsHelpers.mockClient(kushki, url);
        ClientResponse response = mock(ClientResponse.class);
        when(response.getEntity(JsonNode.class)).thenReturn(mock(JsonNode.class));
        when(builder.post(eq(ClientResponse.class), any(Map.class))).thenReturn(response);
        return builder;
***REMOVED***

    private static void injectMockClient(Kushki kushki, Client client) throws NoSuchFieldException, IllegalAccessException {
        Class<?> klass = kushki.getClass();
        Field ***REMOVED***eld = klass.getDeclaredField("client");
        ***REMOVED***eld.setAccessible(true);
        ***REMOVED***eld.set(kushki, client);
***REMOVED***

    public static Double getRandomDouble(Double min, Double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
***REMOVED***

    public static Integer getRandomInteger(Integer min, Integer max) {
        return nextInt(min, max + 1);
***REMOVED***

    public static Double getRandomAmount(boolean valid) {
        double[] validCents = {0.0, 0.08, 0.11, 0.59, 0.6***REMOVED***;
        double[] invalidCents = {0.05, 0.1, 0.21, 0.61, 0.62, 0.63***REMOVED***;

        double cents;
        if (valid) {
            int centPosition = nextInt(0, validCents.length - 1);
            cents = validCents[centPosition];
***REMOVED*** else {
            int centPosition = nextInt(0, invalidCents.length - 1);
            cents = invalidCents[centPosition];
***REMOVED***
        return nextInt(1, 9999) + cents;
***REMOVED***

    public static Double getRandomAmount() {
        return getRandomAmount(true);
***REMOVED***

    public static Integer getRandomMonths() {
        return nextInt(1, 13);
***REMOVED***

    public static Double getRandomInterest() {
        return getRandomDouble(0.01, 0.99);
***REMOVED***

    public static Map<String, String> getValidCardData() {
        Map<String, String> cardParams = new HashMap<>(5);
        cardParams.put("name", randomAlphabetic(20));
        cardParams.put("number", "4111111111111111");
        cardParams.put("expiry_month", "12");
        cardParams.put("expiry_year", "20");
        cardParams.put("cvv", "123");
        return cardParams;
***REMOVED***
***REMOVED***
