package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String name;
	
	@Column(name = "price_delivery", nullable = false)
	private BigDecimal priceDelivery;
	
	@ManyToOne
	@JoinColumn(name = "kitchen_id")
	private Kitchen kitchen;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "restaurant_payment_form", 
			   joinColumns = @JoinColumn(name = "restaurant_id"),
			   inverseJoinColumns = @JoinColumn(name = "payment_form_id"))
	private List<PaymentForm> listPaymentForm = new ArrayList<PaymentForm>();
}