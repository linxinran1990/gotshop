package com.gotIt.gotshop.repository.spec;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.repository.spec.support.QueryWraper;
import com.gotIt.gotshop.repository.spec.support.ShopSimpleSpecification;
import com.gotIt.gotshop.vo.BannerInfo;
import com.gotIt.gotshop.vo.BannerVO;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
public class BannerSpec extends ShopSimpleSpecification<Banner,BannerVO> {
    /**
     * @param condition
     */
    public BannerSpec(BannerVO condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Banner> queryWraper) {
        addLikeCondition(queryWraper, "bannerName");
        addEqualsCondition(queryWraper,"id");
        //addBetweenCondition(queryWraper,"createBegin","createEnd","createTime");
    }
}



