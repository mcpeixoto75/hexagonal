package br.com.mcp.hexagonal.adapters.in.controller;

import br.com.mcp.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.mcp.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.mcp.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.mcp.hexagonal.application.ports.in.AddCustomerInPort;
import br.com.mcp.hexagonal.application.ports.in.DeleteCustomerByIdInPort;
import br.com.mcp.hexagonal.application.ports.in.FindCustomerByIdInPort;
import br.com.mcp.hexagonal.application.ports.in.UpdateCustomerInPort;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AddCustomerInPort addCustomerInPort;

    @Autowired
    private FindCustomerByIdInPort findCustomerByIdInPort;

    @Autowired
    private UpdateCustomerInPort updateCustomerInPort;

    @Autowired
    private DeleteCustomerByIdInPort deleteCustomerByIdInPort;

    @PostMapping
    public ResponseEntity<Void> add (@RequestBody @Valid CustomerRequest  customerRequest){

        var customer = customerMapper.toCustomer(customerRequest);
        addCustomerInPort.add(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id){
        var customer = findCustomerByIdInPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody @Valid CustomerRequest  customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        deleteCustomerByIdInPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
