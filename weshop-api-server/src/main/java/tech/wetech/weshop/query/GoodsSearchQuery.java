package tech.wetech.weshop.query;

public class GoodsSearchQuery {

    private Integer categoryId;

    private Integer brandId;

    private String keyword;

    private Boolean isNew;

    private Boolean isHot;

    private Integer pageNum;

    private Integer PageSize;

    private String sort;

    private String order;

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

    public Integer getPageNum() {
        return pageNum;
    }

    public GoodsSearchQuery setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public GoodsSearchQuery setPageSize(Integer pageSize) {
        PageSize = pageSize;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public GoodsSearchQuery setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public String getOrder() {
        return order;
    }

    public GoodsSearchQuery setOrder(String order) {
        this.order = order;
        return this;
    }
}
