package kz.sagashprojects.medmarket.features.companies.data.entities;


import kz.sagashprojects.medmarket.features.analyzers.data.entities.AnalyzerEntity;
import kz.sagashprojects.medmarket.features.analyzers.domain.models.Analyzer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "company")
public class CompanyEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @Column
    private String telephone;
    @Column
    private String email;
    @Column
    private String address;
    @OneToMany(mappedBy = "companyEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnalyzerEntity> analyzerEntities;
}
