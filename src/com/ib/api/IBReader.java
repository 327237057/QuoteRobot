/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.api;

import com.ib.client.EReader;
import com.ib.client.EReaderSignal;
import org.apache.log4j.Logger;

/**
 *
 * @author Siteng Jin
 */
public class IBReader implements Runnable{
    public static final Logger LOG = Logger.getLogger(IBReader.class);
    
    private IBClient m_client = null;
    private EReader m_reader = null;
    private EReaderSignal m_signal = null;
    
    public IBReader(IBClient client, EReader reader, EReaderSignal signal){
        m_client = client;
        m_reader = reader;
        m_signal = signal;
    }
    
    @Override
    public void run(){
        while (m_client.getSocket().isConnected() && !Thread.interrupted()) {
            m_signal.waitForSignal();
            try {
                m_reader.processMsgs();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
