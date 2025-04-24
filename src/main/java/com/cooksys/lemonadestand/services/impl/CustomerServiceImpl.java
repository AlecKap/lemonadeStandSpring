package com.cooksys.lemonadestand.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
import com.cooksys.lemonadestand.mappers.CustomerMapper;
import com.cooksys.lemonadestand.model.CustomerRequestDto;
import com.cooksys.lemonadestand.model.CustomerResponseDto;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.repositories.CustomerRepository;
import com.cooksys.lemonadestand.services.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private CustomerMapper customerMapper;

  private void validateCustomerRequest(CustomerRequestDto customerRequestDto) {
    if (customerRequestDto.getName() == null || customerRequestDto.getPhoneNumber() == null) {
      throw new BadRequestException("All fields are required on a customer request dto.");
    }
  }

  private Customer getCustomer(Long id) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);
    if (optionalCustomer.isEmpty()) {
      throw new NotFoundException("No customer found with id: " + id + ".");
    }

    return optionalLemonade.get();
  }

  @Override
  public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
    return null;
  }

  @Override
  public List<CustomerResponseDto> getAllCustomers() {
    return null;
  }

  @Override
  public CustomerResponseDto getCustomerById(Long id) {
    return null;
  }

  @Override
  public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto customerRequestDto) {
    return null;
  }

  @Override
  public CustomerResponseDto deleteCustomer(Long id) {
    return null;
  }

}
