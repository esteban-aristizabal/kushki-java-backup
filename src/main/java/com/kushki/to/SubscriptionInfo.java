package com.kushki.to;

import com.kushki.enums.KushkiPeriodicitySubscriptionType;

import java.util.Date;

public class SubscriptionInfo {
    private String planName;
    private KushkiPeriodicitySubscriptionType periodicity;
    private Date startDate;
    private com.kushki.to.ContactDetail contactDetail;


    public SubscriptionInfo(String planName, KushkiPeriodicitySubscriptionType periodicity, Date startDate, ContactDetail contactDetail) {
        this.planName = planName;
        this.periodicity = periodicity;
        this.startDate = startDate;
        this.contactDetail = contactDetail;
***REMOVED***

    public KushkiPeriodicitySubscriptionType getPeriodicity() {
        return periodicity;
***REMOVED***

    public void setPeriodicity(KushkiPeriodicitySubscriptionType periodicity) {
        this.periodicity = periodicity;
***REMOVED***

    public String getPlanName() {
        return planName;
***REMOVED***

    public void setPlanName(String planName) {
        this.planName = planName;
***REMOVED***

    public Date getStartDate() {
        return startDate;
***REMOVED***

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
***REMOVED***

    public ContactDetail getContactDetail() {
        return contactDetail;
***REMOVED***

    public void setContactDetail(ContactDetail contactDetail) {
        this.contactDetail = contactDetail;
***REMOVED***
***REMOVED***