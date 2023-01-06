package br.com.mcp.hexagonal.application.core.usecase;

import br.com.mcp.hexagonal.application.core.domain.Customer;
import br.com.mcp.hexagonal.application.ports.in.FindCustomerByIdInPort;
import br.com.mcp.hexagonal.application.ports.out.FindCustomerByIdOutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInPort {

    private final FindCustomerByIdOutPort findCustomerByIdOutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPort findCustomerByIdOutPort) {
        this.findCustomerByIdOutPort = findCustomerByIdOutPort;
    }

    @Override
    public Customer find(String id){

        return findCustomerByIdOutPort.find(id)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));

    }
}
