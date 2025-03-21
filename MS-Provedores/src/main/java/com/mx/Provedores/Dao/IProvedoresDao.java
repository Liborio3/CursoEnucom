package com.mx.Provedores.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Provedores.Entity.Provedores;

@Repository
public interface IProvedoresDao extends JpaRepository<Provedores, Long>{
	
	public List<Provedores> findByTiendaId(int tiendaId);

}
