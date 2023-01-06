package br.com.mcp.hexagonal.adapters.out.client.mapper;

import br.com.mcp.hexagonal.adapters.out.client.response.AddressResponse;
import br.com.mcp.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
