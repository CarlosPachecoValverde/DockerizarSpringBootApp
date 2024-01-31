package proyectoUsuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectoUsuarios.model.Usuario;
import proyectoUsuarios.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repositorio;
	
	
	@Override
	public int addUsuario(Usuario usuario) {
		return repositorio.addUsuario(usuario);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return repositorio.getUsuarios();
	}

	@Override
	public void delUsuario(long id) {
		repositorio.delUsuario(id);
		
	}

	@Override
	public Usuario getUsuario(long id) {
		return repositorio.getUsuario(id);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		 repositorio.updateUsuario(usuario);
		
	}

}
