package com.servicoTecnico.os.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servicoTecnico.os.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query(value="SELECT * FROM PESSOA WHERE CPF= :cpf", nativeQuery=true)
	Optional<Cliente> findClienteByCpf(@Param(value="cpf")String cpf);

	
}
