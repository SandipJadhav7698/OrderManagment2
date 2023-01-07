package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Orderdto;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
 @Autowired 
 OrderService orderService;
 
 @PostMapping("/placeorder")
 public ResponseEntity<String> save(@RequestBody Orderdto orderdto){
	 return orderService.save(orderdto);
 }
 
 @GetMapping("/findById/{orderId}")
	public Optional<Order> getbyId(@PathVariable("orderId")Long orderId){
		return orderService.getById(orderId);
	}
 
 @PutMapping("/update/{orderId}")
 public ResponseEntity<String> updateData(@PathVariable ("orderId")Long orderId,@RequestBody Orderdto orderdto){
 		return orderService.updatedata(orderId,orderdto);
 	}
 
 @DeleteMapping("/deleteByid/{orderId}")
 public ResponseEntity<String> deleteUser(@PathVariable ("orderId")Long orderId){
 		return orderService.deleteById(orderId);
 	}
 
}
