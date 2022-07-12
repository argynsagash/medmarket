package kz.sagashprojects.medmarket.features.companies.domain.services;

import kz.sagashprojects.medmarket.features.companies.domain.models.Company;

import java.util.List;

public interface CompanyService {
    void create(Company company);
    Company getById(Long id);
    List<Company> getAll();
    void delete(Long id);
}
