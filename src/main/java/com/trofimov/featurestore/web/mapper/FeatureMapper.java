package com.trofimov.featurestore.web.mapper;

import com.trofimov.featurestore.domain.Feature;
import com.trofimov.featurestore.web.dto.FeatureDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface  FeatureMapper {

    FeatureMapper INSTANCE = Mappers.getMapper(FeatureMapper.class);
    Feature toEntity(FeatureDTO dto);
    FeatureDTO toDTO(Feature entity);
}
