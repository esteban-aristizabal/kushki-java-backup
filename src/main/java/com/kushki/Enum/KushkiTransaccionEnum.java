package com.kushki.Enum;

public enum KushkiTransaccionEnum {
    VOID("/charges/"),
    REFUND("/refund/"),
    CHARGE("/charges"),
    SUSCRIPTION("/subscriptions"),
    SUSCRIPTION_CARD("/card"),
    SUSCRIPTION_ADJUSTMENT("/adjustment");

    private String url;

    public String toString(){
        return url;
***REMOVED***

    KushkiTransaccionEnum(String url) {
        this.url = url;
***REMOVED***

    public String getUrl() {
        return url;
***REMOVED***
***REMOVED***
