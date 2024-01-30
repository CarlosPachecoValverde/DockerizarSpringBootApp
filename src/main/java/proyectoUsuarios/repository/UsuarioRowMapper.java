package proyectoUsuarios.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import proyectoUsuarios.model.Usuario;
public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getLong("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setTiempo(rs.getInt("tiempo"));
		usuario.setComentario(rs.getString("comentario"));
		usuario.setParcelas(rs.getInt("parcelas"));
		return usuario;
	}
	
	
	
	

}
