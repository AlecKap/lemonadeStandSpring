package com.cooksys.lemonadestand.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Lemonade {
  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private double lemonJuice;

  @Column(nullable = false)
  private double water;

  @Column(nullable = false)
  private double sugar;

  @Column(nullable = false)
  private int iceCubes;

  @Column(nullable = false)
  private double price;
}
