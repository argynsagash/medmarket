package kz.sagashprojects.medmarket.features.analyzers.presentation.rest;

import kz.sagashprojects.medmarket.features.analyzers.domain.models.Analyzer;
import kz.sagashprojects.medmarket.features.analyzers.domain.services.AnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/analyzers")
public class AnalyzerController {

    private final AnalyzerService analyzerService;


    @GetMapping()
    public List<Analyzer> getAll() {
        return analyzerService.getAll();
    }

}
