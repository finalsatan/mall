package com.murphy233.mall.nosql.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * EsProductAttributeValue
 * 搜索中的商品属性信息
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/7/8 9:37 上午
 */
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long productAttributeId;

    /**
     * 属性值
     */
    @Field(type = FieldType.Keyword)
    private String value;

    /**
     * 属性参数：0->规格；1->参数
     */
    private Integer type;

    /**
     * 属性名称
     */
    @Field(type = FieldType.Keyword)
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getProductAttributeId() {
        return productAttributeId;
    }

    public String getValue() {
        return value;
    }

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
