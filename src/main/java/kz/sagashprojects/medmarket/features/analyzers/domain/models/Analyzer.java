package kz.sagashprojects.medmarket.features.analyzers.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analyzer {
    private String model;
    private String serialNumber;
    private String brand;
}
