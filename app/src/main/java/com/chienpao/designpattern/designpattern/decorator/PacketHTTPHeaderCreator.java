package com.chienpao.designpattern.designpattern.decorator;

/**
 * Created by pao on 2/29/16.
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        return component.handleContent() + ", Process http header";
    }
}
