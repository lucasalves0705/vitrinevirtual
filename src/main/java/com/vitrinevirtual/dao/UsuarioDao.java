package com.vitrinevirtual.dao;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.vitrinevirtual.Entidades.Usuario;

@Repository
public class UsuarioDao extends AbstractDao<Usuario, Integer> implements IUsuarioDao, UserDetailsService{
	
	@Override
	public Usuario findByUserName(String username) {
	    List<Usuario> lista =  this.createQuery("select u from Usuario as u where u.nome like ?1", username); // Nome da tabela é o nome da entidade
	    return lista.isEmpty() ? null : lista.get(0);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = findByUserName(username);
		List<GrantedAuthority> listaAdmin = AuthorityUtils.createAuthorityList("USER", "MANAGER");
		List<GrantedAuthority> listaUser = AuthorityUtils.createAuthorityList("USER");
		return new org.springframework.security.core.userdetails.User(user.getNome(), user.getSenha(), user.getId_tipouser().getId()==1 ? listaAdmin : listaUser);
	}
	
}
