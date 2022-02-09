package com.boutiqueduretro.boutiqueduretro.controllers;

import com.boutiqueduretro.boutiqueduretro.dto.ChargeRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class CheckoutController {

   @Value("${stripe_public_key}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        System.out.println(stripePublicKey +  " public key");
        model.addAttribute("amount", 1 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
    
}
