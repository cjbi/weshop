package tech.wetech.weshop.goods.query;


public class GoodsSearchQuery {

    private Integer categoryId;

    private Integer brandId;

    private String keyword;

    private Boolean newly;

    private Boolean hot;

    private String sort;

    private String order;

    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;

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

    public GoodsSearchQuery setNewly(Boolean newly) {
        this.newly = newly;
        return this;
    }

    public Boolean getHot() {
        return hot;
    }

    public GoodsSearchQuery setHot(Boolean hot) {
        this.hot = hot;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
