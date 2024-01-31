package proyectoUsuarios.repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import proyectoUsuarios.model.Usuario;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	@Override
	public int addUsuario(Usuario usuario) {
		String sql="insert into usuario (nombre,tiempo,comentario,parcelas) values (?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(
			(PreparedStatementCreator) connection -> {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, usuario.getNombre());
				ps.setInt(2, usuario.getTiempo());
				ps.setString(3, usuario.getComentario());
				ps.setInt(4,usuario.getParcelas());
				return ps;
			},
		
		keyHolder);
		
		Number key = keyHolder.getKey();
		
			return key.intValue();
		
		
	}

	@Override
	public List<Usuario> getUsuarios() {
		String sql="SELECT * FROM usuario";
		return template.query(sql, new UsuarioRowMapper());
	}

	@Override
	public void delUsuario(long id) {
		String sql= "DELETE FROM usuario WHERE id=?";
		template.update(sql,id);
		
	}

	@Override
	public Usuario getUsuario(long id) {
		String sql = "SELECT * FROM usuario WHERE id=?";
		return template.queryForObject(sql, new UsuarioRowMapper(),id);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		String sql = "UPDATE usuario SET nombre=?,tiempo=?,comentario=?,parcelas=? WHERE id=?";
		template.update(sql,usuario.getNombre(),usuario.getTiempo(),usuario.getComentario(),usuario.getParcelas(),usuario.getId());
		
	}

}
