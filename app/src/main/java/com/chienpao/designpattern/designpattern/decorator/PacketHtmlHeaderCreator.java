package com.chienpao.designpattern.designpattern.decorator;

/**
 * Created by pao on 2/29/16.
 */
public class PacketHtmlHeaderCreator extends PacketDecorator {

    public PacketHtmlHeaderCreator(IPacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        return component.handleContent() + ", Process html header";
    }
}
