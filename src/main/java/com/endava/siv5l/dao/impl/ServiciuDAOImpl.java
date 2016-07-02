package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.ServiciuDAO;
import com.endava.siv5l.model.Serviciu;
import com.endava.siv5l.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siv5l on 6/4/16.
 */
@Repository
public class ServiciuDAOImpl implements ServiciuDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Serviciu serviciu) {
        sessionFactory.getCurrentSession().save(serviciu);
    }

    @Override
    public void edit(Serviciu serviciu) {
        sessionFactory.getCurrentSession().update(serviciu);
    }

    @Override
    public void delete(long serviciuId) {
        sessionFactory.getCurrentSession().delete(getServiciu(serviciuId));
    }

    @Override
    public Serviciu getServiciu(long serviciuId) {
        return (Serviciu) sessionFactory.getCurrentSession().get(Serviciu.class, serviciuId);
    }

    @Override
    public List<Serviciu> getAllServicii() {
        return sessionFactory.getCurrentSession().createQuery("from Serviciu").list();
    }
}
