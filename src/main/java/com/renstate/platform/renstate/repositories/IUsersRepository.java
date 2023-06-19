package com.renstate.platform.renstate.repositories;

import com.renstate.platform.renstate.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users, Long> {
}
