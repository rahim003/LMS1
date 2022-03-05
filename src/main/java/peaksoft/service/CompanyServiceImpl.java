package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CompanyDao;
import peaksoft.dao.CompanyDaoImpl;
import peaksoft.model.Company;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService{
    private CompanyDao companyDao;
   @Autowired
    public CompanyServiceImpl(CompanyDaoImpl companyDao) {
        this.companyDao = companyDao;
    }
    @Transactional
    @Override
    public Company saveCompany(Company company) {
        return companyDao.saveCompany(company);
    }
    @Transactional
    @Override
    public void updateCompany(long id,Company company) {
        companyDao.updateCompany(id,company);
    }
    @Transactional
    @Override
    public Company getById(long id) {
        return companyDao.getById(id);
    }
    @Transactional
    @Override
    public void deleteById(long id) {
      companyDao.deleteById(id);
    }
    @Transactional
    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }
}
