package kz.sagashprojects.medmarket.features.analyzers.data.entities;

import kz.sagashprojects.medmarket.features.companies.data.entities.CompanyEntity;
import kz.sagashprojects.medmarket.features.companies.domain.models.Company;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "analyzer")
public class AnalyzerEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column(unique = true)
    private String serialNumber;
    @Column
    private String brand;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;
}
