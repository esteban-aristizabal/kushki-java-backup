package com.kushki.TO;

import com.kushki.Enum.KushkiPeriodicitySuscriptionEnum;

import java.util.Date;

public class SuscriptionInfo {
    private String planName;
    private KushkiPeriodicitySuscriptionEnum periodicity;
    private Date startDate;
    private com.kushki.TO.ContactDetail contactDetail;


    public SuscriptionInfo(String planName, KushkiPeriodicitySuscriptionEnum periodicity, Date startDate, ContactDetail contactDetail) {
        this.planName = planName;
        this.periodicity = periodicity;
        this.startDate = startDate;
        this.contactDetail = contactDetail;
***REMOVED***

    public KushkiPeriodicitySuscriptionEnum getPeriodicity() {
        return periodicity;
***REMOVED***

    public void setPeriodicity(KushkiPeriodicitySuscriptionEnum periodicity) {
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