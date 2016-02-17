package com.louisamoros.cdb.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.louisamoros.cdb.dao.exception.DAOMapperException;
import com.louisamoros.cdb.model.Company;

/**
 * Mapper class with static method use to convert ResultSet to List for <Company> object model.
 * 
 * @author louis
 *
 */
public class MapperCompany {

	/**
	 * Convert ResultSet to List<Company> based on <Company> model.
	 * 
	 * @param ResultSet<Company>
	 * @return List<Company>
	 */
	public static List<Company> toList(ResultSet rs) throws DAOMapperException {
		List<Company> companies = new ArrayList<Company>();
		try {
			while (rs.next()) {
				Company company = new Company(rs.getInt("id"), rs.getString("name"));
				companies.add(company);
			}
		} catch (SQLException e) {
			throw new DAOMapperException("Fail to map ResultSet of Company to List of Company.", e);
		}
		return companies;
	}

}
