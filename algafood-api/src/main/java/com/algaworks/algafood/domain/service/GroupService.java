package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.Group;
import com.algaworks.algafood.domain.repository.GroupRepository;

@Service
public class GroupService {
	@Autowired
	private GroupRepository repository;

	public Group get(Long id) {
		Group group = repository.findById(id).orElse(null);

		if (group == null) {
			throw new EntityNotFoundPersonalException(String.format("Group [ %d ] not found", id));
		}
		return group;
	}

	public List<Group> getAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		Group group = get(id);
		repository.delete(group);
	}

	public Group save(Group group) {
		group = repository.save(group);
		return group;
	}
}