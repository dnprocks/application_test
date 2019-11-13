package br.com.codenation.aplicacao.service.impl;

import br.com.codenation.aplicacao.domain.dao.AddressDao;
import br.com.codenation.aplicacao.domain.dao.CompanyDao;
import br.com.codenation.aplicacao.domain.entity.Address;
import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    @Transactional
    public Company createCompany(String name, String document, int vacancies, String site, Long addressId) {

        Address address = addressDao.getOne(addressId);

        Company company = Company.builder().
                name(name).
                document(document).
                vacancies(vacancies).
                site(site).
                address(address).
                build();

        return companyDao.save(company);
    }

    @Override
    public void deleteCompany(Company company) {
        companyDao.delete(company);
    }

    @Override
    public List<Company> findAllByNameOrByName(String name) {
        return companyDao.findAllByNameOrByName(name);
    }

}
