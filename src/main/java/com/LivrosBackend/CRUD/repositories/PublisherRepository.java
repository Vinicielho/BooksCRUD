package com.LivrosBackend.CRUD.repositories;

import com.LivrosBackend.CRUD.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}