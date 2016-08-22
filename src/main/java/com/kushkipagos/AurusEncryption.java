package com.kushkipagos;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * sent by: Ashish Mandloi (amandloi@aurusinc.com)
 */
public class AurusEncryption {

    private ***REMOVED***nal Cipher cipher;

    AurusEncryption() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        String publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC81t5iu5C0JxYq5/XNPiD5ol3Zw8rw3LtFIUm7y3m8o8wv5qVnzGh6XwQ8LWypdkbBDKWZZrAUd3lybZOP7/82Nb1/noYj8ixVRdbnYtbsSAbu9PxjB7a/7LCGKsugLkou74PJDadQweM88kzQOx/kzAyVbS9gCCVUguHcq2vRRQIDAQAB";
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, loadPublicKey(publickey));
***REMOVED***

    public String encryptMessageChunk(String requestMessage) throws BadPaddingException, IllegalBlockSizeException {
        byte[] cipherData;
        String chnkString;
        String[] msgChunks = requestMessage.split("(?<=\\G.{117***REMOVED***)");
        StringBuilder buf = new StringBuilder();
        for (String msgChunk : msgChunks) {
            cipherData = encrypt(msgChunk);
            chnkString = DatatypeConverter.printBase64Binary(cipherData);
            chnkString = chnkString.replace("\n", "");
            buf.append(chnkString);
            buf.append("<FS>");
***REMOVED***
        return buf.toString();
***REMOVED***

    private byte[] encrypt(String message) throws BadPaddingException, IllegalBlockSizeException {
        byte[] eMessageBytes = message.getBytes(Charset.forName("UTF-8"));       // Request message conversion to Byte array
        return cipher.doFinal(eMessageBytes);
***REMOVED***

    private PublicKey loadPublicKey(String stored) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] data = DatatypeConverter.parseBase64Binary(stored);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);
***REMOVED***
***REMOVED***
