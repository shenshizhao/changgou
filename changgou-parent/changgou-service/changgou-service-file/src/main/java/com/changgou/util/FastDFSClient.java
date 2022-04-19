package com.changgou.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhaowuting
 * @date 2022-03-03 10:01
 */
public class FastDFSClient {


    /**
     * 初始化tracker信息
     */
    static {
        try {
            //获取tracker的配置文件fdfs_client.conf的位置
            String filePath = new ClassPathResource("fdfs_client.conf").getPath();
            //加载tracker配置信息
            ClientGlobal.init(filePath);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * 文件上传
     * @param file (要上传的文件信息封装在 file)
     * @return String[] (1.文件上传所存储的组名
     *                   2.文件存储路径
     *                   )
     */
    public static String[] upload(FastDFSFile file) throws Exception
    {
        //获取文件作者(附加参数)
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("作者",file.getAuthor());

        //创建一个tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();

        //通过TrackerClient访问TrackerServer服务，获取连接信息
        TrackerServer trackerServer = trackerClient.getConnection();

        //通过TrackerServer的连接信息可以获取Storage的连接信息，创建StorageClient对象来存储Storage的连接信息
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //通过StorageClient访问Storage，实现文件上传，并且获取文件上传后的存储信息
        String[] uploadFile = storageClient.upload_file(
                file.getContent(),      //参数：1.上传文件的字节数组
                file.getExt(),          //     2.文件的扩展名
                meta_list               //     3.附加参数（作者..）
        );
        System.out.println(uploadFile);
        return uploadFile;
    }
}
