package com.boutiqueduretro.boutiqueduretro.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_SHOP")
public class UserShop {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name="first_name")
 private String firstName;

 @Column(name="last_name")
 private String lastName;

 @Column(name="email", nullable=false, length=200)
 private String email;

 @Column(name="amount_money")
 private int amountMoney;


public Long getId() {
    return id;
}

public void setId(Long id) {
     this.id = id;
}


 public String getFirstName() {
     return this.firstName;
 }

 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 public String getLastName() {
     return this.lastName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 public String getEmail() {
     return this.email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public int getAmountMoney() {
     return this.amountMoney;
 }

 public void setAmountMoney(int amountMoney) {
     this.amountMoney = amountMoney;
 }

 

}
