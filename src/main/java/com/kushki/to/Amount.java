package com.kushki.to;

import com.kushki.KushkiException;
import com.kushki.Validations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amount {
    private Double subtotalIVA;
    private Double iva;
    private Double subtotalIVA0;
    private Double ice = 0d;
    private ExtraTaxes extraTaxes = new ExtraTaxes(0d, 0d, 0d, 0d);

    public Amount(Double subtotalIVA, Double iva, Double subtotalIVA0, Double ice) {
        this.subtotalIVA = subtotalIVA;
        this.iva = iva;
        this.subtotalIVA0 = subtotalIVA0;
        this.ice = ice;
***REMOVED***


    public Double getTotalAmount() {
        return subtotalIVA + subtotalIVA0 + iva + ice + extraTaxes.getTotalExtraTaxes();
***REMOVED***

    public Map<String, Object> toHash() throws KushkiException {
        String validatedSubtotalIVA = Validations.validateNumber(subtotalIVA, 0, 12, "El subtotal IVA");
        String validatedSubtotalIVA0 = Validations.validateNumber(subtotalIVA0, 0, 12, "El subtotal IVA 0");
        String validatedIva = Validations.validateNumber(iva, 0, 12, "El IVA");
        String validatedIce = Validations.validateNumber(ice, 0, 12, "El ICE");
        String validatedTotal = Validations.validateNumber(getTotalAmount(), 0, 12, "El total");
        List<Map<String, String>> extraTaxes = this.extraTaxes.toHashArray();
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("Subtotal_IVA", validatedSubtotalIVA);
        hashMap.put("Subtotal_IVA0", validatedSubtotalIVA0);
        hashMap.put("IVA", validatedIva);
        if (ice > 0) hashMap.put("ICE", validatedIce);
        if (extraTaxes.size() > 0) hashMap.put("tax", extraTaxes);
        hashMap.put("Total_amount", validatedTotal);
        return hashMap;
***REMOVED***

    public Double getSubtotalIVA() {
        return subtotalIVA;
***REMOVED***

    public void setSubtotalIVA(Double subtotalIVA) {
        this.subtotalIVA = subtotalIVA;
***REMOVED***

    public Double getIva() {
        return iva;
***REMOVED***

    public void setIva(Double iva) {
        this.iva = iva;
***REMOVED***

    public Double getSubtotalIVA0() {
        return subtotalIVA0;
***REMOVED***

    public void setSubtotalIVA0(Double subtotalIVA0) {
        this.subtotalIVA0 = subtotalIVA0;
***REMOVED***

    public Double getIce() {
        return ice;
***REMOVED***

    public void setIce(Double ice) {
        this.ice = ice;
***REMOVED***

    public ExtraTaxes getExtraTaxes() {
        return extraTaxes;
***REMOVED***

    public void setExtraTaxes(ExtraTaxes extraTaxes) {
        this.extraTaxes = extraTaxes;
***REMOVED***


***REMOVED***
