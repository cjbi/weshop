package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.GoodsIssueMapper;
import tech.wetech.weshop.po.GoodsIssue;
import tech.wetech.weshop.query.GoodsIssuePageQuery;
import tech.wetech.weshop.service.GoodsIssueService;
import tech.wetech.weshop.vo.CreateGoodsIssueFormVO;
import tech.wetech.weshop.vo.UpdateGoodsIssueFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class GoodsIssueServiceImpl implements GoodsIssueService {

    @Autowired
    private GoodsIssueMapper goodsIssueMapper;

    @Override
    public PageInfo<GoodsIssue> queryGoodsIssuePageInfo(GoodsIssuePageQuery goodsIssuePageQuery) {
        Weekend<GoodsIssue> example = Weekend.of(GoodsIssue.class);
        WeekendCriteria<GoodsIssue, Object> criteria = example.weekendCriteria();
        if (goodsIssuePageQuery.getQuestion() != null) {
            criteria.andLike(GoodsIssue::getQuestion, "%" + goodsIssuePageQuery.getQuestion() + "%");
        }
        return PageHelper.startPage(goodsIssuePageQuery.getPageNum(), goodsIssuePageQuery.getPageSize())
                .doSelectPageInfo(() -> goodsIssueMapper.selectByExample(example));
    }

    @Override
    public void createGoodsIssue(CreateGoodsIssueFormVO createGoodsIssueFormVO) {
        goodsIssueMapper.insertSelective(new GoodsIssue(createGoodsIssueFormVO));
    }

    @Override
    public void updateGoodsIssue(UpdateGoodsIssueFormVO updateGoodsIssueFormVO) {
        goodsIssueMapper.updateByPrimaryKeySelective(new GoodsIssue(updateGoodsIssueFormVO));
    }

    @Override
    public void deleteGoodsIssue(Integer goodsIssueId) {
        goodsIssueMapper.deleteByPrimaryKey(goodsIssueId);
    }
}
