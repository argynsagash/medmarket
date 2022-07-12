package kz.sagashprojects.medmarket.features.analyzers.data.services;

import kz.sagashprojects.medmarket.features.analyzers.data.entities.AnalyzerEntity;
import kz.sagashprojects.medmarket.features.analyzers.data.repositories.AnalyzerRepository;
import kz.sagashprojects.medmarket.features.analyzers.utils.AnalyzerMapper;
import kz.sagashprojects.medmarket.features.analyzers.domain.models.Analyzer;
import kz.sagashprojects.medmarket.features.analyzers.domain.services.AnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        AnalyzerEntity analyzerEntity = new AnalyzerEntity();
        analyzerEntity.setModel(analyzer.getModel());
        analyzerEntity.setSerialNumber(analyzer.getSerialNumber());
        analyzerRepository.save(analyzerEntity);
    }

    @Override
    public Analyzer getById(Long id) {
        AnalyzerEntity analyzerEntity = analyzerRepository.findById(id).get();
        Analyzer analyzer = new Analyzer();
        analyzer.setModel(analyzerEntity.getModel());
        analyzer.setSerialNumber(analyzerEntity.getSerialNumber());
        return analyzer;
    }

    @Override
    public List<Analyzer> getAll() {
        return AnalyzerMapper.INSTANCE.fromEntityList(analyzerRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        AnalyzerEntity analyzerEntity = analyzerRepository.findById(id).get();
        analyzerRepository.delete(analyzerEntity);

    }
}
