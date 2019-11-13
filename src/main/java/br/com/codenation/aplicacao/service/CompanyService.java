package br.com.codenation.aplicacao.service;

import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.exception.EmpresaException;

import java.util.List;

public interface CompanyService {

    Company createCompany(String name, String document, int vacancies, String site, Long addressId);

    void deleteCompany(Company company);

    List<Company> findAllByNameOrByName(String name);

}
