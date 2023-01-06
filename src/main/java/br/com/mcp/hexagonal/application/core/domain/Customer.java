package br.com.mcp.hexagonal.application.core.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Customer {

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;


}
