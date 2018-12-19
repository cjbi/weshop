package tech.wetech.weshop.po;

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


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return goods_id
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}