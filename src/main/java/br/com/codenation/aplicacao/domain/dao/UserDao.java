package br.com.codenation.aplicacao.domain.dao;

import br.com.codenation.aplicacao.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "UPDATE company set name = :name WHERE id = :id", nativeQuery = true)
    void updateNameUserById(@Param("id") Long id, @Param("name") String name);

}
