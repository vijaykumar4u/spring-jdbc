import java.beans.PropertyVetoException;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceDemo {
	public static void main(String[] args) throws SQLException, PropertyVetoException {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		basicDataSource.setUsername("Vijay_kumar");
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setPassword("seetamma");
		System.out.println("Basic Data Source:" + basicDataSource.getConnection());

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		comboPooledDataSource.setUser("Vijay_kumar");
		comboPooledDataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		comboPooledDataSource.setPassword("seetamma");
		System.out.println("Combo pooldataSource:" + comboPooledDataSource);
	}

}
