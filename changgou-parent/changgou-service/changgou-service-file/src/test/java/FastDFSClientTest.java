import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhaowuting
 * @date 2022-03-02 20:35
 */
public class FastDFSClientTest {


    /**
     * 文件上传
     */
    @Test
    public void upload() throws Exception
    {
        String path = new ClassPathResource("fdfs_client.conf").getPath();
        //加载全局的配置文件
        ClientGlobal.init(path);

        //创建TrackerClient客户端对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient对象获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取StorageClient对象
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //执行文件上传
        String[] jpgs = storageClient.upload_file("D:\\Deskt\\onloadImage\\aa56bd43f2c146b9835b6140f0e5196cOIP-C.jpg","jpg",null);

        for (String jpg : jpgs)
        {
            System.out.println(jpg);
        }
    }
}
