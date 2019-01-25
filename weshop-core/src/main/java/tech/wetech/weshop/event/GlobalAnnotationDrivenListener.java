package tech.wetech.weshop.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tech.wetech.weshop.mapper.FootprintMapper;
import tech.wetech.weshop.po.Footprint;

/**
 * @author cjbi@outlook.com
 */
@Component
public class GlobalAnnotationDrivenListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @EventListener
    public void handleApplicationStarted(ApplicationStartedEvent ase) {
        logger.info("Handling application {} started event.", ase);
    }
}
