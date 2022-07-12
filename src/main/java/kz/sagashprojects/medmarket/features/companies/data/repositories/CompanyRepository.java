package kz.sagashprojects.medmarket.features.companies.data.repositories;

import kz.sagashprojects.medmarket.features.companies.data.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Long> {
}
