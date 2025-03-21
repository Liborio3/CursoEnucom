package com.mx.Cajero.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Cajero.Dao.ITransaccionDao;
import com.mx.Cajero.Entity.Transacciones;

@Service
public class TransaccionesServiceImpl implements ITransaccionesService{

    @Autowired
    private ITransaccionDao dao;
    
	@Override
	public void guardar(Transacciones tra) {
		dao.save(tra);
		
	}

	@Override
	public void editar(Transacciones tra) {
		dao.save(tra);
	}

	@Override
	public void eliminar(int idTransaccion) {
		dao.deleteById((long) idTransaccion);
		
	}

	@Override
	public Transacciones buscar(int idTransaccion) {
		
		return dao.findById((long) idTransaccion).orElse(null);
	}

	@Override
	public List<Transacciones> listar() {
		return dao.findAll();
	}
	
	//Metodos personalizados
    public List<Transacciones> buscarPorMonto(Double monto) {
        return dao.findByMonto(monto);
    }
	
    public List<Transacciones> buscarPorFechaHora(String fecha) {
        return dao.findByFechaHoraContaining(fecha);
    }

}
