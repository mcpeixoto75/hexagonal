package br.com.mcp.hexagonal.adapters.out.repository;

import br.com.mcp.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
