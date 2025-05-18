package com.trofimov.featurestore.web.controller;

import com.trofimov.featurestore.domain.Feature;
import com.trofimov.featurestore.service.FeatureService;
import com.trofimov.featurestore.web.dto.FeatureDTO;
import com.trofimov.featurestore.web.mapper.FeatureMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/features")
public class FeatureController {

    private final FeatureService featureService;
    private final FeatureMapper featureMapper;

    @Autowired
    public FeatureController(FeatureService featureService, FeatureMapper featureMapper) {
        this.featureService = featureService;
        this.featureMapper = featureMapper;
    }

    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable Long id) {
        Optional<Feature> feature = featureService.getFeatureById(id);
        return feature.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Feature> getFeatureByNameAndVersion(@RequestParam String name, @RequestParam String version) {
        Optional<Feature> feature = featureService.getFeatureByNameAndVersion(name, version);
        return feature.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Feature> createFeature(@Valid @RequestBody FeatureDTO featureDTO) {
        Feature feature = featureMapper.toEntity(featureDTO);
        Feature savedFeature = featureService.createFeature(feature);
        return ResponseEntity.ok(savedFeature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feature> updateFeature(@PathVariable Long id, @Valid @RequestBody FeatureDTO featureDTO) {
        Feature feature = featureMapper.toEntity(featureDTO);
        try {
            Feature updatedFeature = featureService.updateFeature(id, feature);
            return ResponseEntity.ok(updatedFeature);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }
}
