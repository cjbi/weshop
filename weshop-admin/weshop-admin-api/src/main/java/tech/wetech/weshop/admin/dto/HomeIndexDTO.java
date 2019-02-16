package tech.wetech.weshop.admin.dto;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public class HomeIndexDTO {

    private List<Ad> bannerList;

    private List<Brand> brandList;

    private List<HomeCategoryDTO> categoryList;

    private List<Channel> channelList;

    private List<Goods> hotGoodsList;

    private List<Goods> newGoodsList;

    private List<Topic> topicList;

    public List<Ad> getBannerList() {
        return bannerList;
    }

    public HomeIndexDTO setBannerList(List<Ad> bannerList) {
        this.bannerList = bannerList;
        return this;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public HomeIndexDTO setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
        return this;
    }

    public List<HomeCategoryDTO> getCategoryList() {
        return categoryList;
    }

    public HomeIndexDTO setCategoryList(List<HomeCategoryDTO> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public HomeIndexDTO setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
        return this;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public HomeIndexDTO setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
        return this;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public HomeIndexDTO setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
        return this;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public HomeIndexDTO setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
        return this;
    }
}
