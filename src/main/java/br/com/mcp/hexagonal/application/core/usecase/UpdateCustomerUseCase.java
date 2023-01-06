package br.com.mcp.hexagonal.application.core.usecase;

import br.com.mcp.hexagonal.application.core.domain.Customer;
import br.com.mcp.hexagonal.application.ports.in.FindCustomerByIdInPort;
import br.com.mcp.hexagonal.application.ports.in.UpdateCustomerInPort;
import br.com.mcp.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import br.com.mcp.hexagonal.application.ports.out.UpdateCustomerOutPort;

public class UpdateCustomerUseCase implements UpdateCustomerInPort {

    private final FindCustomerByIdInPort findCustomerByIdInPort;
    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;

    private final UpdateCustomerOutPort updateCustomerOutPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInPort findCustomerByIdInPort,
            FindAddressByZipCodeOutPort findAddressByZipCodeOutPort, UpdateCustomerOutPort updateCustomerOutPort)
    {
        this.findCustomerByIdInPort = findCustomerByIdInPort;
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.updateCustomerOutPort = updateCustomerOutPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInPort.find(customer.getId());
        var address = findAddressByZipCodeOutPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutPort.update(customer);
    }
}
