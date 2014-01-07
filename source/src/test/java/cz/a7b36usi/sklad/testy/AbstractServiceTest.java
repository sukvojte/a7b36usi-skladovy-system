package cz.a7b36usi.sklad.testy;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Lukas L.
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:applicationContext.xml" })
@TransactionConfiguration(defaultRollback = false, transactionManager = "txManager")
@Transactional
// extend the transactions to whole tests in order to rollback the tests
public abstract class AbstractServiceTest {

	public AbstractServiceTest() {
	}

}
