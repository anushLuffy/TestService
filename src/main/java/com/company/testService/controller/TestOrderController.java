/**
 * 
 */
package com.company.testService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.testService.dto.ResponseEntity;
import com.company.testService.model.OrderItems;
import com.company.testService.model.Orders;
import com.company.testService.service.OrderService;

/**
 * @author anush
 *
 */
@RestController
@RequestMapping("/orderservice")
public class TestOrderController {

	@Autowired
	OrderService orderService;
	 
	 @PostMapping("/addOrder")
	 public ResponseEntity<Orders> addOrder( @RequestHeader(value="userId") int userId  ,
			 @Valid @RequestBody Orders order) {
		 return orderService.addOrder(userId, order);
	 }
	 
	 @PutMapping("/updateOrder")
	 public ResponseEntity<Orders> updateOrder( @RequestHeader(value="userId") int userId  ,@Valid @RequestParam int orderId,
			 @Valid @RequestBody OrderItems items) {
		 return orderService.updateOrder(userId, orderId, items);
	 }
	 
	 
	 @GetMapping("/getOrder")
	 public ResponseEntity<List<Orders>> getOrdersList(@RequestHeader(value="userId") int userId) {
		 	return orderService.getAllOrders(userId);
		 	
	 }
	 
	 @GetMapping("/getOrderById")
	 public ResponseEntity<Orders> getOrdersList(@RequestHeader(value="userId") int userId  , @Valid @RequestParam int orderId) {
		 	return orderService.getAllOrdersById(userId , orderId);
		 	
	 }

}
