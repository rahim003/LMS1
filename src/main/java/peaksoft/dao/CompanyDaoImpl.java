package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
//@Transactional
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Company saveCompany(Company company) {
        manager.persist(company);
        return company;
    }

    @Override
    public void updateCompany(long id, Company company) {
        Company company1 = getById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        manager.merge(company1);
    }

    @Override
    public Company getById(long id) {
        return manager.find(Company.class, id);
    }

    @Override
    public void deleteById(long id) {
        manager.remove(getById(id));
    }

    @Override
    public List<Company> getAllCompany() {
        return manager.createQuery("select company from Company company", Company.class).getResultList();
    }
}
