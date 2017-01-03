

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dts.tpo.dao.CompanyDAO;
import com.dts.tpo.dao.TrainingDAO;
import com.dts.tpo.model.Company_Details;
import com.dts.tpo.model.Training_Details;

public class CompaniesTest {

	int companyId;
	static String companyName;
	static String profile;
	static String street;
	static String city;
	static String state;
	static String country;
	static String phone;
	static String email;

	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("Before all test case execution");
		companyName = "Trinity";
		profile = "good";
		street = "begumpet";
		city = "hyd";
		state = "telangana";
		country = "india";
		phone = "1223456";
		email = "jaffa@gmail.com";
	}

	public void testAddCompany() {
		try {
			Company_Details aCompany = new Company_Details();
			aCompany.setCompanyName(companyName);
			aCompany.setProfile(profile);
			aCompany.setStreet(street);
			aCompany.setCity(city);
			aCompany.setState(state);
			aCompany.setCountry(country);
			aCompany.setPhone(phone);
			aCompany.setEmail(email);
			
			companyId = new CompanyDAO().addCompany(aCompany);
			System.out.println("CompanyTest.testAddCompany(companyId) : "
					+ companyId);
			assertTrue(companyId > -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectCompany() {
		try {
			Company_Details acompany = new CompanyDAO()
					.getCompanyDetails(companyId);

			int companyIdFromDB = acompany.getCompanyId();
			String companyNameFromDB = acompany.getCompanyName();
			String profileFromDB = acompany.getProfile();
			String streetFromDB = acompany.getStreet();
			String cityFromDB = acompany.getCity();
			String stateFromDB = acompany.getState();
			String countryFromDB = acompany.getCountry();
			String phoneFromDB = acompany.getPhone();
			String emailFromDB = acompany.getEmail();

			assertTrue(companyId == companyIdFromDB);
			assertTrue(companyNameFromDB == companyName);
			assertTrue(profileFromDB == profile);
			assertTrue(streetFromDB == street);
			assertTrue(cityFromDB == city);
			assertTrue(stateFromDB == state);
			assertTrue(countryFromDB == country);
			assertTrue(phoneFromDB == phone);
			assertTrue(emailFromDB == email);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testDeleteCompany() {
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.deleteCompany(companyId);
		System.out.println("CompaniesTest.testDeleteCompany(DELETED) : " + companyId);
	}

	

	@AfterClass
	public static void oneTimeTearDown() {
		System.out.println("After all test case execution");
	}
}