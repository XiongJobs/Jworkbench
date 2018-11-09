package spring.demo.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImple1 extends JdbcDaoSupport implements AccountDao {

	@Override
	public void outMoney(String out, Double money) {
		String sql="update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(sql,money,out);
	}

	@Override
	public void inMoney(String in, Double money) {
		String sql="update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql,money,in);
		
	}

}
