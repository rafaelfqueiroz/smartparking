package com.smartparking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartparking.domain.CarParking;
import com.smartparking.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByLogin(String login);

	User findByLoginAndPassword(String login, String password);

	@Query("SELECT u FROM User u JOIN u.cars c WHERE c = :car")
	User findUserByCar(CarParking car);

}
