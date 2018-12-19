package tech.wetech.weshop.vo;


import tech.wetech.weshop.bo.GoodsSpecificationBO;
import tech.wetech.weshop.po.*;

import java.util.Date;
import java.util.List;

public class GoodsDetailVO {

    private Goods goods;

    private List<GoodsAttributeVO> goodsAttributeList;

    private Brand brand;

    private CommentsVO comments;

    private List<GoodsGallery> goodsGalleryList;

    private List<GoodsIssue> goodsIssueList;

    private List<Product> productList;

    private List<GoodsSpecificationVO> goodsSpecificationList;

    private boolean userHasCollect;

    public static class GoodsAttributeVO {

        private String name;

        private String value;

        public GoodsAttributeVO() {
        }

        public GoodsAttributeVO(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class GoodsSpecificationVO {

        private Integer id;

        private String name;

        private List<GoodsSpecificationBO> goodsSpecificationList;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<GoodsSpecificationBO> getGoodsSpecificationList() {
            return goodsSpecificationList;
        }

        public void setGoodsSpecificationList(List<GoodsSpecificationBO> goodsSpecificationList) {
            this.goodsSpecificationList = goodsSpecificationList;
        }
    }

    public static class CommentsVO {

        private int count;

        private List<CommentVO> data;

        public static class CommentVO {

            private String content;

            private Date createTime;

            private String nickname;

            private String  avatar;

            private List<String> picList;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Date getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Date createTime) {
                this.createTime = createTime;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public List<String> getPicList() {
                return picList;
            }

            public void setPicList(List<String> picList) {
                this.picList = picList;
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

        public void setCount(int count) {
            this.count = count;
        }

        public List<CommentVO> getData() {
            return data;
        }

        public void setData(List<CommentVO> data) {
            this.data = data;
        }
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsAttributeVO> getGoodsAttributeList() {
        return goodsAttributeList;
    }

    public void setGoodsAttributeList(List<GoodsAttributeVO> goodsAttributeList) {
        this.goodsAttributeList = goodsAttributeList;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public CommentsVO getComments() {
        return comments;
    }

    public void setComments(CommentsVO comments) {
        this.comments = comments;
    }

    public List<GoodsGallery> getGoodsGalleryList() {
        return goodsGalleryList;
    }

    public void setGoodsGalleryList(List<GoodsGallery> goodsGalleryList) {
        this.goodsGalleryList = goodsGalleryList;
    }

    public List<GoodsIssue> getGoodsIssueList() {
        return goodsIssueList;
    }

    public void setGoodsIssueList(List<GoodsIssue> goodsIssueList) {
        this.goodsIssueList = goodsIssueList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<GoodsSpecificationVO> getGoodsSpecificationList() {
        return goodsSpecificationList;
    }

    public void setGoodsSpecificationList(List<GoodsSpecificationVO> goodsSpecificationList) {
        this.goodsSpecificationList = goodsSpecificationList;
    }

    public boolean isUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(boolean userHasCollect) {
        this.userHasCollect = userHasCollect;
    }
}
