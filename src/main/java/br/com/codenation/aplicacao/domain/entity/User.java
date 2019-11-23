package br.com.codenation.aplicacao.domain.entity;

import br.com.codenation.aplicacao.annotation.ColumnAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "document", nullable = false, length = 255)
    private String document;

    @Column(name = "age")
    private int age;

    @Column(name = "login", nullable = false, length = 255)
    private String login;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "salary", nullable = false, length = 255)
    private BigDecimal salary;

    @ColumnAnnotation(text = "Company name is", position = 1)
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @Override
    public boolean equals(Object object) {
        User obj = (User) object;
        if (obj.getDocument().equalsIgnoreCase(this.getDocument())
                || obj.getName().equalsIgnoreCase(this.getName())
                || obj.getLogin().equals(this.getLogin())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAge();
    }
}
