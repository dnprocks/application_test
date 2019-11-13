package br.com.codenation.aplicacao.service.impl;

import br.com.codenation.aplicacao.domain.dao.CompanyDao;
import br.com.codenation.aplicacao.domain.dao.UserDao;
import br.com.codenation.aplicacao.domain.entity.Company;
import br.com.codenation.aplicacao.domain.entity.User;
import br.com.codenation.aplicacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CompanyDao companyDao;

    @Override
    @Transactional
    public User createUser(String name, String document, int age, String login, String password, Long idCompany, BigDecimal salary) {

        Company company = companyDao.getOne(idCompany);

        User newUser = User.builder().
                name(name).
                document(document).
                age(age).
                login(login).
                password(password).
                salary(salary).
                company(company).
                build();

        return userDao.save(newUser);
    }

    @Override
    public void updateNameUserById(Long id, String name) {
        userDao.updateNameUserById(id, name);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

}
