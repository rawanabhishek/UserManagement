/******************************************************************************
 
 *  Purpose: An interface class extending Jpa repository interface which can
 *           give service to use the implementation of JpaRepository .
 *  @author  Abhishek Rawat
 *  @version 1.0
 *  @since   17-12-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.usermanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByEmailAndUserName(String email , String userName);
}
