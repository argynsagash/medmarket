package kz.sagashprojects.medmarket.features.companies.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private String title;
    private String telephone;
    private String email;
    private String address;
}
