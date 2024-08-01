package com.LivrosBackend.CRUD.repositories;

import com.LivrosBackend.CRUD.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}