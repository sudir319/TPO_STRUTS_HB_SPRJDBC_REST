import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dts.core.util.DateWrapper;
import com.dts.tpo.dao.TrainingDAO;
import com.dts.tpo.model.Training_Details;


public class TrainingsTest {

	int trainingId;
	static String trainingName;
	static String startDate;
	static String endDate;
	static String startTime;
	static String endTime;
	static String trainingDesc;
	static String status;

	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("Before all test case execution");
		trainingName = "Training Name1";
		startDate = "20-8-2015";
		endDate = "21-8-2015";
		startTime = "9AM";
		endTime = "10PM";
		trainingDesc = "Created by JUNIT";
		status = "Process";
	}

	@Test
	public void testAddTraining() {
		try {
			Training_Details aTraining = new Training_Details();
			aTraining.setTrainingName(trainingName);
			aTraining.setStart_date(DateWrapper.getSqlDate(startDate));
			aTraining.setEnd_date(DateWrapper.getSqlDate(endDate));
			aTraining.setStart_time(startTime);
			aTraining.setEnd_time(endTime);
			aTraining.setTrainingdesc(trainingDesc);
			aTraining.setStatus(status);
			trainingId = new TrainingDAO().addTraining(aTraining);
			System.out.println("TrainingsTest.testAddTraining(trainingId) : "
					+ trainingId);
			assertTrue(trainingId > -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectTraining() {
		try {
			Training_Details aTraining = new TrainingDAO()
					.getTraining(trainingId);

			int trainingIdFromDB = aTraining.getTrainingId();
			String trainingNameFromDB = aTraining.getTrainingName();
			String startDateFromDB = aTraining.getStart_date().toString();
			String endDateFromDB = aTraining.getEnd_date().toString();
			String startTimeFromDB = aTraining.getStart_time();
			String endTimeFromDB = aTraining.getEnd_time();
			String trainingDescFromDB = aTraining.getTrainingdesc();
			String statusFromDB = aTraining.getStatus();

			assertTrue(trainingId == trainingIdFromDB);
			assertTrue(trainingNameFromDB == trainingName);
			assertTrue(startDateFromDB == startDate);
			assertTrue(endDateFromDB == endDate);
			assertTrue(startTimeFromDB == startTime);
			assertTrue(endTimeFromDB == endTime);
			assertTrue(trainingDescFromDB == trainingDesc);
			assertTrue(statusFromDB == status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteTraining() {
		TrainingDAO trainingDAO = new TrainingDAO();
		trainingDAO.deleteTraining(trainingId);
		System.out.println("TrainingsTest.testDeleteTraining(DELETED) : " + trainingId);
	}

	

	@AfterClass
	public static void oneTimeTearDown() {
		System.out.println("After all test case execution");
	}
}