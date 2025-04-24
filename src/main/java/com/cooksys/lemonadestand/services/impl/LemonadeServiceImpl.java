package com.cooksys.lemonadestand.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.mappers.LemonadeMapper;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LemonadeServiceImpl implements LemonadeService {

  private LemonadeRepository lemonadeRepository;
  private LemonadeMapper lemonadeMapper;

  @Override
  public List<LemonadeResponseDto> getAllLemonades() {
    return lemonadeMapper.entityToResponseDto(lemonadeRepository.findAll());
  }

  @Override
  public LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto) {
    // Map request dto to a lemonade entity
    Lemonade lemonadeToSave = lemonadeMapper.requestDtoEntity(lemonadeRequestDto);
    lemonadeToSave.setPrice(lemonadeToSave.getLemonJuice() * .20 + lemonadeToSave.getWater() * .01 + lemonadeToSave.getSugar() * .15 + lemonadeToSave.getIceCubes() * .05 + .50);
    
    // Save the new lemonade entity
    // Map newly saved entity with the generated id to a response dto and return it
    return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToSave));
  }
}
