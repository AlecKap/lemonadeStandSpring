package com.cooksys.lemonadestand.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Order {
  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private double total;
}
