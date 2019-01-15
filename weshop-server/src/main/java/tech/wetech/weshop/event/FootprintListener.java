package tech.wetech.weshop.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import tech.wetech.weshop.mapper.FootprintMapper;
import tech.wetech.weshop.po.Footprint;

/**
 * 用户足迹事件监听
 *
 * @author cjbi
 */
@Component
public class FootprintListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FootprintMapper footprintMapper;

    @EventListener
    @TransactionalEventListener
    public void handleFootprintEvent(Footprint footprint) {
        logger.info("Handling footprint event.", footprint);
        footprintMapper.insertSelective(footprint);
    }
}
