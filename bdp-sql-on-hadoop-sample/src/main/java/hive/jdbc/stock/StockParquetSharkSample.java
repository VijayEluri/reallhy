package hive.jdbc.stock;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class StockParquetSharkSample {
    JdbcTemplate jdbcTemplate;

    public StockParquetSharkSample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void run() {
        String dropSql = "drop table if exists stock";
        String dropParquetSql = "drop table if exists stock_parquet";
        jdbcTemplate.execute(dropSql);
        jdbcTemplate.execute(dropParquetSql);

        String createStockSql =
                "CREATE TABLE IF NOT EXISTS stock(\n" +
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
                        "ROW FORMAT DELIMITED\n" +
                        "   FIELDS TERMINATED BY '\\t'";
        jdbcTemplate.execute(createStockSql);

        String loadData = "load data local inpath '/home/hadoop/Downloads/NYSE-2000-2001.tsv' into table stock";
        jdbcTemplate.execute(loadData);

        String parquetSql =
                "create table stock_parquet (\n" +
                        "stock_exchange string, \n" +
                        "stock_symbol string, \n" +
                        "date string, \n" +
                        "stock_price_open double, \n" +
                        "stock_price_high double, \n" +
                        "stock_price_low double, \n" +
                        "stock_price_close double, \n" +
                        "stock_volume bigint, \n" +
                        "stock_price_adj_close double)\n" +
                        "ROW FORMAT SERDE 'parquet.hive.serde.ParquetHiveSerDe'\n" +
                        " STORED AS\n" +
                        " INPUTFORMAT 'parquet.hive.DeprecatedParquetInputFormat'\n" +
                        " OUTPUTFORMAT 'parquet.hive.DeprecatedParquetOutputFormat'";
        String loadToParquetTable = "insert overwrite table stock_parquet select * from stock";
        jdbcTemplate.execute(parquetSql);
        jdbcTemplate.execute(loadToParquetTable);

        long start = System.currentTimeMillis();
        String mapSql = "select stock_exchange, stock_symbol, count(0) count, avg(stock_price_open) open_avg, min(stock_volume) min_volume " +
                "from stock_parquet " +
                "where date >= '2001-12-01' " +
                "group by stock_exchange, stock_symbol order by stock_symbol asc";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(mapSql);
        list.forEach(row -> System.out.println(row));
        System.out.println(mapSql);
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }


    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(StockParquetSharkSample.class.getResourceAsStream("/jdbc.properties"));

        Driver driver = (Driver) Class.forName((String) prop.get("driver")).newInstance();
        String url = (String) prop.get("url");
        String username = (String) prop.get("username");
        String password = (String) prop.get("password");

        DataSource dataSource = new SimpleDriverDataSource(driver, url, username, password);
        new StockParquetSharkSample(new JdbcTemplate(dataSource)).run();
    }
}