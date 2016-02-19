package com.louisamoros.cdb.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.louisamoros.cdb.dao.exception.DAOMapperException;
import com.louisamoros.cdb.model.Company;

/**
 * The Class MapperRsCompanyDao.
 */
public class MapperRsCompanyDao {

	/**
	 * To list.
	 *
	 * @param rs the rs
	 * @return the list
	 * @throws DAOMapperException the DAO mapper exception
	 */
	public static List<Company> toList(ResultSet rs) throws DAOMapperException {
		List<Company> companies = new ArrayList<Company>();
		try {
			while (rs.next()) {
				Company company = new Company.Builder().name(rs.getString("name")).id(rs.getInt("id")).build();
				companies.add(company);
			}
		} catch (SQLException e) {
			throw new DAOMapperException("Fail to map ResultSet of Company to List of Company.", e);
		}
		return companies;
	}

}
