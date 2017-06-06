package com.smartparking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartparking.domain.Car;
import com.smartparking.domain.User;

@Repository
public interface UserRepository extends SmartParkingRepository<User>{

	@Query("SELECT u FROM User u WHERE UPPER(u.login) = ?1 AND active = TRUE")
	User findByLogin(String login);

	@Query("SELECT u FROM User u WHERE UPPER(u.login) = ?1 AND u.password = ?2 AND active = TRUE")
	User findByLoginAndPassword(String login, String password);

	@Query("SELECT u FROM User u JOIN u.cars c WHERE c = ?1 AND u.active = TRUE")
	User findUserByCar(Car car);

}
