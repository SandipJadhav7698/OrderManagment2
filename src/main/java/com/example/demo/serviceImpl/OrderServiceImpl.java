package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderRepository;
import com.example.demo.dto.Orderdto;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
@Autowired
OrderRepository orderRepository;

@Override
public ResponseEntity<String> save(Orderdto orderdto) {
	Order order=new Order();
	order.setUserId(orderdto.getUserId());
	order.setProductName(orderdto.getProductName());
	order.setQuantity(orderdto.getQuantity());
	order.setPrice(orderdto.getPrice());
	orderRepository.save(order);
	
	 return new ResponseEntity<>("Order Placed Sucessfully....",HttpStatus.OK);
}

@Override
public Optional<Order> getById(Long orderId) {
	return orderRepository.findById(orderId);
}

@Override
public ResponseEntity<String> deleteById(Long orderId) {
	orderRepository.deleteById(orderId);
	return new ResponseEntity<>("Order Canceled Sucessfully",HttpStatus.OK);
}

@Override
public ResponseEntity<String> updatedata(Long orderId, Orderdto orderdto) {
	ResponseEntity<String> msg=new ResponseEntity<>(" ",HttpStatus.OK);
	Optional<Order> user=orderRepository.findById(orderId);
	if(user.isPresent()) {
		Order order=orderRepository.getById(orderId);
		order.setProductName(orderdto.getProductName());
		order.setQuantity(orderdto.getQuantity());
		order.setPrice(orderdto.getPrice());
		orderRepository.save(order);
		msg=new ResponseEntity<>("order Updated Sucessfully... ",HttpStatus.OK);
		
	}else {
		
		msg=new ResponseEntity<>("Order Not Present... ",HttpStatus.OK);	
	}
	return msg;
}


}
