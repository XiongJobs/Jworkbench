package spring.demo.service;

public interface AccountService {
	
	
	//out 输出金额账号，in 输入金额账号 ，money 转账金额
	public void transfer(String out,String in,Double money);
}
