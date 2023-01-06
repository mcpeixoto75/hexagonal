package br.com.mcp.hexagonal.config;


import br.com.mcp.hexagonal.adapters.out.AddCustomerAdapter;
import br.com.mcp.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.mcp.hexagonal.application.core.usecase.AddCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddCustomerConfig {

    @Bean
    public AddCustomerUseCase addCustomerUseCase(AddCustomerAdapter addCustomerAdapter, FindAddressByZipCodeAdapter findAddressByZipCodeAdapter){
        return new AddCustomerUseCase(findAddressByZipCodeAdapter, addCustomerAdapter);

    }
}
