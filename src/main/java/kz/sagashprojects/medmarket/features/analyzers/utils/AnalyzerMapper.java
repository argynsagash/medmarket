package kz.sagashprojects.medmarket.features.analyzers.utils;

import kz.sagashprojects.medmarket.features.analyzers.data.entities.AnalyzerEntity;
import kz.sagashprojects.medmarket.features.analyzers.domain.models.Analyzer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnalyzerMapper {
    AnalyzerMapper MAPPER = Mappers.getMapper(AnalyzerMapper.class);

    AnalyzerEntity toEntity(Analyzer model);

    @InheritInverseConfiguration
    Analyzer fromEntity(AnalyzerEntity entity);

    List<AnalyzerEntity> toEntityList(List<Analyzer> models);

    List<Analyzer> fromEntityList(List<AnalyzerEntity> entities);
}
