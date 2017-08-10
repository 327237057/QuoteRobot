/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.engine;

import org.apache.log4j.Logger;
import com.ib.api.IBClient;
import com.ib.api.IBReader;
import com.ib.client.EReaderSignal;
import com.ib.client.EReader;
import com.ib.gui.ConfigFrame;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import com.ib.thread.ExecutorPool;

/**
 *
 * @author Siteng Jin
 */
public class MainQuoteEngineForGUI implements Runnable{
    public static final Logger LOG = Logger.getLogger(MainQuoteEngine.class);
    
    private IBClient m_client = null;
    private EReaderSignal m_signal = null;
            
    private String HOST = null;
    private int PORT = Integer.MAX_VALUE;
    private int CLIENTID = Integer.MAX_VALUE;
    
    public MainQuoteEngineForGUI(){
        m_client = IBClient.getInstance();
        m_signal = m_client.getSignal();
        
        HOST = ConfigFrame.getInstance().getHostField();
        PORT = Integer.parseInt(ConfigFrame.getInstance().getPortField());
        CLIENTID = Integer.parseInt(ConfigFrame.getInstance().getClientidField());
    }
    
    @Override
    public void run(){
        initiateConnection();
        
        m_client.start();
    }
    
    public void initiateConnection() {
        LOG.info("---------------------------Starting Morgan Stanley Quote Test---------------------------");
        
        if(m_client == null){
            m_client = IBClient.getInstance();
        }
        if(m_signal == null){
            m_signal = m_client.getSignal();
        }
        
        //! [connect]
        m_client.getSocket().eConnect(HOST, PORT, CLIENTID);
        //! [connect]
        //! [ereader]
        final EReader reader = new EReader(m_client.getSocket(), m_signal);
        reader.start();
        /*
        new Thread("wrapper") {
            public void run() {
                while (m_client.getSocket().isConnected()) {
                    m_signal.waitForSignal();
                    try {
                        reader.processMsgs();
                    } catch (Exception e) {
                        LOG.error(e.getMessage(), e);
                    }
                }
            }
        }.start();
        */
        
        ExecutorPool.getPool().execute(new IBReader(m_client, reader, m_signal));
        
        try{
            while(m_client.getCurrentOrderId() == -1){
                Thread.sleep(200);
            }
            
        // Confirmed API is connected
        ConfigFrame.getInstance().disableConnConfigs();
            
        } catch (Exception e){
            LOG.error(e.getMessage(), e);
        }
    }
    
}
