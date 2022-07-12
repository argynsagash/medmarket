package kz.sagashprojects.medmarket.features.companies.utils;

import kz.sagashprojects.medmarket.features.companies.data.entities.CompanyEntity;
import kz.sagashprojects.medmarket.features.companies.domain.models.Company;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyMapper {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);

    CompanyEntity toEntity(Company model);

    @InheritInverseConfiguration
    Company fromEntity(CompanyEntity entity);

    List<CompanyEntity> toEntityList(List<Company> models);

    List<Company> fromEntityList(List<CompanyEntity> entities);
}
