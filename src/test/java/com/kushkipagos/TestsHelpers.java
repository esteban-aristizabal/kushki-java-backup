package com.kushkipagos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Assert;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
***REMOVED***
import java.lang.reflect.Field;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextDouble;
import static org.hamcrest.CoreMatchers.is;
***REMOVED***
import static org.mockito.Matchers.any;
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

    public static WebResource.Builder mockClient(Kushki kushki) throws NoSuchFieldException, IllegalAccessException {
        Client client = mock(Client.class);
        injectMockClient(kushki, client);
        WebResource webResource = mock(WebResource.class);
        WebResource.Builder requestWithType = mock(WebResource.Builder.class);
        WebResource.Builder requestWithAccept = mock(WebResource.Builder.class);
        when(client.resource(Kushki.URL)).thenReturn(webResource);
        when(webResource.type(MediaType.APPLICATION_JSON_TYPE)).thenReturn(requestWithType);
        when(requestWithType.accept(MediaType.APPLICATION_JSON_TYPE)).thenReturn(requestWithAccept);
        return requestWithAccept;
***REMOVED***

    private static void injectMockClient(Kushki kushki, Client client) throws NoSuchFieldException, IllegalAccessException {
        Class<?> klass = kushki.getClass();
        Field ***REMOVED***eld = klass.getDeclaredField("client");
        ***REMOVED***eld.setAccessible(true);
        ***REMOVED***eld.set(kushki, client);
***REMOVED***

    public static Double getRandomAmount() {
        return Double.parseDouble(String.format("%.2f", nextDouble(1, 99)));
***REMOVED***

    public static void assertThatChargeThrowsExceptionWithInvalidAmount(Kushki kushki, Double amount, String exceptionMessage) {
        Exception exception = null;
***REMOVED***
            String token = randomAlphabetic(10);
            kushki.charge(token, amount);
***REMOVED*** catch (KushkiException | BadPaddingException | JsonProcessingException | IllegalBlockSizeException e) {
            exception = e;
***REMOVED***
        Assert.assertNotNull(exception);
        assertThat(exception.getMessage(), is(exceptionMessage));
***REMOVED***

***REMOVED***
