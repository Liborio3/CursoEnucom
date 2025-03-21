package com.mx.Cajero.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Cajero.Entity.Denominaciones;

@Repository
public interface IDenominacionesDao extends JpaRepository<Denominaciones, Long>{
	

    //Obtener todas las denominaciones 
    @Query(nativeQuery = true,
    		value = "SELECT * FROM DENOMINACIONES ORDER BY VALOR DESC" )
    List<Denominaciones> findAllOrderByValorDesc();
    
    //Actualizar la cantidad de una denominacion
    @Modifying
    @Transactional
    @Query(nativeQuery = true,
    		value = "UPDATE DENOMINACIONES SET CANTIDAD = :cantidad WHERE ID_DENOMINACION = :idDenominacion")
    void actualizarCantidad(@Param("idDenominacion") long idDenominacion, @Param("cantidad") int cantidad);

    //Obtener una denominacion por su valor
    @Query(nativeQuery = true, value = "SELECT * FROM DENOMINACIONES WHERE VALOR = :valor")
    Denominaciones findByValor(@Param("valor") double valor);

}
