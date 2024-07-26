package com.fullstack_backend.fullstack_backend.Repository;

import com.fullstack_backend.fullstack_backend.Module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
