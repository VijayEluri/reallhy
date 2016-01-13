import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class HdfsService {
    public static void main(String... args) throws IOException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path inFile = new Path(args[0]);
        FileStatus[] fileStatuses = fs.listStatus(inFile);
        for(FileStatus status : fileStatuses){
            System.out.println(status.getPath().getName());
        }
    }
}
