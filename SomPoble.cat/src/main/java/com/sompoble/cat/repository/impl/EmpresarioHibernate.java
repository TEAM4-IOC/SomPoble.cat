package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.repository.EmpresarioRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.transaction.Transactional;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class EmpresarioHibernate implements EmpresarioRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEmpresario(Empresario empresario) {
        getSession().save(empresario);
    }

    @Override
    public void updateEmpresario(Empresario empresario) {
        getSession().merge(empresario);
    }

    @Override
    public Empresario findByDNI(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (Empresario) criteria.uniqueResult(); 
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession(); 
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Empresario.class);  
    }
}
