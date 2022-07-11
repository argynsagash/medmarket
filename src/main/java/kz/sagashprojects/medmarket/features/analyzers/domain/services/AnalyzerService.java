package kz.sagashprojects.medmarket.features.analyzers.domain.services;

import kz.sagashprojects.medmarket.features.analyzers.data.entities.AnalyzerEntity;
import kz.sagashprojects.medmarket.features.analyzers.domain.models.Analyzer;

import java.util.List;

public interface AnalyzerService {
    //create or update
    void create(Analyzer analyzer);
    Analyzer getById(Long id);
    List<Analyzer> getAll();
    void delete(Long id);
}
