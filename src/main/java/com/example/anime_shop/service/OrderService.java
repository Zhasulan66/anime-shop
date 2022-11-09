package com.example.anime_shop.service;

import com.example.anime_shop.model.Category;
import com.example.anime_shop.model.Order;
import com.example.anime_shop.repository.CategoryRepository;
import com.example.anime_shop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrderById(int id){
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrderById(int id){
        orderRepository.deleteById(id);
    }
}
