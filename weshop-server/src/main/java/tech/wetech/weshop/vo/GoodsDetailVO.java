package tech.wetech.weshop.vo;


import tech.wetech.weshop.bo.GoodsAttributeBO;
import tech.wetech.weshop.bo.GoodsSpecificationBO;
import tech.wetech.weshop.po.*;

import java.time.LocalDateTime;
import java.util.List;

public class GoodsDetailVO {

    private Goods goods;

    private List<GoodsAttributeBO> goodsAttributeList;

    private Brand brand;

    private CommentsVO comments;

    private List<GoodsGallery> goodsGalleryList;

    private List<GoodsIssue> goodsIssueList;

    private List<Product> productList;

    private List<GoodsSpecificationVO> goodsSpecificationList;

    private boolean userHasCollect;

    public static class GoodsSpecificationVO {

        private Integer id;

        private String name;

        private List<GoodsSpecificationBO> goodsSpecificationList;

        public Integer getId() {
            return id;
        }

        public GoodsSpecificationVO setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public GoodsSpecificationVO setName(String name) {
            this.name = name;
            return this;
        }

        public List<GoodsSpecificationBO> getGoodsSpecificationList() {
            return goodsSpecificationList;
        }

        public GoodsSpecificationVO setGoodsSpecificationList(List<GoodsSpecificationBO> goodsSpecificationList) {
            this.goodsSpecificationList = goodsSpecificationList;
            return this;
        }
    }

    public static class CommentsVO {

        private int count;

        private List<CommentVO> data;

        public static class CommentVO {

            private String content;

            private LocalDateTime createTime;

            private String nickname;

            private String  avatar;

            private List<String> picList;

            public String getContent() {
                return content;
            }

            public CommentVO setContent(String content) {
                this.content = content;
                return this;
            }

            public LocalDateTime getCreateTime() {
                return createTime;
            }

            public CommentVO setCreateTime(LocalDateTime createTime) {
                this.createTime = createTime;
                return this;
            }

            public String getNickname() {
                return nickname;
            }

            public CommentVO setNickname(String nickname) {
                this.nickname = nickname;
                return this;
            }

            public String getAvatar() {
                return avatar;
            }

            public CommentVO setAvatar(String avatar) {
                this.avatar = avatar;
                return this;
            }

            public List<String> getPicList() {
                return picList;
            }

            public CommentVO setPicList(List<String> picList) {
                this.picList = picList;
                return this;
            }
        }

        public CommentsVO() {
        }

        public CommentsVO(int count, List<CommentVO> data) {
            this.count = count;
            this.data = data;
        }

        public int getCount() {
            return count;
        }

        public CommentsVO setCount(int count) {
            this.count = count;
            return this;
        }

        public List<CommentVO> getData() {
            return data;
        }

        public CommentsVO setData(List<CommentVO> data) {
            this.data = data;
            return this;
        }
    }

    public Goods getGoods() {
        return goods;
    }

    public GoodsDetailVO setGoods(Goods goods) {
        this.goods = goods;
        return this;
    }


    public Brand getBrand() {
        return brand;
    }

    public GoodsDetailVO setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public CommentsVO getComments() {
        return comments;
    }

    public GoodsDetailVO setComments(CommentsVO comments) {
        this.comments = comments;
        return this;
    }

    public List<GoodsGallery> getGoodsGalleryList() {
        return goodsGalleryList;
    }

    public GoodsDetailVO setGoodsGalleryList(List<GoodsGallery> goodsGalleryList) {
        this.goodsGalleryList = goodsGalleryList;
        return this;
    }

    public List<GoodsIssue> getGoodsIssueList() {
        return goodsIssueList;
    }

    public GoodsDetailVO setGoodsIssueList(List<GoodsIssue> goodsIssueList) {
        this.goodsIssueList = goodsIssueList;
        return this;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public GoodsDetailVO setProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

    public List<GoodsSpecificationVO> getGoodsSpecificationList() {
        return goodsSpecificationList;
    }

    public GoodsDetailVO setGoodsSpecificationList(List<GoodsSpecificationVO> goodsSpecificationList) {
        this.goodsSpecificationList = goodsSpecificationList;
        return this;
    }

    public boolean isUserHasCollect() {
        return userHasCollect;
    }

    public GoodsDetailVO setUserHasCollect(boolean userHasCollect) {
        this.userHasCollect = userHasCollect;
        return this;
    }

    public List<GoodsAttributeBO> getGoodsAttributeList() {
        return goodsAttributeList;
    }

    public GoodsDetailVO setGoodsAttributeList(List<GoodsAttributeBO> goodsAttributeList) {
        this.goodsAttributeList = goodsAttributeList;
        return this;
    }
}
