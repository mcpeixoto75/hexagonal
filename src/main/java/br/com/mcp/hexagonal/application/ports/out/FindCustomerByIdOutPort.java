package br.com.mcp.hexagonal.application.ports.out;

import br.com.mcp.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPort {
    Optional<Customer> find(String id);

}
