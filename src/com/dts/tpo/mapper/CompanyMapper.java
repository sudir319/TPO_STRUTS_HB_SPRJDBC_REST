package com.dts.tpo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dts.tpo.model.Company_Details;

public class CompanyMapper implements RowMapper<Company_Details>
{

	@Override
	public Company_Details mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		
		Company_Details company = new Company_Details();
		company.setCompanyId(resultSet.getInt("companyId"));
		company.setCompanyName(resultSet.getString("companyName"));
		company.setProfile(resultSet.getString("profile"));
		company.setStreet(resultSet.getString("street"));
		company.setCity(resultSet.getString("city"));
		company.setState(resultSet.getString("state"));
		company.setCountry(resultSet.getString("country"));
		company.setPhone(resultSet.getString("phone"));
		company.setEmail(resultSet.getString("email"));
		
		return company;
	}
	
}
