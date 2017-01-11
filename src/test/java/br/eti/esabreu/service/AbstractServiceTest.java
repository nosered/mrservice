package br.eti.esabreu.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

import br.eti.esabreu.MrserviceApplication;

@TestExecutionListeners({DbUnitTestExecutionListener.class})
@SpringBootTest(classes = MrserviceApplication.class)
public abstract class AbstractServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

}
