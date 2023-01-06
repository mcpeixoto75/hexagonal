package br.com.mcp.hexagonal.adapters.out;

import br.com.mcp.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import br.com.mcp.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.mcp.hexagonal.application.core.domain.Address;
import br.com.mcp.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPort {

    @Autowired
    FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    AddressResponseMapper addressResponseMapper;
    @Override
    public Address find(String zipCode) {

        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
