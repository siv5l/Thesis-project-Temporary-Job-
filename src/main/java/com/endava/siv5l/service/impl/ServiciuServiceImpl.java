package com.endava.siv5l.service.impl;

import com.endava.siv5l.dao.ServiciuDAO;
import com.endava.siv5l.model.Serviciu;
import com.endava.siv5l.service.ServiciuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siv5l on 6/4/16.
 */
@Service
public class ServiciuServiceImpl implements ServiciuService {
    @Autowired
    private ServiciuDAO serviciuDAO;

    @Transactional
    public void add(Serviciu serviciu) {
        serviciuDAO.add(serviciu);
    }

    @Transactional
    public void edit(Serviciu serviciu) {
        serviciuDAO.edit(serviciu);
    }

    @Transactional
    public void delete(long serviciuId) {
        serviciuDAO.delete(serviciuId);
    }

    @Transactional
    public Serviciu getServiciu(long serviciuId) {
        return serviciuDAO.getServiciu(serviciuId);
    }

    @Transactional
    public List getAllServicii() {
        return serviciuDAO.getAllServicii();
    }
}
