package tech.wetech.weshop.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {

    public BaseController() {
    }

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
