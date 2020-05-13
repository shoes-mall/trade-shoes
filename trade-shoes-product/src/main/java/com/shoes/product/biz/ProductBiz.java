package com.shoes.product.biz;

import com.alibaba.fastjson.JSONObject;
import com.shoes.product.config.bean.Dto;
import com.shoes.product.config.constant.ReturnInfo;
import com.shoes.product.config.system.SystemInitBean;
import com.shoes.product.config.tool.ResultTools;
import com.shoes.product.model.GoodsCats;
import com.shoes.product.service.GoodsCatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weiwanxi
 */
@Component
public class ProductBiz extends ResultTools {

    private static final Logger logger = LoggerFactory.getLogger(ResultTools.class);

    @Resource
    private GoodsCatsService goodsCatsService;

    /**
     * 获取商品分类信息（测试接口）
     *
     * @return
     */
    public Dto getCats(){
        List<GoodsCats> cats = goodsCatsService.getCats();
        if (cats.size() == SystemInitBean.ZERO_INTEGER_NUMBER){
            return SUCCESS();
        }
        return SUCCESS(cats);
    }

    /**
     * 根据类型ID查询商品分类信息
     *
     * @param json
     * @return
     */
    public Dto getCatsMessage(JSONObject json){
        try {
            Integer catId = json.getInteger("catId");
            GoodsCats catsByCatId = goodsCatsService.getCatsByCatId(catId);
            return SUCCESS(catsByCatId);
        }catch (Exception e){
            logger.info("根据类型ID查询商品分类信息失败");
        }
        return MODEL();
    }
}
