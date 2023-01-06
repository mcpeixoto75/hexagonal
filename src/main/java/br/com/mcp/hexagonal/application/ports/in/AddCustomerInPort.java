package br.com.mcp.hexagonal.application.ports.in;

import br.com.mcp.hexagonal.application.core.domain.Customer;

public interface AddCustomerInPort {

    void add(Customer customer, String zipCode);
}
