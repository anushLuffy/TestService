package com.company.testService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author anush
 *
 */
@Entity
@Table(name = "ORDERS")
@NamedQuery(name = "Orders.getOrders",query = "SELECT o FROM Orders o WHERE o.userId = :userId")
@NamedQuery(name = "Orders.findOrderById",query = "SELECT o FROM Orders o WHERE o.userId = :userId and o.id = :orderId")
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2902593048608133676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "ORDER_NUMBER")
	private String orderNumber;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;
	
	@Column(name = "TOTAL")
	private double total;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "CREATED_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTs;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "UPDATED_TS" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTs;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Set<OrderItems> orderItems = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
