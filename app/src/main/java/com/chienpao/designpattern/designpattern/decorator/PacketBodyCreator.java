package com.chienpao.designpattern.designpattern.decorator;

/**
 * Created by pao on 2/29/16.
 */
public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent() {
        return "Content Body of Packet";
    }
}
