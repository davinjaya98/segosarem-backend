package com.segosarem.web.webservices.bean.webservices;

public class ListItemReqBean {
    
    private Integer subCategoryId;
    private String itemName;
    private String itemPriceMin;
    private String itemPriceMax;

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPriceMin() {
        return this.itemPriceMin;
    }

    public void setItemPriceMin(String itemPriceMin) {
        this.itemPriceMin = itemPriceMin;
    }
    public String getItemPriceMax() {
        return this.itemPriceMax;
    }

    public void setItemPriceMax(String itemPriceMax) {
        this.itemPriceMax = itemPriceMax;
    }
}