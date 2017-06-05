package com.smartparking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.smartparking.domain.Feed;

@NoRepositoryBean
public interface SmartParkingRepository<T extends Feed> extends CrudRepository<T, Integer>{

	T findByIdAndActiveTrue(Integer idEntity);
	
	List<T> findAllByActiveTrue();
	
}
