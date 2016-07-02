package com.endava.siv5l.dao;

import com.endava.siv5l.model.Serviciu;

import java.util.List;

/**
 * Created by siv5l on 6/4/16.
 */
public interface ServiciuDAO {
    public void add(Serviciu serviciu);
    public void edit(Serviciu serviciu);
    public void delete(long serviciuId);
    public Serviciu getServiciu(long serviciuId);
    public List getAllServicii();
}
