package com.example.demo.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.Orderdto;
import com.example.demo.model.Order;

public interface OrderService {

	ResponseEntity<String> save(Orderdto orderdto);

	Optional<Order> getById(Long orderId);

	ResponseEntity<String> deleteById(Long orderId);

	ResponseEntity<String> updatedata(Long orderId, Orderdto orderdto);

}
