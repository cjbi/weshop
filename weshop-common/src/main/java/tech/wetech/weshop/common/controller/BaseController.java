package tech.wetech.weshop.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {

    public BaseController() {
    }

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

}
