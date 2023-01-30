package com.gltrainings.bootdemo.beans;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Scope("prototype")
@Component
public class Canvas {

    private static final Logger LOG = LoggerFactory.getLogger(Canvas.class);


    private IShape shape;

    public IShape getShape() {
        return shape;
    }

    public Canvas() {
    }

    // @Qualifier("square")
    //@Autowired
    public Canvas(IShape shape) {
        this.shape = shape;
    }

    //@Qualifier("square")
    @Autowired
    public void setShape(IShape shape) {
        this.shape = shape;
    }


    public void drawShape() {
        LOG.debug(shape.getClass().getSimpleName() + "getting drawn with area=" + shape.area());
    }

    @PostConstruct
    public void afterInit(){
        LOG.debug("Inside canvas, afterinitialize, shape set= "+shape.getClass().getSimpleName());
    }



    @PreDestroy
    public void beforeDestroy(){
        LOG.debug("Canvas object about to be removed from container");
    }


}
