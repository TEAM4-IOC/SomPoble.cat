package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.transaction.Transactional;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sompoble.cat.repository.ClienteRepository;

@Repository
@Transactional
public class ClienteHibernate implements ClienteRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCliente(Cliente cliente) {
        getSession().save(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        getSession().merge(cliente);
    }

    @Override
    public Cliente findByDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (Cliente) criteria.uniqueResult(); 
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession(); 
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Cliente.class);  
    }
}
