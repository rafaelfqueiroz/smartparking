package com.smartparking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.smartparking.domain.Feed;
import com.smartparking.repositories.SmartParkingRepository;

public abstract class CrudService<T extends Feed> {

	@Autowired
	public SmartParkingRepository<T> repository;
	
	/**
	 * Get the entity of type T, which id matches with @param{idEntity}.
	 * @param idEntity
	 * @return
	 */
	public T get(Integer idEntity) {
		if (idEntity == null) {
			return null;
		}
		return repository.findByIdAndActiveTrue(idEntity);
	}
	
	/**
	 * Get all entities of type T.
	 * @return
	 */
	public List<T> getAll() {
		return repository.findAllByActiveTrue();
	}

	/**
	 * Save the entity of type T.
	 * @param entity
	 * @return
	 */
	public T save(T entity) {
		entity.setActive(true);
		return repository.save(entity);
	}
	
	/*
	 * Update the entity with the changes
	 */
	public T update(T entity) {
		return repository.save(entity);
	}

	/**
	 * Update the active param of entity to false
	 * @param entity
	 */
	public void remove(T entity) {
		entity.setActive(false);
		update(entity);
	}

}
