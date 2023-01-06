package br.com.mcp.hexagonal.adapters.out.repository.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2")
    @GeneratedValue(generator = "generator")
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "addressentityid")
    private AddressEntity addressEntity;

    private String cpf;

    private Boolean isValidCpf;
}
