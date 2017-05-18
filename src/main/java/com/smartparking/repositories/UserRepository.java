package com.smartparking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartparking.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByLogin(String login);

}
