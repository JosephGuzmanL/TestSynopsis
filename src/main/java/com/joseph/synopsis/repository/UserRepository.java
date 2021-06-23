package com.joseph.synopsis.repository;

import com.joseph.synopsis.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Extends JPARepository interface for DB actions
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
