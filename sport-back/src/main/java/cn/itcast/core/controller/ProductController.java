package cn.itcast.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author Buer E-mail:
* @version 创建时间：2017年1月18日 下午2:57:15
* 类说明:
*/
@Controller
public class ProductController {

	/**
	 * 商品入口页面
	 * @return
	 */
	@RequestMapping(value="/frame/product_main.do")
	public String index(){
		return "frame/product_main";
	}
	
	/**
	 * 商品左侧菜单页面
	 * @return
	 */
	@RequestMapping(value="/frame/product_left.do")
	public String left(){
		return "frame/product_left";
	}
	
	/**
	 * 商品列表页面
	 * @return
	 */
	@RequestMapping(value="/product/list.do")
	public String list(){
		return "product/list";
	}
}
