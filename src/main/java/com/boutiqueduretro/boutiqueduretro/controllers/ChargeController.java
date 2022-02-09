package com.boutiqueduretro.boutiqueduretro.controllers;

import com.boutiqueduretro.boutiqueduretro.dto.ChargeRequest;
import com.boutiqueduretro.boutiqueduretro.dto.ChargeRequest.Currency;
import com.boutiqueduretro.boutiqueduretro.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ChargeController {
    @Autowired
    private StripeService paymentsService;

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
      throws StripeException { 
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.EUR);
        System.out.println( "amount charge " + chargeRequest.getAmount());
        System.out.println( "stripeToken charge " + chargeRequest.getStripeToken());
        System.out.println("stripeEmail charge " + chargeRequest.getStripeEmail());
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
       
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
    
}
