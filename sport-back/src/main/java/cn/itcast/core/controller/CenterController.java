package cn.itcast.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author Buer E-mail:
* @version 创建时间：2017年1月18日 下午2:57:15
* 类说明:
*/
@Controller
public class CenterController {

	/**
	 * 入口页面
	 * @return
	 */
	@RequestMapping(value="/index.do")
	public String index(){
		return "index";
	}
	
	//top
		@RequestMapping(value = "/top.do")
		public String top(){
			
			return "top";
		}
		//main
		@RequestMapping(value = "/main.do")
		public String main(){
			
			return "main";
		}
		//left
		@RequestMapping(value = "/left.do")
		public String left(){
			
			return "left";
		}
		//right
		@RequestMapping(value = "/right.do")
		public String right(){
			
			return "right";
		}
}
