package com.mx.Cajero.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.Cajero.Entity.Transacciones;

@Repository
public interface ITransaccionDao extends JpaRepository<Transacciones, Long>{

    // Método personalizado para obtener transacciones por monto
    List<Transacciones> findByMonto(double monto);
    
    @Query("SELECT t FROM Transacciones t WHERE TO_CHAR(t.fechaHora, 'YYYY-MM-DD') LIKE %:fecha%")
    List<Transacciones> findByFechaHoraContaining(String fecha);
}
