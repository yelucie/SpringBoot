package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.Ville;

public interface VilleRepository extends JpaRepository<Ville, String> {
}
