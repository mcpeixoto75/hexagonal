package br.com.mcp.hexagonal.adapters.out;

import br.com.mcp.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.mcp.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.mcp.hexagonal.application.core.domain.Customer;
import br.com.mcp.hexagonal.application.ports.out.UpdateCustomerOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter  implements UpdateCustomerOutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {

        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
