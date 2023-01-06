package br.com.mcp.hexagonal.application.ports.out;

import br.com.mcp.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPort {
    Address find(String zipCode);

}
