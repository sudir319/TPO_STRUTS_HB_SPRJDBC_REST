package com.dts.tpo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dts.tpo.model.Training_Details;

public class TrainingMapper implements RowMapper<Training_Details> 
{

	@Override
	public Training_Details mapRow(ResultSet resultSet, int rowNumber)
			throws SQLException {
		Training_Details training = new Training_Details();
		training.setTrainingId(resultSet.getInt("trainingId"));
		training.setTrainingName(resultSet.getString("trainingName"));
		training.setStart_date(resultSet.getDate("start_date"));
		training.setEnd_date(resultSet.getDate("end_date"));
		training.setStart_time(resultSet.getString("start_time"));
		training.setEnd_time(resultSet.getString("end_time"));
		training.setTrainingdesc(resultSet.getString("trainingdesc"));
		training.setStatus(resultSet.getString("status"));
		
		return training;
	}
	
}
