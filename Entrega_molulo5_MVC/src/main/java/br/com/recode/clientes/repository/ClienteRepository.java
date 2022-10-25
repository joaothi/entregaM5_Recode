package br.com.recode.clientes.repository;



import org.springframework.data.jpa.repository.JpaRepository;



import br.org.com.recode.model.*;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}