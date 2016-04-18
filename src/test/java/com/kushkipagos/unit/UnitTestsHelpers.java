package com.kushkipagos.unit;

import com.fasterxml.jackson.databind.JsonNode;
import com.kushkipagos.AurusEncryption;
import com.kushkipagos.Kushki;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
***REMOVED***
***REMOVED***
import java.lang.reflect.Field;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lmunda on 2/16/16 14:55.
 */
public ***REMOVED***nal class UnitTestsHelpers {
    private UnitTestsHelpers() {

***REMOVED***

    public static Invocation.Builder mockInvocationBuilder(Kushki kushki, String baseUrl, String url) throws NoSuchFieldException, IllegalAccessException {
        Invocation.Builder builder = mockClient(kushki, baseUrl, url);
        Response response = mock(Response.class);
        when(response.readEntity(JsonNode.class)).thenReturn(mock(JsonNode.class));
        when(builder.post(any(Entity.class))).thenReturn(response);

        return builder;
***REMOVED***

    public static Invocation.Builder mockClient(Kushki kushki, String baseUrl, String url) throws NoSuchFieldException, IllegalAccessException {
        Client client = mock(Client.class);
        injectMockClient(kushki, client);
        WebTarget webTarget = mock(WebTarget.class);
        WebTarget webTargetPath = mock(WebTarget.class);
        Invocation.Builder invocationBuilder = mock(Invocation.Builder.class);
        when(client.target(baseUrl)).thenReturn(webTarget);
        when(webTarget.path(url)).thenReturn(webTargetPath);
        when(webTargetPath.request(MediaType.APPLICATION_JSON_TYPE)).thenReturn(invocationBuilder);

        return invocationBuilder;
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

    private static void injectMockClient(Kushki kushki, Client client) throws NoSuchFieldException, IllegalAccessException {
        Class<?> klass = kushki.getClass();
        Field ***REMOVED***eld = klass.getDeclaredField("client");
        ***REMOVED***eld.setAccessible(true);
        ***REMOVED***eld.set(kushki, client);
***REMOVED***
***REMOVED***
