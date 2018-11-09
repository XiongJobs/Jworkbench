package spring.demo.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import spring.demo.dao.AccountDao;

@Transactional
public class AccountServiceImple1 implements AccountService{
	
	private AccountDao accountDao;
//	private TransactionTemplate transactionTemplate;  //注入事务管理模板(用于编程式的事务管理)
	
	
	@Override
	public void transfer(String out,String in,Double money) {
		accountDao.outMoney(out, money);
		accountDao.inMoney(in, money);		
		
		//用编程式事务管理方式进行转账
		/*transactionTemplate.execute(new TransactionCallbackWithoutResult(){			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				accountDao.outMoney(out, money);
				accountDao.inMoney(in, money);
			}
		});*/
		
		
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

/*	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}*/
	
	
}
