package kz.sagashprojects.medmarket.features.analyzers.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.sagashprojects.medmarket.features.analyzers.domain.models.Analyzer;
import kz.sagashprojects.medmarket.features.analyzers.domain.services.AnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/analyzers")
@Tag(name = "analyzers", description = "The Analyzers API")
public class AnalyzerController {

    private final AnalyzerService analyzerService;


    @GetMapping()
    public List<Analyzer> getAll() {
        return analyzerService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Analyzer analyzer) {
        analyzerService.create(analyzer);
    }

    @GetMapping("/{id}")
    public Analyzer getById(@PathVariable Long id) {
        return analyzerService.getById(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        analyzerService.delete(id);
    }

}
