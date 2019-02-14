package tech.wetech.weshop.marketing.dto;

public class BannerInfoDTO {

    private String url;

    private String name;

    private String imgUrl;

    public String getUrl() {
        return url;
    }

    public BannerInfoDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public BannerInfoDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public BannerInfoDTO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
