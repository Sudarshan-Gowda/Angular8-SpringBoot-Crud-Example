/**
 * 
 */
package com.star.sud.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.star.sud.crud.model.TUser;

/**
 * @author Sudarshan
 *
 */
@Repository
public interface UserDao extends JpaRepository<TUser, Long> {

}
