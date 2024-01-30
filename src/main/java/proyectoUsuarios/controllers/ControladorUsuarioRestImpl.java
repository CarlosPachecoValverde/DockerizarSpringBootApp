package proyectoUsuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proyectoUsuarios.model.Usuario;
import proyectoUsuarios.repository.UsuarioRepository;


@RestController
public class ControladorUsuarioRestImpl {

	@Autowired
	UsuarioRepository repositorio;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		
		return this.repositorio.getUsuarios();
		
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<String> addUsuario(@RequestBody Usuario usuario){
		this.repositorio.addUsuario(usuario);

		return ResponseEntity.ok("Datos recibidos y usuario añadido");
	}
	
	
}
