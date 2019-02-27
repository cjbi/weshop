package tech.wetech.weshop.goods.dto;


import tech.wetech.weshop.goods.bo.GoodsAttributeBO;
import tech.wetech.weshop.goods.bo.GoodsSpecificationBO;
import tech.wetech.weshop.goods.po.*;

import java.util.List;

public class GoodsDetailDTO {

    private Goods goods;

    private List<GoodsAttributeBO> goodsAttributeList;

    private Brand brand;

    private CommentVO comment;

    private List<GoodsGallery> goodsGalleryList;

    private List<GoodsIssue> goodsIssueList;

    private List<Product> productList;

    private List<GoodsSpecificationVO> goodsSpecificationList;

    private boolean userHasCollect;

    public GoodsDetailDTO() {
    }

    public static class GoodsSpecificationVO {

        private Integer specificationId;

        private String name;

        private List<GoodsSpecificationBO> valueList;

        public Integer getSpecificationId() {
            return specificationId;
        }

        public GoodsSpecificationVO setSpecificationId(Integer specificationId) {
            this.specificationId = specificationId;
            return this;
        }

        public String getName() {
            return name;
        }

        public GoodsSpecificationVO setName(String name) {
            this.name = name;
            return this;
        }

        public List<GoodsSpecificationBO> getValueList() {
            return valueList;
        }

        public GoodsSpecificationVO setValueList(List<GoodsSpecificationBO> valueList) {
            this.valueList = valueList;
            return this;
        }
    }

    public static class CommentVO {

        private int count;

        private CommentDataVO data;

        public static class CommentDataVO {

            private String content;

            private String createTime;

            private String nickname;

            private String avatar;

            private List<String> picList;

            public String getContent() {
                return content;
            }

            public CommentDataVO setContent(String content) {
                this.content = content;
                return this;
            }

            public String getCreateTime() {
                return createTime;
            }

            public CommentDataVO setCreateTime(String createTime) {
                this.createTime = createTime;
                return this;
            }

            public String getNickname() {
                return nickname;
            }

            public CommentDataVO setNickname(String nickname) {
                this.nickname = nickname;
                return this;
            }

            public String getAvatar() {
                return avatar;
            }

            public CommentDataVO setAvatar(String avatar) {
                this.avatar = avatar;
                return this;
            }

            public List<String> getPicList() {
                return picList;
            }

            public CommentDataVO setPicList(List<String> picList) {
                this.picList = picList;
                return this;
            }
        }

        public CommentVO(int count, CommentDataVO data) {
            this.count = count;
            this.data = data;
        }

        public CommentVO() {
        }

        public int getCount() {
            return count;
        }

        public CommentVO setCount(int count) {
            this.count = count;
            return this;
        }

        public CommentDataVO getData() {
            return data;
        }

        public CommentVO setData(CommentDataVO data) {
            this.data = data;
            return this;
        }
    }

    public Goods getGoods() {
        return goods;
    }

    public GoodsDetailDTO setGoods(Goods goods) {
        this.goods = goods;
        return this;
    }


    public Brand getBrand() {
        return brand;
    }

    public GoodsDetailDTO setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }


    public List<GoodsGallery> getGoodsGalleryList() {
        return goodsGalleryList;
    }

    public GoodsDetailDTO setGoodsGalleryList(List<GoodsGallery> goodsGalleryList) {
        this.goodsGalleryList = goodsGalleryList;
        return this;
    }

    public List<GoodsIssue> getGoodsIssueList() {
        return goodsIssueList;
    }

    public GoodsDetailDTO setGoodsIssueList(List<GoodsIssue> goodsIssueList) {
        this.goodsIssueList = goodsIssueList;
        return this;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public GoodsDetailDTO setProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

    public List<GoodsSpecificationVO> getGoodsSpecificationList() {
        return goodsSpecificationList;
    }

    public GoodsDetailDTO setGoodsSpecificationList(List<GoodsSpecificationVO> goodsSpecificationList) {
        this.goodsSpecificationList = goodsSpecificationList;
        return this;
    }


    public boolean isUserHasCollect() {
        return userHasCollect;
    }

    public GoodsDetailDTO setUserHasCollect(boolean userHasCollect) {
        this.userHasCollect = userHasCollect;
        return this;
    }

    public List<GoodsAttributeBO> getGoodsAttributeList() {
        return goodsAttributeList;
    }

    public GoodsDetailDTO setGoodsAttributeList(List<GoodsAttributeBO> goodsAttributeList) {
        this.goodsAttributeList = goodsAttributeList;
        return this;
    }

    public CommentVO getComment() {
        return comment;
    }

    public GoodsDetailDTO setComment(CommentVO comment) {
        this.comment = comment;
        return this;
    }
}
