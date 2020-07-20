package kosmo.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sun.el.parser.ParseException;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {
	
	@Autowired
	DataSource dataSource = null;
	
	@Bean
    public PlatformTransactionManager transactionManager() 
    		throws URISyntaxException, GeneralSecurityException, ParseException, IOException {
        return new DataSourceTransactionManager(dataSource);
    }
}
