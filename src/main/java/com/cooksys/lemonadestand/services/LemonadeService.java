package com.cooksys.lemonadestand.services;

import java.util.List;

import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;

public interface LemonadeService {

  List<LemonadeResponseDto> getAllLemonades();

  LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto);

  LemonadeResponseDto getLemonadeById(Long id);

  LemonadeResponseDto updateLemonade(Long id, LemonadeRequestDto lemonadeRequestDto);

  LemonadeResponseDto deleteLemonade(Long id);
}
