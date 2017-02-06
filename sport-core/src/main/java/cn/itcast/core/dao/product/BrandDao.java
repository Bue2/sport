package cn.itcast.core.dao.product;

import java.util.List;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;

/**
* @author Buer E-mail:
* @version 创建时间：2017年1月19日 下午7:58:55
* 类说明:
*/
public interface BrandDao {

	public List<Brand> ListBrandbyQuery(BrandQuery brandQ);
}
