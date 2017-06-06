import com.beStrong.dao.LocationDao;
import com.beStrong.dao.SportDao;
import com.beStrong.dao.UserDao;
import com.beStrong.entity.Location;
import com.beStrong.entity.Sport;
import com.beStrong.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author roy.zhuo
 */
public class TestSport {

    private ApplicationContext applicationContext = null;
    private DataSource dataSource;
    private UserDao userDao;
    private SportDao sportDao;
    private LocationDao locationDao;

    {
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        dataSource = applicationContext.getBean(DataSource.class);
        userDao = applicationContext.getBean(UserDao.class);
        sportDao = applicationContext.getBean(SportDao.class);
        locationDao = applicationContext.getBean(LocationDao.class);
    }

    @Test
    public void addSport() {
        User user = userDao.findOne(1);

        Sport sport = new Sport();
        sport.setKaluli("ss");
        sport.setName("sss");
        sport.setCreateTime(new Date());

        Location location = new Location();
        location.setLocation("11111");
        location.setCreateTime(new Date());
        Location location1 = new Location();
        location1.setLocation("2222");
        location1.setCreateTime(new Date());

        List<Location> locations = new ArrayList<Location>();
        locations.add(location);
        locations.add(location1);

        List<Sport> sports = new ArrayList<Sport>();
        sports.add(sport);

        sport.setLocations(locations);
        user.setSports(sports);

        sportDao.save(sport);
        locationDao.save(location);
        locationDao.save(location1);
        userDao.saveAndFlush(user);
    }
}
