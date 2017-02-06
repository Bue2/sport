package cn.itcast.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;
import cn.itcast.core.dao.product.BrandDao;

/**
* @author Buer E-mail:
* @version 创建时间：2017年1月19日 下午7:57:49
* 类说明:
*/
@Service
@Transactional
public class BrandServiceImp implements BrandService{

	@Autowired
	private BrandDao brandDao;
	
	public List<Brand> listBrandByQuery(BrandQuery brandQ){
		return brandDao.ListBrandbyQuery(brandQ);
		
	}
}
