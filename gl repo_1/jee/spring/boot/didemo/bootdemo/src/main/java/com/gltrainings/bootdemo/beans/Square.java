package com.gltrainings.bootdemo.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Square implements IShape {

    private static final Logger LOG= LoggerFactory.getLogger(Square.class);

    @Value("${square.side}")
    private int side;

    public int getSide(){
        return side;
    }

    public Square(){}
    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }

    @PostConstruct
    public void  afterInit(){
        LOG.debug("inside square, already initialized, side="+side);
    }

    @PreDestroy
    public void beforeDestroy(){
        LOG.debug("sqaure object about to be removed from container");
    }


}
