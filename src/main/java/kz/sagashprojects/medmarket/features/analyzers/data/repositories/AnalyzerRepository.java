package kz.sagashprojects.medmarket.features.analyzers.data.repositories;

import kz.sagashprojects.medmarket.features.analyzers.data.entities.AnalyzerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzerRepository extends JpaRepository<AnalyzerEntity,Long> {
}
