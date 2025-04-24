package com.cooksys.lemonadestand.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = 893754982634726468L;

  private String message;
}
