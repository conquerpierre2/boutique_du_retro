package com.boutiqueduretro.boutiqueduretro.services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.boutiqueduretro.boutiqueduretro.dto.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${stripe_secret_key}")
    private String secretKey;
    
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    public Charge charge(ChargeRequest chargeRequest) 
      throws AuthenticationException, InvalidRequestException,
        APIConnectionException, CardException, APIException {
        System.out.println("api key : " +  Stripe.apiKey);
        Map<String, Object> chargeParams = new HashMap<>();
        System.out.println("amount :" + chargeRequest.getAmount());
        System.out.println("currency : " + chargeRequest.getCurrency());
        System.out.println("description : " + chargeRequest.getDescription());
        System.out.println("source : " + chargeRequest.getStripeToken());
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
    
}
