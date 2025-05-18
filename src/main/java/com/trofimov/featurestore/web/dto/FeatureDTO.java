package com.trofimov.featurestore.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FeatureDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Version is required")
    @Size(max = 255, message = "Version must be less than 255 characters")
    private String version;

    @NotBlank(message = "Feature value is required")
    private String featureValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }
}
