package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.GoodsIssue;
import tech.wetech.weshop.query.GoodsIssuePageQuery;
import tech.wetech.weshop.vo.CreateGoodsIssueFormVO;
import tech.wetech.weshop.vo.UpdateGoodsIssueFormVO;

public interface GoodsIssueService {

    /**
     * 分页查询商品问题
     * @param goodsIssuePageQuery
     * @return
     */
    PageInfo<GoodsIssue> queryGoodsIssuePageInfo(GoodsIssuePageQuery goodsIssuePageQuery);

    void createGoodsIssue(CreateGoodsIssueFormVO createGoodsIssueFormVO);

    void updateGoodsIssue(UpdateGoodsIssueFormVO updateGoodsIssueFormVO);

    void deleteGoodsIssue(Integer goodsIssueId);

}
