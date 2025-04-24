package com.cooksys.lemonadestand;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cooksys.lemonadestand.entities.Customer;
import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.entities.Order;
import com.cooksys.lemonadestand.repositories.CustomerRepository;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.repositories.LemonadeStandRepository;
import com.cooksys.lemonadestand.repositories.OrderRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

  private LemonadeRepository lemonadeRepository;
  private OrderRepository orderRepository;
  private CustomerRepository customerRepository;
  private LemonadeStandRepository lemonadeStandRepository;

  @Override
  public void run(String... args) throws Exception {
    Lemonade lemonade = new Lemonade();
    lemonade.setLemonJuice(3.25);
    lemonade.setWater(2.5);
    lemonade.setSugar(1.25);
    lemonade.setIceCubes(5);
    lemonade.setPrice(4.50);

    Order order = new Order();
    order.setTotal(4.50);
    
    Customer customer1 = new Customer();
    customer1.setName("Alec");
    customer1.setPhoneNumber("1234567890");
    customer1.setOrder(List.of(order));

    LemonadeStand lemonadeStand = new LemonadeStand();
    lemonadeStand.setName("Halie's Lemonades");
    lemonadeStand.setOrders(List.of(order));

    lemonadeRepository.saveAndFlush(lemonade);
    orderRepository.saveAndFlush(order);
    lemonadeStandRepository.saveAndFlush(lemonadeStand);
    customerRepository.saveAndFlush(customer1);

    // System.out.println(lemonadeRepository.findAll());
    // System.out.println(orderRepository.findAll());
    // System.out.println(customerRepository.findAll());
    // System.out.println(lemonadeStandRepository.findAll());
    System.out.println("Database seeded successfully!");
  }

}
