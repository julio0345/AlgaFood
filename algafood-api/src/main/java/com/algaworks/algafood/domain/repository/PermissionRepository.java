package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permission;

public interface PermissionRepository {

	List<Permission> getAll();
	
	Permission get(Long id);
	
	Permission save(Permission permission);
	
	void delete	(Long id);
	
	void delete(Permission permission);
}