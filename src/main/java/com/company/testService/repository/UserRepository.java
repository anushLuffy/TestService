/**
 * 
 */
package com.company.testService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.testService.model.User;

/**
 * @author anush
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User getuserByEmailId(String emailId);

	User validateUser(String emailId, String password);

}

