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

import com.bridgelabz.usermanagement.entity.LoginHistory;
import com.bridgelabz.usermanagement.entity.User;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer>{
	Optional<LoginHistory> findByUser(User user);
}
