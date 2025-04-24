package com.cooksys.lemonadestand.services.impl;

import java.util.List;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
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

  private void setLemonadePrice(Lemonade lemonade) {
    lemonade.setPrice(lemonade.getLemonJuice() * .20 + lemonade.getWater() * .01
        + lemonade.getSugar() * .15 + lemonade.getIceCubes() * .05 + .50);
  }

  private void validateLemonadeRequest(LemonadeRequestDto lemonadeRequestDto) {
    if (lemonadeRequestDto.getLemonJuice() == null || lemonadeRequestDto.getWater() == null
        || lemonadeRequestDto.getSugar() == null || lemonadeRequestDto.getIceCubes() == null) {
      throw new BadRequestException("All fields are required on a Lemonade request dto.");
    }
  }

  private Lemonade getLemonade(Long id) {
    Optional<Lemonade> optionalLemonade = lemonadeRepository.findById(id);
    if (optionalLemonade.isEmpty()) {
      throw new NotFoundException("No Lemonade found with id: " + id + ".");
    }

    return optionalLemonade.get();
  }

  @Override
  public LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto) {
    // Map request dto to a lemonade entity
    validateLemonadeRequest(lemonadeRequestDto);
    Lemonade lemonadeToSave = lemonadeMapper.requestDtoEntity(lemonadeRequestDto);
    setLemonadePrice(lemonadeToSave);

    // Save the new lemonade entity
    // Map newly saved entity with the generated id to a response dto and return it
    return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToSave));
  }

  @Override
  public LemonadeResponseDto getLemonadeById(Long id) {
    return lemonadeMapper.entityToResponseDto(getLemonade(id));
  }

  @Override
  public LemonadeResponseDto updateLemonade(Long id, LemonadeRequestDto lemonadeRequestDto) {
    validateLemonadeRequest(lemonadeRequestDto);

    // Lemonade lemonadeToUpdate = lemonadeMapper.requestDtoEntity(lemonadeRequestDto);
    Lemonade lemonadeToUpdate = getLemonade(id);
    lemonadeToUpdate.setIceCubes(lemonadeRequestDto.getIceCubes());
    lemonadeToUpdate.setWater(lemonadeRequestDto.getWater());
    lemonadeToUpdate.setSugar(lemonadeRequestDto.getSugar());
    lemonadeToUpdate.setLemonJuice(lemonadeRequestDto.getLemonJuice());
    setLemonadePrice(lemonadeToUpdate);

    return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToUpdate));
  }

  @Override
  public LemonadeResponseDto deleteLemonade(Long id) {
    Lemonade lemonadeToDelete = getLemonade(id);
    lemonadeRepository.delete(lemonadeToDelete);
    return lemonadeMapper.entityToResponseDto(lemonadeToDelete);
  }
}
