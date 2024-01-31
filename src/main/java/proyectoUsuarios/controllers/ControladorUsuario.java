package proyectoUsuarios.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import proyectoUsuarios.model.Usuario;

public interface ControladorUsuario {

	public List<Usuario> getUsuarios();
	public Usuario getUser(@PathVariable long id);
	public ResponseEntity<String> addUsuario(@RequestBody Usuario usuario);
	public ResponseEntity<String> deleteUsuario(@PathVariable long id);
	public ResponseEntity<String> updateUsuario(@PathVariable long id,@RequestBody Usuario usuario);
	
	
}
