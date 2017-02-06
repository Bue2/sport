package cn.itcast.core.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;

/**
* @author Buer E-mail:
* @version 创建时间：2017年1月19日 下午7:58:08
* 类说明:
*/
public interface BrandService {

	/**
	 * 根据查询条件,查询品牌列表 的接口
	 * @param BrandQuery
	 * @return 品牌集合
	 */
	public List<Brand> listBrandByQuery(BrandQuery brandQ);
}
