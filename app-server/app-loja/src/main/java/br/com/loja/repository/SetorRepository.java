package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.entity.SetorEntity;

@Repository
public interface SetorRepository extends JpaRepository<SetorEntity, Integer>{

}
