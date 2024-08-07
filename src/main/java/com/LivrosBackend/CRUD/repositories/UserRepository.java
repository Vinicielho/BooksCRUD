package com.LivrosBackend.CRUD.repositories;
import com.LivrosBackend.CRUD.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByName(String name);
}
