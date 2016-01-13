import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import spark.jobserver.SparkJobClient;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class SparkJobClientTests {
    private String baseUrl = "http://182.192.71.235:9090/";
    private final String defaultApp = "DataProcess";
    private SparkJobClient sparkJobClient = new SparkJobClient(baseUrl, defaultApp);

    @Test
    public void checkDefaultContext() {
        String contextList = sparkJobClient.listContexts();
        assertEquals("[\"brightics\"]", contextList);
    }

    @Test
    public void testExecuteJob() {
        String parameters = "sparkSqlTableSchema = \"(jobid string, line int, message string)\"\n" +
                "hbaseTable = \"GLOBALERROR\"\n" +
                "hbaseTableSchema = \"(Text:jobid, Text:line, Text:message)\"\n" +
                "sparkTable = \"HBASE_RDD\"";
        String result = sparkJobClient.executeJob("brightics", "DataProcess", "com.samsung.sds.brightics.dataprocess.HbaseLoad", parameters);
        System.out.println(JsonPath.read(result, "$"));
        assertEquals("OK", JsonPath.read(result, "$.status"));
    }

    @Test
    public void testExecuteSQL() {
        String sql = "select * from hbase_rdd";
        String result = sparkJobClient.executeSql("brightics", sql, 100, true);
        System.out.println(JsonPath.read(result, "$.result")); //SQL실행결과의 첫 줄은 컬럼명, 나머지는 data
        assertEquals("OK", JsonPath.read(result, "$.status"));
    }
}