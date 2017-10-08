package com.kushki;

import java.util.Locale;

public ***REMOVED***nal class Validations {

    private Validations() {
***REMOVED***

    static String validateMonths(Integer months) throws KushkiException {
        return Validations.validateNumber(months, 0, 2, "El número de meses");
***REMOVED***

    public static String validateNumber(Number amount, Integer minValue, Integer maxLength, String amountName) throws KushkiException {
        if (amount == null) {
            throw new KushkiException(amountName + " no puede ser un valor nulo");
***REMOVED***
        if (amount.doubleValue() < minValue) {
            throw new KushkiException(amountName + " debe ser superior o igual a " + minValue);
***REMOVED***
        String validAmount = getStringValue(amount);
        if (validAmount.length() > maxLength) {
            throw new KushkiException(amountName + " debe tener " + maxLength + " o menos dígitos");
***REMOVED***
        return validAmount;
***REMOVED***

    private static String getStringValue(Number amount) {
        if (amount instanceof Double) {
            return String.format(Locale.ENGLISH, "%.2f", amount);
***REMOVED*** else if (amount instanceof Integer) {
            return String.valueOf(amount);
***REMOVED***
        return "";
***REMOVED***


***REMOVED***
