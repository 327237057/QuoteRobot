/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.thread;

import com.ib.api.IBReader;
import com.ib.engine.MainQuoteEngineForGUI;
import java.util.concurrent.ThreadFactory;
import com.ib.order.CancelHandler;
import com.ib.order.OrderHandler;
import com.ib.position.PositionMonitor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Siteng Jin
 */
public class NewThreadFactory implements ThreadFactory{
    private AtomicInteger count = new AtomicInteger(0);
    
    @Override
    public Thread newThread(Runnable r){
        
        if(r instanceof MainQuoteEngineForGUI){
            return new Thread(r, "MainQuoteEngine");
        } else if (r instanceof IBReader){
            return new Thread(r, "Reader");
        } else if (r instanceof CancelHandler){
            return new Thread(r, "CancelHandler");
        } else if (r instanceof PositionMonitor){
            return new Thread(r, "PositionMonitor");
        } else if (r instanceof OrderHandler){
            return new Thread(r, "Orderhandler");
        } else {
            return new Thread(r, "Thread-" + count.getAndIncrement());
        }
    }
}
