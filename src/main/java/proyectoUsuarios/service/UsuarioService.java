package proyectoUsuarios.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import proyectoUsuarios.model.Usuario;

public interface UsuarioService {
	
	public int addUsuario(Usuario usuario);
	public List<Usuario> getUsuarios();
	public void delUsuario(long id)throws EmptyResultDataAccessException;
	public Usuario getUsuario(long id)throws EmptyResultDataAccessException;
	public void updateUsuario(Usuario usuario)throws EmptyResultDataAccessException;
	
	

}
