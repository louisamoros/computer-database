package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dmo.ComputerDmo;
import com.louisamoros.cdb.dmo.QComputerDmo;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Computer dao implementation.
 */
public class ComputerDaoImpl implements ComputerDao {

    private static QComputerDmo computerDmo = QComputerDmo.computerDmo;
    private static JPAQuery query;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public final List<ComputerDmo> findAll() {
        query = new JPAQuery(entityManager);
        List<ComputerDmo> computers = query.from(computerDmo).list(computerDmo);
        return computers;
    }

    @Override
    public final ComputerDmo create(ComputerDmo computerDmo) {
        ComputerDmo computer = entityManager.persist(computerDmo);
        return null;
    }

    @Override
    public final void delete(long id) {

    }

    @Override
    public final ComputerDmo findOne(long id) {
        return null;
    }

    @Override
    public final Page<ComputerDmo> findAll(String search, Pageable pageRequest) {
        return null;
    }

}
