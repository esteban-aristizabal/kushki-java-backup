package com.kushkipagos;

public enum KushkiEnvironment {
    TESTING("https://uat.aurusinc.com/kushki/api/v1"),
    STAGING("https://staging.aurusinc.com/kushki/api/v1"),
    PRODUCTION("https://p1.kushkipagos.com/kushki/api/v1");

    private String url;

    KushkiEnvironment(String url) {
        this.url = url;
***REMOVED***

    public String getUrl() {
        return url;
***REMOVED***
***REMOVED***
