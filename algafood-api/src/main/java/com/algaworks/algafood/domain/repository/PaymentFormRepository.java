package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.PaymentForm;

public interface PaymentFormRepository {

	List<PaymentForm> getAll();
	
	PaymentForm get(Long id);
	
	PaymentForm save(PaymentForm paymentForm);
	
	void delete	(Long id);
	
	void delete(PaymentForm paymentForm);
}
