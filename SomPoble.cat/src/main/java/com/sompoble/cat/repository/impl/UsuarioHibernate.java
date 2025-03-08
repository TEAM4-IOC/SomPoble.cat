package com.sompoble.cat.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.transaction.Transactional;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sompoble.cat.domain.Usuario;
import com.sompoble.cat.repository.UsuarioRepository;

@Repository
@Transactional
public class UsuarioHibernate implements UsuarioRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUsuario(Usuario usuario) {
        getSession().save(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        getSession().merge(usuario);
    }

    @Override
    public Usuario findByNombreUsuario(String nombreUsuario) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
        return (Usuario) criteria.uniqueResult(); 
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession(); 
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Usuario.class);  
    }
}
