package com.gotIt.gotshop.repository.spec;

import com.gotIt.gotshop.entity.Banner;
import com.gotIt.gotshop.entity.Category;
import com.gotIt.gotshop.repository.spec.support.QueryWraper;
import com.gotIt.gotshop.repository.spec.support.ShopSimpleSpecification;
import com.gotIt.gotshop.vo.BannerVO;
import com.gotIt.gotshop.vo.CategoryInfo;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
public class CategorySpec extends ShopSimpleSpecification<Category,CategoryInfo> {

    /**
     * @param condition
     */
    public CategorySpec(CategoryInfo condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<Category> queryWraper) {
        addEqualsCondition(queryWraper,"id");
        addEqualsCondition(queryWraper,"categoryName");
        addEqualsCondition(queryWraper,"sortOrder");
    }
}



