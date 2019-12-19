/******************************************************************************
 
 *  Purpose: An interface class extending Jpa repository interface which can
 *           give service to use the implementation of JpaRepository .
 *  @author  Abhishek Rawat
 *  @version 1.0
 *  @since   17-12-2019
 *
 ******************************************************************************/
package com.bridgelabz.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.usermanagement.entity.Privilege;
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>{

}
