package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Usuario;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UsuarioHibernateTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    public void setUp() throws IOException {
        // Configuración de Hibernate
        Properties hibernateProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/hibernate.properties")) {
            hibernateProperties.load(fis);
        }
        sessionFactory = new Configuration()
            .setProperties(hibernateProperties)
            .addAnnotatedClass(Usuario.class)  // Asegúrate de que la clase anotada esté registrada
            .buildSessionFactory();
    }

    @Test
    public void testAddUsuario() {
        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("testUser");

        // Abrir una sesión y comenzar una transacción
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usuario);  // Guardar el usuario
            transaction.commit();

            // Verificar que el usuario se haya guardado
            Usuario retrievedUsuario = session.get(Usuario.class, usuario.getIdUsuario());
            assertNotNull(retrievedUsuario);
            assertEquals("testUser", retrievedUsuario.getNombreUsuario());
        }
    }

    @Test
    public void testUpdateUsuario() {
        // Crear y guardar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("userToUpdate");
        usuario.setContraseña("oldpass");

        // Abrir una sesión y comenzar una transacción
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usuario);  // Guardar el usuario inicialmente
            transaction.commit();
        }

        // Cambiar algún campo del usuario
        usuario.setContraseña("newpass");

        // Actualizar el usuario en la base de datos
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(usuario);  // Actualizar el usuario
            transaction.commit();
        }

        // Verificar que los cambios se hayan guardado
        try (Session session = sessionFactory.openSession()) {
            Usuario updatedUsuario = session.get(Usuario.class, usuario.getIdUsuario());
            assertNotNull(updatedUsuario);
            assertEquals("newpass", updatedUsuario.getContraseña());
        }
    }

    @Test
    public void testFindByNombreUsuario() {
        // Crear y guardar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("findUser");

        // Abrir una sesión y comenzar una transacción
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usuario);  // Guardar el usuario
            transaction.commit();
        }

        // Buscar el usuario por su nombre de usuario
        try (Session session = sessionFactory.openSession()) {
            Usuario foundUsuario = session.createQuery("FROM Usuario WHERE nombreUsuario = :nombreUsuario", Usuario.class)
                                          .setParameter("nombreUsuario", "findUser")
                                          .uniqueResult();
            // Verificar que el usuario encontrado sea el correcto
            assertNotNull(foundUsuario);
            assertEquals("findUser", foundUsuario.getNombreUsuario());
        }
    }
}