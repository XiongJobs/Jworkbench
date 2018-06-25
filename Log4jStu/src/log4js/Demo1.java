package log4js;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Demo1 {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Demo1.class);
        
        //ʹ��Ĭ�ϵ�������Ϣ������Ҫдlog4j.properties
        BasicConfigurator.configure();
        
        //������־�������Ϊinfo���⽫���������ļ������õļ���
        logger.setLevel(Level.INFO);
        
        logger.debug("this is debug");
        
        //�������Ϣ�������
        logger.info("this is an info");
        logger.warn("this is a warn");
        logger.error("this is an error");
        logger.fatal("this is a fatal");

	}

}
