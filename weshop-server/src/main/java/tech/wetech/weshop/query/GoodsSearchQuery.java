package tech.wetech.weshop.query;

public class GoodsSearchQuery extends PageQuery {

    private Integer categoryId;

    private Integer brandId;

    private String keyword;

    private Boolean isNew;

    private Boolean isHot;

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

    public Boolean getNew() {
        return isNew;
    }

    public GoodsSearchQuery setNew(Boolean aNew) {
        isNew = aNew;
        return this;
    }

    public Boolean getHot() {
        return isHot;
    }

    public GoodsSearchQuery setHot(Boolean hot) {
        isHot = hot;
        return this;
    }
}
