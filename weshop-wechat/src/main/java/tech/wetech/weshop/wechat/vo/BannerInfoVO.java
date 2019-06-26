package tech.wetech.weshop.wechat.vo;

public class BannerInfoVO {

    private String url;

    private String name;

    private String imgUrl;

    public String getUrl() {
        return url;
    }

    public BannerInfoVO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public BannerInfoVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public BannerInfoVO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
