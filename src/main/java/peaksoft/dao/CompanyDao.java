package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;

import java.util.List;

//@Repository
public interface CompanyDao {
    Company saveCompany(Company company);

      void  updateCompany(long id, Company company);

    Company getById(long id);

    void deleteById(long id);

    List<Company> getAllCompany();

}
