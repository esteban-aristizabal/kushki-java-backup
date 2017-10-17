package com.kushki.enums;

public enum KushkiTransaccionType {
    VOID("/charges/"),
    REFUND("/refund/"),
    CHARGE("/charges"),
    SUSCRIPTION("/subscriptions"),
    SUSCRIPTION_CARD("/card"),
    SUSCRIPTION_ADJUSTMENT("/adjustment");

    private String url;

    @Override
    public String toString(){
        return url;
***REMOVED***

    KushkiTransaccionType(String url) {
        this.url = url;
***REMOVED***

    public String getUrl() {
        return url;
***REMOVED***
***REMOVED***
