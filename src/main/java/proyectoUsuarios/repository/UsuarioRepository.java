package proyectoUsuarios.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proyectoUsuarios.model.Usuario;



public interface UsuarioRepository {
	
	
	public int addUsuario(Usuario usuario);
	public List<Usuario> getUsuarios();
	public void delUsuario(long id)throws EmptyResultDataAccessException;
	public Usuario getUsuario(long id)throws EmptyResultDataAccessException;
	public void updateUsuario(Usuario usuario)throws EmptyResultDataAccessException;
	
	
}
