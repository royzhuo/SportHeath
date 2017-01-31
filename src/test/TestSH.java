import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author roy.zhuo
 */
public class TestSH {

    private ApplicationContext applicationContext = null;
    private DataSource dataSource;

    {
        applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        dataSource=applicationContext.getBean(DataSource.class);
    }
    @Test
    public void testConnection(){
        try {
            System.out.println("connection:"+dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
