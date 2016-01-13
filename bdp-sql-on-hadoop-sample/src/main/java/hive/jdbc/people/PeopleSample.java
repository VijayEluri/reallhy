package hive.jdbc.people;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PeopleSample {
    JdbcTemplate jdbcTemplate;

    public PeopleSample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void run() {
        String dropSql = "drop table if exists people";
        jdbcTemplate.execute(dropSql);

        String createSql =
                "CREATE EXTERNAL TABLE IF NOT EXISTS people(\n" +
                        "no int, \n" +
                        "name string, \n" +
                        "age int, \n" +
                        "salary double, \n" +
                        "birthday timestamp, \n" +
                        "address string, \n" +
                        "description string)\n" +
                        "ROW FORMAT DELIMITED\n" +
                        "   FIELDS TERMINATED BY ','\n" +
                        "LOCATION '/user/hadoop/people'";
        jdbcTemplate.execute(createSql);

        List<Map<String, Object>> result = jdbcTemplate.queryForList("describe people");
        result.forEach(map -> {
            System.out.println(map.values());
        });

//        String loadData = "load data local inpath '/home/hadoop/Downloads/input.txt' into table people";
//        jdbcTemplate.execute(loadData);

        long start = System.currentTimeMillis();
        String mapSql = "select birthday, max(name) max_name, count(0) count, avg(age) avg_age, min(salary) min_salary " +
                "from people " +
                "where name >= 'name_0' " +
                "group by birthday " +
                "order by birthday ";
//                "limit 1000 ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(mapSql);
        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(list.size());
    }


    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(PeopleSample.class.getResourceAsStream("/jdbc.properties"));

        Driver driver = (Driver) Class.forName((String) prop.get("driver")).newInstance();
        String url = (String) prop.get("url");
        String username = (String) prop.get("username");
        String password = (String) prop.get("password");

        DataSource dataSource = new SimpleDriverDataSource(driver, url, username, password);
        new PeopleSample(new JdbcTemplate(dataSource)).run();
    }
}