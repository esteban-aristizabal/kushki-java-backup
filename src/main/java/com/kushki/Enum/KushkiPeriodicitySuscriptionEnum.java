package com.kushki.Enum;

public enum KushkiPeriodicitySuscriptionEnum {
    DAILY("daily"),
    WEEKLY("weekly"),
    BIWEEKLY("biweekly"),
    MONTLY("monthly"),
    QUATTERLY("quarterly"),
    HALFYEARLY("halfYearly"),
    YEARLY("yearly"),
    CUSTOM("custom");

    private String name;

    public String toString(){
        return name;
***REMOVED***

    KushkiPeriodicitySuscriptionEnum(String name) {
        this.name = name;
***REMOVED***

    public String getName() {
        return name;
***REMOVED***
***REMOVED***
