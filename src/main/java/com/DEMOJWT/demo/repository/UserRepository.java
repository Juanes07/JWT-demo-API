package com.DEMOJWT.demo.repository;

import com.DEMOJWT.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Respository
 *
 * @author Juan Pablo Toro, Juan Esteban Velasquez
 * @version 1.0.0
 * @since 1.0.0
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
