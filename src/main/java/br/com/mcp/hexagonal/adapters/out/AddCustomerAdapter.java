package br.com.mcp.hexagonal.adapters.out;

import br.com.mcp.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.mcp.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.mcp.hexagonal.application.core.domain.Customer;
import br.com.mcp.hexagonal.application.ports.out.AddCustomerOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddCustomerAdapter implements AddCustomerOutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public void add(Customer customer) {

        var customerEntity = customerEntityMapper.toCustomerEntity(customer);

        customerRepository.save(customerEntity);
    }
}
