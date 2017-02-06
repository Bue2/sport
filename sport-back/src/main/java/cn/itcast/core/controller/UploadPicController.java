package cn.itcast.core.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.common.util.FastDFSUtil;
import cn.itcast.common.web.Constants;

/**
 * 上传图片
 * @author Administrator
 *
 */
@Controller
public class UploadPicController {

	/**
	 * 上传图片
	 * @throws Exception 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam MultipartFile pic, HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException, Exception{
		
		//fastDFSUtil上传图片 
		// group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
		String path = FastDFSUtil.uploadPic(pic);
		
		//显示图片url
		String url = Constants.IMG_URL + path;
		
		//json对象
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("path", path);
		jsonObject.put("url", url);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonObject.toString());
		
	}
}
