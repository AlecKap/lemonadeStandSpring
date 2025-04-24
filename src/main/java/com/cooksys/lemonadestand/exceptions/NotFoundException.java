package com.cooksys.lemonadestand.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NotFoundException extends RuntimeException{
    /**
   * 
   */
  private static final long serialVersionUID = 34536768754634143L;

  private String message;
}
