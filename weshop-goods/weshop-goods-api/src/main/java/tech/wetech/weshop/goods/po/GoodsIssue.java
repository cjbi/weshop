package tech.wetech.weshop.goods.po;

import javax.persistence.*;

@Table(name = "weshop_goods_issue")
public class GoodsIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    private String answer;

    @Column(name = "goods_id")
    private String goodsId;

    public Integer getId() {
        return id;
    }

    public GoodsIssue setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public GoodsIssue setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public GoodsIssue setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public GoodsIssue setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }
}