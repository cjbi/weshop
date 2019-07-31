package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.goods.po.Channel;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.user.po.Ad;
import tech.wetech.weshop.user.po.Topic;

import java.io.Serializable;
import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public class HomeIndexVO implements Serializable {

    private List<Ad> bannerList;

    private List<Brand> brandList;

    private List<HomeCategoryVO> categoryList;

    private List<Channel> channelList;

    private List<Goods> hotGoodsList;

    private List<Goods> newGoodsList;

    private List<Topic> topicList;

    public List<Ad> getBannerList() {
        return bannerList;
    }

    public HomeIndexVO setBannerList(List<Ad> bannerList) {
        this.bannerList = bannerList;
        return this;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public HomeIndexVO setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
        return this;
    }

    public List<HomeCategoryVO> getCategoryList() {
        return categoryList;
    }

    public HomeIndexVO setCategoryList(List<HomeCategoryVO> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public HomeIndexVO setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
        return this;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public HomeIndexVO setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
        return this;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public HomeIndexVO setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
        return this;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public HomeIndexVO setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
        return this;
    }
}
