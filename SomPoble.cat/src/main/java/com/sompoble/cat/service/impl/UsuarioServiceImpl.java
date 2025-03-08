package com.sompoble.cat.service.impl;

import com.sompoble.cat.domain.Cliente;
import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.domain.Usuario;
import com.sompoble.cat.repository.UsuarioRepository;
import com.sompoble.cat.repository.ClienteRepository;
import com.sompoble.cat.repository.EmpresarioRepository;
import com.sompoble.cat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ClienteRepository clienteRepository;
    private EmpresarioRepository empresarioRepository;

    @Override
    public void addUsuario(Usuario usuario, String dni, String nombre, String apellidos, String email, String telefono) {
        if (usuario == null || usuario.getTipoUsuario() == null) {
            throw new IllegalArgumentException("El usuario y su tipo no pueden ser nulos.");
        }
        
        usuarioRepository.addUsuario(usuario);
        
        if ("Cliente".equals(usuario.getTipoUsuario())) {
            Cliente cliente = new Cliente();
            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setApellidos(apellidos);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setUsuarioCliente(usuario);  // Vinculamos el Usuario con el Cliente
            clienteRepository.addCliente(cliente);
        } else if ("Empresario".equals(usuario.getTipoUsuario())) {
            Empresario empresario = new Empresario();
            empresario.setDni(dni);
            empresario.setNombre(nombre);
            empresario.setApellidos(apellidos);
            empresario.setEmail(email);
            empresario.setTelefono(telefono);
            empresarioRepository.addEmpresario(empresario);
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        if (usuario == null || usuario.getTipoUsuario() == null) {
            throw new IllegalArgumentException("El usuario y su tipo no pueden ser nulos.");
        }
        usuarioRepository.updateUsuario(usuario);
    }

    @Override
    public Usuario findByNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser nulo o vacío.");
        }
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
}