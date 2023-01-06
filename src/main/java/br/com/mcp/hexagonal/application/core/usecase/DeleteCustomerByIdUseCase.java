package br.com.mcp.hexagonal.application.core.usecase;

import br.com.mcp.hexagonal.application.ports.in.DeleteCustomerByIdInPort;
import br.com.mcp.hexagonal.application.ports.in.FindCustomerByIdInPort;
import br.com.mcp.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInPort {


    private final FindCustomerByIdInPort findCustomerByIdInPort;
    private final DeleteCustomerByIdOutPort deleteCustomerByIdOutPort;

    public DeleteCustomerByIdUseCase(
            FindCustomerByIdInPort findCustomerByIdInPort,
            DeleteCustomerByIdOutPort deleteCustomerByIdOutPort)
    {
        this.findCustomerByIdInPort = findCustomerByIdInPort;
        this.deleteCustomerByIdOutPort = deleteCustomerByIdOutPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInPort.find(id);
        deleteCustomerByIdOutPort.delete(id);

    }
}
