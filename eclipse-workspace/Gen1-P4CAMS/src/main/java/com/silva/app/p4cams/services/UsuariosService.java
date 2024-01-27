package com.silva.app.p4cams.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.app.p4cams.dao.IUsuariosDAO;
import com.silva.app.p4cams.models.Usuario;

@Service
public class UsuariosService implements IService<Usuario, Usuario>
{
	@Autowired
	private IUsuariosDAO usuarioDao;
	
	@Override
	public List<Usuario> listar() 
	{
		List<Usuario> usuarios = new ArrayList<>();
		usuarios = (List<Usuario>) usuarioDao.findAll();
		return usuarios;
	}

	@Override
	public Optional<Usuario> getById(Long id) 
	{
		Optional<Usuario> usuario = usuarioDao.findById(id);
		return usuario;
	}

	@Override
	public void guardar(Usuario t) 
	{
		// TODO Auto-generated method stub
		this.usuarioDao.save(t);
	}

	@Override
	public void eliminar(Long id) 
	{
		// TODO Auto-generated method stub
		this.usuarioDao.deleteById(id);
	}

}
