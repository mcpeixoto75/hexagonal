package br.com.mcp.hexagonal.config;

import br.com.mcp.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import br.com.mcp.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.mcp.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import br.com.mcp.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    )
    {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
