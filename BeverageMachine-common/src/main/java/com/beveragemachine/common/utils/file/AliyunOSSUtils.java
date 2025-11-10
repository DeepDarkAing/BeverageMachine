package com.beveragemachine.common.utils.file;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class AliyunOSSUtils {

    public String uploadFile(String fileName, String filePath) throws Exception {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "deepdarksky";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "beveragemachine/" + fileName;
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        //String filePath= filePath;
        // 填写Bucket所在地域。以华东1（杭州）为例，Region填写为cn-shanghai。
        String region = "cn-shanghai";

        // 创建OSSClient实例。
        // 当OSSClient实例不再使用时，调用shutdown方法以释放资源。
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();

        try {
            InputStream inputStream = new FileInputStream(filePath);
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return "https://deepdarksky.oss-cn-shanghai.aliyuncs.com/" + objectName;
    }

    // 将相对路径转换为绝对路径
    public String convertToAbsolutePath(String relativePath) {
        // 定义基础路径
        String basePath = "D:/ruoyi/uploadPath"; // 使用正斜杠，Paths 会自动处理

        // 移除 "/profile" 前缀
        String cleanPath = relativePath.replace("/profile", "");

        // 构建路径
        Path fullPath = Paths.get(basePath, cleanPath.substring(1)); // substring(1) 移除开头的 "/"

        return fullPath.toString();
    }

    /**
     * 删除本地文件
     *
     * @param localFilePath 本地文件路径
     * @return 是否删除成功
     */
    public boolean deleteLocalFile(String localFilePath) {
        if (localFilePath == null || localFilePath.isEmpty()) {
            return false;
        }

        try {
            File file = new File(localFilePath);
            if (file.exists()) {
                return file.delete();
            }
            return true; // 文件不存在也认为是"删除成功"
        } catch (Exception e) {
            System.err.println("删除本地文件失败: " + localFilePath + ", 错误: " + e.getMessage());
            return false;
        }
    }

}