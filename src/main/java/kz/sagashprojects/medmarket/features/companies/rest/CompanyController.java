package kz.sagashprojects.medmarket.features.companies.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.sagashprojects.medmarket.features.companies.domain.models.Company;
import kz.sagashprojects.medmarket.features.companies.domain.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/companies")
@Tag(name = "companies", description = "The Companies API")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping()
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Company company) {
        companyService.create(company);
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id) {
        return companyService.getById(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        companyService.delete(id);
    }
}
