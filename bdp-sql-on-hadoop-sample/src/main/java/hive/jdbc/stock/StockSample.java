package hive.jdbc.stock;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class StockSample {
    JdbcTemplate jdbcTemplate;

    public StockSample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void run() {
        /*String dropSql = "drop table if exists stock";
        jdbcTemplate.execute(dropSql);

        String createSql =
                "CREATE EXTERNAL TABLE IF NOT EXISTS stock(\n" +
                        "stock_exchange string, \n" +
                        "stock_symbol string, \n" +
                        "date string, \n" +
                        "stock_price_open double, \n" +
                        "stock_price_high double, \n" +
                        "stock_price_low double, \n" +
                        "stock_price_close double, \n" +
                        "stock_volume bigint, \n" +
                        "stock_price_adj_close double)\n" +
                        "COMMENT 'NYSE stock table'\n" +
                        "ROW FORMAT DELIMITED FIELDS TERMINATED BY '\\t' \n" +
                        "STORED AS TEXTFILE \n" +
                        "LOCATION '/user/hadoop/stock/'";
        System.out.println(createSql);
        jdbcTemplate.execute(createSql);

        List<Map<String, Object>> result = jdbcTemplate.queryForList("desc stock");
        System.out.println(result.get(0).keySet());
        result.forEach(map -> {
            System.out.println(map.values());
        });*/

        long start = System.currentTimeMillis();
        String mapSql = "select stock_exchange, stock_symbol, count(0) count, avg(stock_price_open) open_avg, min(stock_volume) min_volume " +
                "from stock " +
                "where date >= ? " +
                "group by stock_exchange, stock_symbol order by stock_symbol asc";
        System.out.println(mapSql);

        List<Map<String, Object>> list = jdbcTemplate.queryForList(mapSql, new Object[]{"2001-01-01"});
        for (Map<String, Object> map : list) {
			System.out.println(map);
		}
        System.out.println((System.currentTimeMillis() - start) + "ms");

    }


    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(StockSample.class.getResourceAsStream("/jdbc.properties"));

        Driver driver = (Driver) Class.forName((String) prop.get("driver")).newInstance();
        String url = (String) prop.get("url");
        String username = (String) prop.get("username");
        String password = (String) prop.get("password");

        DataSource dataSource = new SimpleDriverDataSource(driver, url, username, password);
        new StockSample(new JdbcTemplate(dataSource)).run();
    }
}