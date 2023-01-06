package br.com.mcp.hexagonal.adapters.in.controller.response;

import br.com.mcp.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private AddressResponse address;

    private String cpf;

    private Boolean isValidCpf;

}
