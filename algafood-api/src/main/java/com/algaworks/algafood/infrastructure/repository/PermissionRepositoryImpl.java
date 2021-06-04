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
 * import com.algaworks.algafood.domain.model.Permission; import
 * com.algaworks.algafood.domain.repository.PermissionRepository;
 * 
 * @Component public class PermissionRepositoryImpl implements
 * PermissionRepository{
 * 
 * @PersistenceContext private EntityManager manager;
 * 
 * @Override public List<Permission> getAll(){ return
 * manager.createQuery("from Permission", Permission.class).getResultList(); }
 * 
 * @Override
 * 
 * @Transactional public Permission save(Permission permission) { return
 * manager.merge(permission); }
 * 
 * @Override public Permission get(Long id) { return
 * manager.find(Permission.class, id); }
 * 
 * @Override
 * 
 * @Transactional public void delete(Long id) {
 * manager.remove(manager.find(Permission.class, id)); }
 * 
 * @Override
 * 
 * @Transactional public void delete(Permission permission) {
 * manager.remove(permission); }
 * 
 * }
 */