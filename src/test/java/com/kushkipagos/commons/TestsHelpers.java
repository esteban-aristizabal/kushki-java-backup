package com.kushkipagos.commons;

import com.kushkipagos.Amount;
import com.kushkipagos.Card;
import com.kushkipagos.Tax;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public ***REMOVED***nal class TestsHelpers {

    private TestsHelpers() {

***REMOVED***

    public static Double getRandomDouble(Double min, Double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
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

    private static Integer getRandomAmountIntegerColombia() {
        return 2000 + (int)(Math.random() * 15000000);
***REMOVED***

    public static Amount getRandomAmount() {
        // https://xkcd.com/221/
        return new Amount(1d, 1d, 1d, 1d);
***REMOVED***

    public static Amount getRandomAmountColombia() {
        // https://xkcd.com/221/
        return new Amount(1d, 1d, 1d, new Tax(1d,1d,1d,1d));
***REMOVED***

    public static Double getRandomDoubleAmount() {
        return getRandomAmount(true);
***REMOVED***

    public static Integer getRandomIntegerAmount() {
        return getRandomAmountIntegerColombia();
***REMOVED***

    public static Integer getRandomMonths() {
        int[] monthsDeferred = {3, 6, 9, 12***REMOVED***;
        int rnd = new Random().nextInt(monthsDeferred.length);
        return monthsDeferred[rnd];
***REMOVED***

    public static Integer getRandomMonthsColombia() {
        return 2 + (int)(Math.random() * 35);
***REMOVED***

    public static Card getValidCard() {
        return new Card(randomAlphabetic(20), "4242424242424242", "123", "12", "21");
***REMOVED***

    public static Card getValidCardColombia() {
        return new Card(randomAlphabetic(20), "4005580000050003", "130", "12", "18");
***REMOVED***
***REMOVED***
