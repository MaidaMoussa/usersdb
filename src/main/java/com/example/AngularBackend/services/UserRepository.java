package com.example.AngularBackend.services;

import com.example.AngularBackend.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByName(String username);
    Optional<UserEntity> findByNameAndPassword(String username,String password);
}
