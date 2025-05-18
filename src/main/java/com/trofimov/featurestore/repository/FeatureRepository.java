package com.trofimov.featurestore.repository;

import com.trofimov.featurestore.domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

    Optional<Feature> findByNameAndVersion(String name, String version);
}
