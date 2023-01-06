package br.com.mcp.hexagonal.adapters.out;

import br.com.mcp.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.mcp.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.mcp.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.mcp.hexagonal.application.core.domain.Customer;
import br.com.mcp.hexagonal.application.ports.out.FindCustomerByIdOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {

        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
