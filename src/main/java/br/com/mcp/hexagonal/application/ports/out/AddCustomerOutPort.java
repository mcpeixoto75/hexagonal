package br.com.mcp.hexagonal.application.ports.out;

import br.com.mcp.hexagonal.application.core.domain.Customer;

public interface AddCustomerOutPort {
    void add(Customer customer);
}
