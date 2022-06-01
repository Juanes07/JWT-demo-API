package com.DEMOJWT.demo.repository;

import com.DEMOJWT.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUserName(Long id);

}
