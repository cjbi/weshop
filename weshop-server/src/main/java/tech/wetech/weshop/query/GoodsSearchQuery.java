package tech.wetech.weshop.query;

public class GoodsSearchQuery extends PageQuery {

    private Integer categoryId;

    private Integer brandId;

    private String keyword;

    private Boolean newly;

    private Boolean hot;

    public Integer getCategoryId() {
        return categoryId;
    }

    public GoodsSearchQuery setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public GoodsSearchQuery setBrandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public GoodsSearchQuery setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public Boolean getNewly() {
        return newly;
    }

    public GoodsSearchQuery setNewly(Boolean aNew) {
        newly = aNew;
        return this;
    }

    public Boolean getHot() {
        return hot;
    }

    public GoodsSearchQuery setHot(Boolean hot) {
        this.hot = hot;
        return this;
    }
}
