/**
 * 
 */
package com.company.testService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.testService.model.OrderItems;

/**
 * @author anush
 *
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Long>{

}
