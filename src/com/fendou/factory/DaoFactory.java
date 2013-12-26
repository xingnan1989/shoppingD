package com.fendou.factory;

import java.io.IOException;
import java.util.Properties;
import com.fendou.order.dao.*;
public class DaoFactory {
	private DaoFactory(){}
	private static DaoFactory df=null;
	private static Properties p=null;
	public static synchronized DaoFactory getfactory(){
		if(df==null){
			df=new DaoFactory();
		}
		return df;
	}
	static{
		p=new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Dao.properties"));
			//p.load(Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("Dao.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getDaoImpl(String key){
		String dao=p.getProperty(key);
		Object obj=null;
		try {
			obj=Class.forName(dao).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
