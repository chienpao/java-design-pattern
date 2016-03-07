package com.chienpao.designpattern.designpattern.decorator;

/**
 * Created by pao on 2/29/16.
 */
public abstract class PacketDecorator implements IPacketCreator {
    IPacketCreator component;

    public PacketDecorator(IPacketCreator component) {
        this.component = component;
    }
}
