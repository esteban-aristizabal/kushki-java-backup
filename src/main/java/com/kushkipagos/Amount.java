package com.kushkipagos;

import java.util.HashMap;
import java.util.Map;

public class Amount {
    private Double subtotalIVA;
    private Double iva;
    private Double subtotalIVA0;
    private Double ice = 0d;
    private Tax tax = new Tax(0d, 0d, 0d, 0d);

    public Amount(Double subtotalIVA, Double iva, Double subtotalIVA0, Double ice) {
        this.subtotalIVA = subtotalIVA;
        this.iva = iva;
        this.subtotalIVA0 = subtotalIVA0;
        this.ice = ice;
***REMOVED***

    public Amount(Double subtotalIVA, Double iva, Double subtotalIVA0, Tax tax) {
        this.subtotalIVA = subtotalIVA;
        this.iva = iva;
        this.subtotalIVA0 = subtotalIVA0;
        this.tax = tax;
***REMOVED***

    public Double getTotalAmount() {
        return subtotalIVA + subtotalIVA0 + iva + ice + tax.getTotalTax();
***REMOVED***

    public Map<String, String> toHash() throws KushkiException {
        String validatedSubtotalIVA = Validations.validateNumber(subtotalIVA, 0, 12, "El subtotal IVA");
        String validatedSubtotalIVA0 = Validations.validateNumber(subtotalIVA0, 0, 12, "El subtotal IVA 0");
        String validatedIva = Validations.validateNumber(iva, 0, 12, "El IVA");
        String validatedIce = Validations.validateNumber(ice, 0, 12, "El ICE");
        String validatedTax = Validations.validateNumber(tax.getTotalTax(), 0, 12, "El impuesto");
        String validatedTotal = Validations.validateNumber(getTotalAmount(), 0, 12, "El total");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Subtotal_IVA", validatedSubtotalIVA);
        hashMap.put("Subtotal_IVA0", validatedSubtotalIVA0);
        hashMap.put("IVA", validatedIva);
        hashMap.put("ICE", validatedIce);
        hashMap.put("TAX", validatedTax);
        hashMap.put("Total_amount", validatedTotal);
        return hashMap;
***REMOVED***
***REMOVED***
