package com.gotIt.gotshop.repository.spec;

import com.gotIt.gotshop.entity.MessageType;
import com.gotIt.gotshop.repository.spec.support.QueryWraper;
import com.gotIt.gotshop.repository.spec.support.ShopSimpleSpecification;
import com.gotIt.gotshop.vo.MessageTypeInfo;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/26</pre>
 */
public class MessageTypeSpec extends ShopSimpleSpecification<MessageType,MessageTypeInfo> {
    /**
     * @param condition
     */
    public MessageTypeSpec(MessageTypeInfo condition) {
        super(condition);
    }

    @Override
    protected void addCondition(QueryWraper<MessageType> queryWraper) {
        addEqualsCondition(queryWraper,"id");
        addEqualsCondition(queryWraper,"typeName");
        addEqualsCondition(queryWraper,"typeInfo");
        //addEqualsCondition(queryWraper,"typeStatus");
    }
}



