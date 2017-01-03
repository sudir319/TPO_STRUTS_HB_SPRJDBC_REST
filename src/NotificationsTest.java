import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dts.core.util.DateWrapper;
import com.dts.tpo.dao.NotificationDAO;
import com.dts.tpo.model.Notification_Details;


public class NotificationsTest {

	int notificationId;
	static int companyId;
	static String noofvac;
	static String jobdesc;
	static String category;
	static String location;
	static String skills;
	static String createddate;
	static String expirydate;
	static String designation;
	static String status;

	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("Before all test case execution");
		companyId = 2;
		noofvac = "122";
		jobdesc = "good";
		category = "ERP";
		location = "nkp";
		skills = "JUNIT";
		createddate = "21-8-2015";
		expirydate = "25-8-2015";
		designation = "sr.tester";
		status = "Process";
	}

	@Test
	public void testAddNotification() {
		try {
			Notification_Details aNoification = new Notification_Details();
			aNoification.setCompanyID(companyId);
			aNoification.setNoofvac(noofvac);
			aNoification.setJobdesc(jobdesc);
			aNoification.setCategory(category);
			aNoification.setLocation(location);
			aNoification.setSkills(skills);
			aNoification.setCreateddate(DateWrapper.getSqlDate(createddate));
			aNoification.setExpirydate(DateWrapper.getSqlDate(expirydate));
			aNoification.setDesignation(designation);
			aNoification.setStatus(status);
			notificationId = new NotificationDAO().addNotification(aNoification);
			System.out.println("NOtificationsTest.testAddNotification(notificationId) : "
					+ notificationId);
			assertTrue(notificationId > -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectNotification() {
		try {
			Notification_Details aNotification = new NotificationDAO()
					.getNotifications(notificationId);

			int notificationIdFromDB = aNotification.getNotificationID();
			int companyIdFromDB = aNotification.getCompanyID();
			String noofvacFromDB = aNotification.getNoofvac();
			String jobdescFromDB = aNotification.getJobdesc();
			String categoryFromDB = aNotification.getCategory();
			String locationFromDB = aNotification.getLocation();
			String skillsFromDB = aNotification.getSkills();
			String createddateFromDB = aNotification.getCreateddate().toString();
			String expirydateFromDB = aNotification.getExpirydate().toString();
			String designationFromDB = aNotification.getDesignation();
			String statusFromDB = aNotification.getStatus();

			assertTrue(notificationId == notificationIdFromDB);
			assertTrue(companyIdFromDB == companyId);
			assertTrue(noofvacFromDB == noofvac);
			assertTrue(jobdescFromDB == jobdesc);
			assertTrue(categoryFromDB == category);
			assertTrue(locationFromDB == location);
			assertTrue(skillsFromDB == skills);
			assertTrue(createddateFromDB == createddate);
			assertTrue(expirydateFromDB == expirydate);
			assertTrue(designationFromDB == designation);
			assertTrue(statusFromDB == status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void testDeleteNotification() {
		NotificationDAO notificationDAO = new NotificationDAO();
		notificationDAO.deleteNotification(notificationId);
		System.out.println("NotificationsTest.testDeleteNotification(DELETED) : " + notificationId);
	}

	

	@AfterClass
	public static void oneTimeTearDown() {
		System.out.println("After all test case execution");
	}
}