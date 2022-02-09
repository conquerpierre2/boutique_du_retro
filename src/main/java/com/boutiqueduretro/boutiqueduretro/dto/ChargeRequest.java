package com.boutiqueduretro.boutiqueduretro.dto;

import lombok.Data;

@Data
public class ChargeRequest {
    public enum Currency {
        EUR, USD;
    }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;

    

    public String getStripeEmail() {
        return stripeEmail;
    }

    public int getAmount() {
        return amount;
    }


    public Object getCurrency() {
        return currency;
    }


    public Object getDescription() {
        return description;
    }


    public Object getStripeToken() {
        return stripeToken;
    }


    public void setDescription(String description) {

        this.description = description;
    }


    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setAmount(int amount ) {
        this.amount  = amount;
    }
}
