package com.mx.Tienda.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.FeignClients.IClientesFeign;
import com.mx.Tienda.FeignClients.IProductosFeign;
import com.mx.Tienda.FeignClients.IProvedoresFeign;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Provedores;
import com.mx.Tienda.Repository.ITiendaRepository;

@Service
@SuppressWarnings("unchecked")
public class TiendaServiceImpl implements ITiendaService {

	// --------------------------Inyeccion de dependencias
	@Autowired
	ITiendaRepository dao;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IClientesFeign clienteFC;

	@Autowired
	private IProductosFeign productoFC;

	@Autowired
	private IProvedoresFeign provedoresFC;
	/// ------------------------------------------------------

	@Override
	public Tienda guardar(Tienda tienda) {
		return dao.save(tienda);
	}

	@Override
	public Tienda editar(Tienda tienda) {
		Tienda aux = this.buscar(tienda.getIdTienda());
		if (aux != null) {
			return dao.save(tienda);
		}
		return null;
	}

	@Override
	public Tienda eliminar(Integer idTienda) {
		Tienda aux = this.buscar(idTienda);
		if (aux != null) {
			dao.deleteById(idTienda);
			return aux;
		}
		return aux;
	}

	@Override
	public Tienda buscar(Integer idTienda) {
		return dao.findById(idTienda).orElse(null);
	}

	@Override
	public List<Tienda> listar() {
		return dao.findAll(Sort.by(Direction.DESC, "idTienda"));
	}

	// Metodo personalizado
	public List<Tienda> buscarPorNombreTienda(String nombre) {
		return dao.findByNombre(nombre);
	}

	// ----------------------------------Servicio de cliente
	// ================== Metodos con FeignClient
	public List<Clientes> listarClientes() {
		return clienteFC.listClientes();
	}

	public Clientes buscar(Long idClientes) {
		return clienteFC.search(idClientes);
	}

	public Clientes saveClientes(Clientes cliente) {
		return clienteFC.save(cliente);
	}

	public Clientes updateCliente(Clientes cliente) {
		return clienteFC.updateCliente(cliente);
	}

	public Clientes deleteCliente(Long idCliente) {
		return clienteFC.deleteCliente(idCliente);
	}

	public List<Clientes> getClientes(int tiendaId) {
		return clienteFC.getClientesByTiendaId(tiendaId);
	}

	// ===================Metodos con RestTemplate
	public Clientes saveClientesRT(Clientes cliente) {
		ResponseEntity<Clientes> response = restTemplate.postForEntity("http://localhost:8013/Clientes", cliente,
				Clientes.class);

		return response.getBody();
	}

	public List<Clientes> getClientesRT(int tiendaId) {

		return restTemplate.postForObject("http://localhost:8013/Clientes/Tienda/" + tiendaId, null, List.class);

	}

	// ----------------------------------Servicio de Productos

	// ======================Metodos con FeignClient de productos
	public List<Productos> listProductos() {
		return productoFC.listarProducts();
	}

	public Productos saveProducto(Productos producto) {
		return productoFC.save(producto);
	}

	public Productos searchProductos(Long idProductos) {
		return productoFC.search(idProductos);
	}

	public Productos updateProductos(Productos producto) {
		return productoFC.updateProduct(producto);
	}

	public Productos deleteProductos(Long idProducto) {
		return productoFC.deleteProduct(idProducto);
	}

	public List<Productos> getProductos(int tiendaId) {
		return productoFC.getProductoByTiendaId(tiendaId);
	}

	// =====================metodos con restTemplate
	public Productos saveProductoRT(Productos producto) {
		ResponseEntity<Productos> response = restTemplate.postForEntity("http://localhost:8010/Productos", producto,
				Productos.class);
		return response.getBody();
	}

	public List<Productos> getProductosRT(int tiendaId) {
		return restTemplate.getForObject("http://localhost:8010/Productos/tienda/" + tiendaId, List.class);
	}

	// ----------------------------------Servicio de Provedores

	// ========================= Metodos con FeignClient de Provedores

	public List<Provedores> listProvedores() {
		return provedoresFC.listProvedores();
	}

	public Provedores searchProvedores(Long idProvedor) {
		return provedoresFC.search(idProvedor);
	}

	public Provedores saveProvedores(Provedores provedor) {
		return provedoresFC.save(provedor);
	}

	public Provedores deleteProvedores(Long idProvedor) {
		return provedoresFC.deleteProvedores(idProvedor);
	}

	public Provedores updateProvedores(Provedores provedor) {
		return provedoresFC.updateProvedor(provedor);
	}

	public List<Provedores> getProvedores(int tiendaId) {
		return provedoresFC.getProvedoresByTiendaId(tiendaId);
	}

	// ===================== metodos con restTemplate
	public Provedores saveProvedoreRT(Provedores provedor) {
		ResponseEntity<Provedores> response = restTemplate.postForEntity("http://localhost:8011/Provedores", provedor,
				Provedores.class);
		return response.getBody();
	}

	public List<Provedores> getProvedoresRT(int tiendaId) {
		return restTemplate.postForObject("http://localhost:8011/Provedores/buscarPorTienda/" + tiendaId, null, List.class);
	}

	// *******************************************************************************
	// Metodos para relacionar la tienda
	// *******************************************************************************

	public Map<String, Object> obtenerTodosLosModulos(int tiendaId) {
		Map<String, Object> resultado = new HashMap<>();

		// Consultar y validar la tienda
		Tienda tienda = this.buscar(tiendaId);
		if (tienda == null) {
			resultado.put("Mensaje", "La tienda con ID: " + tiendaId + "no existe");
			return resultado;
		}

		resultado.put("Tienda", tienda);

		// Consultar y validar los clientes
		List<Clientes> clientes = this.getClientesRT(tiendaId);
		if ( clientes == null || clientes.isEmpty()  ) {
			resultado.put("Clientes", "la teinda no tiene clientes");
		} else {
			resultado.put("Clientes", clientes);
		}
		// Consultar y validar los productos

		List<Productos> productos = this.getProductosRT(tiendaId);
		if ( productos == null || productos.isEmpty() ) {
			resultado.put("Productos", "la Tienda no tiene productos");

		} else {
			resultado.put("Productos", productos);
		}

		// consultar y validar los provedores

		List<Provedores> provedores = this.getProvedoresRT(tiendaId);
		if ( provedores == null || provedores.isEmpty() ) {
			resultado.put("Provedores", "La tienda non tiene provedores.");
		} else {
			resultado.put("Provedores", provedores);
		}
		return resultado;
	}
}
