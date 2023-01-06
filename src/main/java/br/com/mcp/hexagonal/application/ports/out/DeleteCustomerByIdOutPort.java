package br.com.mcp.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutPort {
    void delete(String id);
}
