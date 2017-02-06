package cn.itcast.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;
import cn.itcast.core.bean.product.BrandQuery.Criteria;
import cn.itcast.core.service.product.BrandService;

/**
* @author Buer E-mail:
* @version 创建时间：2017年1月18日 下午2:57:15
* 类说明:
*/
@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;
	/**
	 * 品牌列表页面
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/brand/list.do")
	public String index(Integer pageNo, String name , Integer isDisplay , Model model){
		
		//创建品牌查询条件
		BrandQuery brandQ = new BrandQuery();
		//拼接条件
		StringBuilder params = new StringBuilder();
		
		//分页条件设置
		brandQ.setPageSize(3);
		brandQ.setPageNo(Pagination.cpn(pageNo));	//当前页为null或者小于1,则设置为1
		
		Criteria criteria = brandQ.createCriteria();
		//根据查询条件 name isDisplay,查询品牌列表
		if(null !=name && !("".equals(name.trim()))){	//trim:去掉name的前后空格
			criteria.andNameEqualTo(name);
			model.addAttribute("name",name);
		}else{
			criteria.andNameEqualTo(null);
		}
		if(null == isDisplay){
			isDisplay = 1;
		}
		model.addAttribute("isDisplay",isDisplay);
		criteria.andIsDisplayEqualTo(isDisplay==0?true:false);
		
		List<Brand> listBrandByQuery = brandService.listBrandByQuery(brandQ);
		
		model.addAttribute("brandsList",listBrandByQuery);
		
		return "/brand/list";
	}
	
}
