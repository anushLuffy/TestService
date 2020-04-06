/**
 * 
 */
package com.company.testService.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.testService.dto.ResponseEntity;
import com.company.testService.model.OrderItems;
import com.company.testService.model.Orders;
import com.company.testService.repository.OrderItemRepository;
import com.company.testService.repository.OrderRepository;

/**
 * @author anush
 *
 */
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;

	@Transactional
	public ResponseEntity<Orders> addOrder(int userId, @Valid Orders order) {
		ResponseEntity<Orders> response = new ResponseEntity<>();
		try {
			order.setUserId(userId);
			// update the total price 
			order.setTotal(getPrice(order));
			Orders res = orderRepository.save(order);
			response.setStatusCode(200);
			response.setResponse(res);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setErrorResponse("Error in creating order");
		}
		return response;
	}

	public ResponseEntity<List<Orders>> getAllOrders(int userId) {
		ResponseEntity<List<Orders>> response = new ResponseEntity<>();
		try {
			List<Orders> res = orderRepository.getOrders(userId);
			response.setStatusCode(200);
			response.setResponse(res);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setErrorResponse("Error in getting order");
		}
		return response;
	}

	public ResponseEntity<Orders> getAllOrdersById(int userId, @Valid int orderId) {
		ResponseEntity<Orders> response = new ResponseEntity<>();
		try {
			List<Orders> res = orderRepository.findOrderById(userId,orderId);
			response.setStatusCode(200);
			response.setResponse(res.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setErrorResponse("Error in getting order");
		}
		return response;
	}
	
	private double getPrice(Orders order) {
		double sum = 0f;
		if(order.getOrderItems()!=null) {
			for(OrderItems items :order.getOrderItems()) {
				sum += items.getPerPrice() * items.getQuantity() ;
				items.setPrice(items.getPerPrice() * items.getQuantity());
			}
		}
		return sum;
	}

	@Transactional
	public ResponseEntity<Orders> updateOrder(int userId, @Valid int orderId, @Valid OrderItems items) {
		ResponseEntity<Orders> response = new ResponseEntity<>();
		try {
			List<Orders> res = orderRepository.findOrderById(userId,orderId);
			Orders order = new Orders();
			BeanUtils.copyProperties(res.get(0),order);
			order.setUserId(userId);
			// update the total price 
			items.setOrder(order);
			items.setPrice(items.getPerPrice() * items.getQuantity());
			orderItemRepository.save(items);
			double sum = items.getPerPrice() * items.getQuantity() + order.getTotal();
			order.setTotal(sum);
			Orders resp = orderRepository.save(order);
			response.setStatusCode(200);
			response.setResponse(resp);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setErrorResponse("Error in creating order");
		}
		return response;
	}

}
