package com.project.ecart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecart.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByMobile(String mobile);
}
