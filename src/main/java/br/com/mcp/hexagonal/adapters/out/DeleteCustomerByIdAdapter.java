package br.com.mcp.hexagonal.adapters.out;

import br.com.mcp.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.mcp.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
