package miw.entitiesDao;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import miw.daos.CarDao;
import miw.daos.DriverDao;
import miw.entities.Car;
import miw.entities.Driver;
import miw.entities.Level;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class DriverDaoIT {

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CarDao carDao;

	@Before
	public void seedDb() {
		// seedCars
		String[] listModels = { "Megane", "Clio", "Kangoo", "Scenic", "Talisman", "Express", "Laguna", "Megane",
				"Megane" };
		String[] listRegistration = { "1184CPL", "2345BDC", "1145ACC", "2565XCC", "2311RTC", "0045PPC", "0450WRC",
				"1185CPL", "1186CPL" };
		List<Car> listCars = new LinkedList<Car>();
		for (int i = 0; i < listModels.length; i++) {
			Car car = new Car();
			car.setModel(listModels[i]);
			car.setRegistration(listRegistration[i]);
			listCars.add(car);
		}
		this.carDao.save(listCars);
		// seedDrivers
		String[] listNames = { "Alberto", "Juan", "Pepe", "Manolo", "Nerea", "Marta", "Candelaria", "Marina", "Mamen" };
		long[] listPhones = { 605124985, 665128985, 623126785, 715155985, 765724185, 605444985, 699924985, 765726185,
				605644985 };
		String[] listReferences = { "1184XA", "2345XA", "1145XA", "2565XA", "2311XC", "0045XC", "0450XC", "1550XC",
				"1770XC" };
		List<Driver> listDrivers = new LinkedList<Driver>();
		for (int i = 0; i < listPhones.length; i++) {
			Driver driver = new Driver();
			driver.setName(listNames[i]);
			driver.setPhone(listPhones[i]);
			driver.setReference(listReferences[i]);
			driver.setCar(listCars.get(i));
			driver.setLevel(Level.NORMAL);
			listDrivers.add(driver);
		}
		this.driverDao.save(listDrivers);
	}

	@Test
	public void testCount() {
		assertEquals(9, driverDao.count());
	}

	@Test
	public void testFindOne() {
		Driver driver = new Driver();
		driver.setName("Manuel");
		driver.setPhone(665128775);
		driver.setReference("1994XE");
		driver.setCar(this.carDao.findOne(1));
		driver.setLevel(Level.EXPERT);
		this.driverDao.save(driver);
		assertEquals(driver, driverDao.findOne(driver.getId()));
	}

	@Test
	public void testDelete() {
		Driver driver = new Driver();
		driver.setName("Federico");
		driver.setPhone(699128995);
		driver.setReference("1988SE");
		driver.setCar(this.carDao.findOne(1));
		driver.setLevel(Level.BEGINNER);
		this.driverDao.save(driver);
		this.driverDao.delete(driver);
		assertNull(this.carDao.findOne(driver.getId()));
	}

	@Test
	public void testFindByCarModel() {
		assertEquals(3, this.driverDao.findByCarModel("Megane").size());
	}

	@After
	public void deleteDb() {
		this.driverDao.deleteAll();
		this.carDao.deleteAll();
	}

}
