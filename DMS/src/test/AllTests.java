package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDatabase.class, TestDorm.class, TestEmergencyContact.class,
		TestRoom.class, TestSchool.class, TestStudent.class })
public class AllTests {

}
