package kz.sagashprojects.medmarket.features.analyzers.domain.services.impl;

import kz.sagashprojects.medmarket.features.analyzers.data.entities.AnalyzerEntity;
import kz.sagashprojects.medmarket.features.analyzers.data.repo.AnalyzerRepository;
import kz.sagashprojects.medmarket.features.analyzers.utils.AnalyzerMapper;
import kz.sagashprojects.medmarket.features.analyzers.domain.models.Analyzer;
import kz.sagashprojects.medmarket.features.analyzers.domain.services.AnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnalyzerServiceImpl implements AnalyzerService {

    private final AnalyzerRepository analyzerRepository;


    @Override
    public void create(Analyzer analyzer) {
        AnalyzerEntity analyzerEntity = AnalyzerMapper.MAPPER.toEntity(analyzer);
        analyzerRepository.save(analyzerEntity);
    }

    @Override
    public Analyzer getById(Long id) {
        return AnalyzerMapper.MAPPER.fromEntity(analyzerRepository.findById(id).get());
    }

    @Override
    public List<Analyzer> getAll() {
        return AnalyzerMapper.MAPPER.fromEntityList(analyzerRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        analyzerRepository.deleteById(id);

    }
}
