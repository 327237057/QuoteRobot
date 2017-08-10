/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Siteng Jin
 */
public class ExecutorPool {
    private static ExecutorService m_pool = Executors.newFixedThreadPool(5, new NewThreadFactory());
    
    public static ExecutorService getPool(){
        if(m_pool.isShutdown()){
            m_pool = Executors.newFixedThreadPool(5, new NewThreadFactory());
        }
        return m_pool;
    }
}
