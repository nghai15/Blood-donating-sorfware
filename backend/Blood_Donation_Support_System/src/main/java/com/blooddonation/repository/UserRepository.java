//Repository truy vấn CSDL
package com.blooddonation.repository;

import com.blooddonation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
