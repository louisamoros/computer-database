package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.CompanyRepository;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.QCompany;
import com.louisamoros.cdb.service.CompanyService;
import com.mysema.query.types.expr.BooleanExpression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Spring service using transactional in some request.
 */
@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Autowired spring injection of company dao.
     */
    @Autowired
    private CompanyDao companyDao;

    /**
     * Autowired spring injection of computer dao.
     */
    @Autowired
    private ComputerDao computerDao;

    @Override
    public final List<Company> getAll() {
        QCompany company = QCompany.company;
        BooleanExpression customerHasBirthday = company.companyName.eq("Netronics");
        return (List<Company>) companyRepository.findAll(customerHasBirthday);
    }

    @Override
    @Transactional
    public final void delete(final int companyId) {
        computerDao.deleteByCompanyId(companyId);
        companyDao.delete(companyId);
    }

}
