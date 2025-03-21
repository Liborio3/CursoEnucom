package com.mx.Provedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Provedores.Entity.Provedores;
import com.mx.Provedores.Service.ProvedoresServiceImpl;

@RestController
@RequestMapping("/Provedores")
public class ProvedorWs {

	@Autowired
	ProvedoresServiceImpl service;

	@GetMapping
	public ResponseEntity<?> listarProvedores() {
		List<Provedores> provedores = service.listar();

		if (provedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(provedores);
		}

	}

	// Metodo buscar
	@PostMapping("/{idProvedor}")
	public ResponseEntity<?> obtenerProvedor(@PathVariable Long idProvedor) {
		Provedores provedor = service.buscar(idProvedor);
		if (provedor != null) {
			return ResponseEntity.ok(provedor);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	// guardar
	@PostMapping
	public ResponseEntity<?> guardarProvedor(@RequestBody Provedores provedor) {
		//
		//
		return ResponseEntity.ok(service.gurdar(provedor));
	}

	@PutMapping
	public ResponseEntity<?> actualizarProvedor(@RequestBody Provedores provedor) {
		Provedores provedorBD = service.buscar(provedor.getIdProvedor());
		if (provedorBD != null) {

			return ResponseEntity.ok(service.editar(provedor));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{idProvedor}")
	public ResponseEntity<?> eliminarProvedor(@PathVariable Long idProvedor) {
		Provedores provedor = service.buscar(idProvedor);
		if (provedor != null) {
			service.eliminar(idProvedor);
			return ResponseEntity.ok(provedor);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	//Metodo personalizado
	@PostMapping("buscarPorTienda/{tiendaId}")
	public ResponseEntity<?> buscarPorTienda(@PathVariable int tiendaId) {
		List<Provedores> provedoresLista = service.buscarPorTienda(tiendaId);

		if (provedoresLista != null) {
			return ResponseEntity.ok(provedoresLista);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
