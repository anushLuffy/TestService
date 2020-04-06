/**
 * 
 */
package com.company.testService.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.testService.model.Orders;

/**
 * @author anush
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

	List<Orders> getOrders(int userId);

	List<Orders> findOrderById(int userId, @Valid int orderId);

}
