package proyectoUsuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proyectoUsuarios.model.Usuario;
import proyectoUsuarios.repository.UsuarioRepository;
import proyectoUsuarios.service.UsuarioService;


@RestController
public class ControladorUsuarioRestImpl implements ControladorUsuario{

	@Autowired
	UsuarioService service;
	
	@GetMapping("/usuarios")
	@Override
	public List<Usuario> getUsuarios(){
		
		return this.service.getUsuarios();
		
	}
	
	@PostMapping("/usuario")
	@Override
	public ResponseEntity<String> addUsuario(@RequestBody Usuario usuario){
		this.service.addUsuario(usuario);
		return ResponseEntity.ok("Datos recibidos y usuario añadido");
	}

	@GetMapping("/usuario/{id}")
	@Override
	public Usuario getUser(@PathVariable("id")long id) {
		
		 try {
			 	return this.service.getUsuario(id);
			
	        } catch (EmptyResultDataAccessException e) {
	            
	           System.out.println("Usuario no encontrado");
	        } 
		 return null;
	}

	@DeleteMapping("/usuario/{id}")
	@Override
	public ResponseEntity<String> deleteUsuario(@PathVariable("id")long id) {
	
		  try {
			  	this.service.delUsuario(id);
			
	        } catch (EmptyResultDataAccessException e) {
	            
	            return ResponseEntity.status(404).body("Usuario no encontrado");
	        } catch (Exception e) {
	        
	            return ResponseEntity.status(500).body("Error interno del servidor");
	        }
			return ResponseEntity.ok("Datos recibidos y usuario eliminado");
	}

	@Override
	@PostMapping("/usuario/{id}")
	public ResponseEntity<String> updateUsuario(@PathVariable("id")long id,@RequestBody Usuario usuario) {
		  try {
	            usuario.setId(id);
	            this.service.updateUsuario(usuario);
	     
	        } catch (EmptyResultDataAccessException e) {
	            
	            return ResponseEntity.status(404).body("Usuario no encontrado");
	        } catch (Exception e) {
	        
	            return ResponseEntity.status(500).body("Error interno del servidor");
	        }
	       return ResponseEntity.ok("Datos recibidos y usuario modificado");
	}



	
	
	
	
}
