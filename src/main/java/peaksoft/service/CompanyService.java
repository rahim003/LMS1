package peaksoft.service;
import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);

    void updateCompany(long id, Company company);

    Company getById(long id);

    void deleteById(long id);

    List<Company> getAllCompany();
}
