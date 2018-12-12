package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.*;

import java.util.List;

/**
 * @author cjbi
 */
public class IndexVO {

    private List<Ad> bannerList;

    private List<Brand> brandList;

    private List<Category> categoryList;

    private List<Channel> ChannelList;

    private List<Goods> hotGoodsList;

    private List<Goods> newGoodsList;

    private List<Topic> topicList;

    public List<Ad> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Ad> bannerList) {
        this.bannerList = bannerList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Channel> getChannelList() {
        return ChannelList;
    }

    public void setChannelList(List<Channel> channelList) {
        ChannelList = channelList;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
