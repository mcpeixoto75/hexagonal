package br.com.mcp.hexagonal.application.ports.in;

import br.com.mcp.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInPort {
    Customer find(String id);
}
