package com.trofimov.featurestore.service;

import com.trofimov.featurestore.domain.Feature;
import com.trofimov.featurestore.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {

    private final FeatureRepository featureRepository;

    @Autowired
    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Optional<Feature> getFeatureById(Long id) {
        return featureRepository.findById(id);
    }

    public Optional<Feature> getFeatureByNameAndVersion(String name, String version) {
        return featureRepository.findByNameAndVersion(name, version);
    }

    public Feature createFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    public Feature updateFeature(Long id, Feature updatedFeature) {
        return featureRepository.findById(id)
                .map(existingFeature -> {
                    existingFeature.setName(updatedFeature.getName());
                    existingFeature.setVersion(updatedFeature.getVersion());
                    existingFeature.setFeatureValue(updatedFeature.getFeatureValue());
                    existingFeature.setCreatedAt(updatedFeature.getCreatedAt());
                    existingFeature.setUpdatedAt(updatedFeature.getUpdatedAt());
                    return featureRepository.save(existingFeature);
                })
                .orElseThrow(() -> new RuntimeException("Feature not found with id " + id));
    }

    public void deleteFeature(Long id) {
        if (!featureRepository.existsById(id)) {
            throw new RuntimeException("Feature not found with id " + id);
        }
        featureRepository.deleteById(id);
    }
}
