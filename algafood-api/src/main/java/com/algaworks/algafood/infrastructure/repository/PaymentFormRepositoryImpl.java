/*
 * package com.algaworks.algafood.infrastructure.repository;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.PersistenceContext; import javax.transaction.Transactional;
 * 
 * import org.springframework.stereotype.Component;
 * 
 * import com.algaworks.algafood.domain.model.PaymentForm; import
 * com.algaworks.algafood.domain.repository.PaymentFormRepository;
 * 
 * @Component public class PaymentFormRepositoryImpl implements
 * PaymentFormRepository{
 * 
 * @PersistenceContext private EntityManager manager;
 * 
 * @Override public List<PaymentForm> getAll(){ return
 * manager.createQuery("from PaymentForm", PaymentForm.class).getResultList(); }
 * 
 * @Override
 * 
 * @Transactional public PaymentForm save(PaymentForm paymentForm) { return
 * manager.merge(paymentForm); }
 * 
 * @Override public PaymentForm get(Long id) { return
 * manager.find(PaymentForm.class, id); }
 * 
 * @Override
 * 
 * @Transactional public void delete(Long id) {
 * manager.remove(manager.find(PaymentForm.class, id)); }
 * 
 * @Override
 * 
 * @Transactional public void delete(PaymentForm paymentForm) {
 * manager.remove(paymentForm); }
 * 
 * }
 */