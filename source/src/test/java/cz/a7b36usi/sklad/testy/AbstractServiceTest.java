
package cz.a7b36usi.sklad.testy;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas L.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"/applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
@Transactional // extend the transactions to whole tests in order to rollback the tests
public abstract class AbstractServiceTest {

	//TODO: vytvoreni uzivatele a ten vytvori event a prida do nej terminy a prida do nej akceptanta - uzivatel, prida do eventu jinej termin a prvni zmeni status
	public AbstractServiceTest() {
	}

}
