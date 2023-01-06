package br.com.mcp.hexagonal.application.core.usecase;

import br.com.mcp.hexagonal.application.core.domain.Customer;
import br.com.mcp.hexagonal.application.ports.in.AddCustomerInPort;
import br.com.mcp.hexagonal.application.ports.out.AddCustomerOutPort;
import br.com.mcp.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;

public class AddCustomerUseCase implements AddCustomerInPort {

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;

    private final AddCustomerOutPort addCustomerOutPort;


    public AddCustomerUseCase(
            FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
            AddCustomerOutPort addCustomerOutPort)
    {
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.addCustomerOutPort = addCustomerOutPort;
    }

    @Override
    public void add(Customer customer, String zipCode){

        var address = findAddressByZipCodeOutPort.find(zipCode);
        customer.setAddress(address);
        addCustomerOutPort.add(customer);

    }
}
