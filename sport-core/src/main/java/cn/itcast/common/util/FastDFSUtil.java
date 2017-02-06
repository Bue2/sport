package cn.itcast.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class FastDFSUtil {

	/**
	 * 上传图片到分布式文件系统
	 * @throws Exception 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	
	public static String uploadPic(MultipartFile pic) throws FileNotFoundException, IOException, Exception{
		
		//Sping提供 获取classPath 下的文件路径,读取配置
		ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
		ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
		
		//tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		//与Tracker连接
		TrackerServer trackerServer = trackerClient.getConnection();

		//创建Stager的服务端
		StorageServer storageServer = null;
		//创建Stager的客户端
		StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
		String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
		NameValuePair[] meta_list = new NameValuePair[3];
	
		//图片原始名
		meta_list[0] = new NameValuePair("filename",pic.getOriginalFilename());
		//图片大小
		meta_list[1] = new NameValuePair("filelength",String.valueOf(pic.getSize()));
		//图片扩展名
		meta_list[2] = new NameValuePair("ext",extension);
		
		//上传图片
		//http://192.168.200.128/group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
		String path = storageClient1.upload_file1(pic.getBytes(), extension, meta_list);
		
		return path;
	}
}
