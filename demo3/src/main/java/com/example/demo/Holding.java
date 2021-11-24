
  package com.example.demo;
  
  import java.math.BigDecimal;
/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;
*/  
  //@Entity
  //@Transactional
  //@Table(name="holdings") 
  public class Holding {
  
  //@Id
  private long holdingId;
  
  //@Column(name = "Name") 
  private String holdingName;
  
  //@Column(name = "Balance") 
  private BigDecimal balance;
  
  //@Column(name = "Type") 
  private String holdingType;
  
  //@Column(name = "Quantity") 
  private long quantity;
  
  public long getHoldingId() { return holdingId; }
  
  public void setHoldingId(long holdingId) { this.holdingId = holdingId; }
  
  public String getHoldingName() { return holdingName; }
  
  public void setHoldingName(String holdingName) { this.holdingName =
  holdingName; }
  
  public BigDecimal getBalance() { return balance; }
  
  public void setBalance(BigDecimal balance) { this.balance = balance; }
  
  public String getHoldingType() { return holdingType; }
  
  public void setHoldingType(String holdingType) { this.holdingType =
  holdingType; }
  
  public long getQuantity() { return quantity; }
  
  public void setQuantity(long quantity) { this.quantity = quantity; }
  
  
  }
 