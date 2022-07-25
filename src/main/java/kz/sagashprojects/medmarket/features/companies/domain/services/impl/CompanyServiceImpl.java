package kz.sagashprojects.medmarket.features.companies.domain.services.impl;

import kz.sagashprojects.medmarket.features.companies.data.entities.CompanyEntity;
import kz.sagashprojects.medmarket.features.companies.data.repo.CompanyRepository;
import kz.sagashprojects.medmarket.features.companies.domain.models.Company;
import kz.sagashprojects.medmarket.features.companies.domain.services.CompanyService;
import kz.sagashprojects.medmarket.features.companies.utils.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public void create(Company company) {
        CompanyEntity companyEntity = CompanyMapper.MAPPER.toEntity(company);
        companyRepository.save(companyEntity);

    }

    @Override
    public Company getById(Long id) {
        return CompanyMapper.MAPPER.fromEntity(companyRepository.findById(id).get());
    }

    @Override
    public List<Company> getAll() {
        return CompanyMapper.MAPPER.fromEntityList(companyRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);

    }
}
