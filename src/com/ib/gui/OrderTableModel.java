/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.gui;

import com.ib.order.OrderInfo;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.table.AbstractTableModel;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Siteng Jin
 */
public class OrderTableModel extends AbstractTableModel{
    private static final Logger LOG = Logger.getLogger(OrderTableModel.class);
    
    protected static OrderTableModel _instance = null;
    
    private final Map<Integer, OrderInfo> m_orderMap = new ConcurrentHashMap<Integer, OrderInfo>();
    private final List<Integer> m_orderIdList = new ArrayList<Integer>();
    
    public static final int NUMOFCOLUMNS = 8;
    
    private int tradeConid = Integer.MAX_VALUE;
    
    public static String[] m_colNames = {"Order ID", "ConId", "Action", "Quantity", "Order Type", "Lmt Price", "Filled", "Remaining"};
    
    public static OrderTableModel getInstance(){
        if(_instance == null){
            _instance = new OrderTableModel();
        }
        return _instance;
    }
    
    @Override
    public int getRowCount(){
        return m_orderMap.size();
    }
    
    @Override
    public int getColumnCount(){
        return NUMOFCOLUMNS;
    }
    
    @Override
    public synchronized Object getValueAt(int row, int column){
        if(m_orderMap.size() < row + 1){
            return null;
        }
        
        OrderInfo orderInfo = m_orderMap.get((Integer) m_orderIdList.get(row));
        switch(column){
            case 0: return orderInfo.getOrder().orderId();
            case 1: 
            {
                if(tradeConid == Integer.MAX_VALUE){
                    fetchTradeConid();
                }
                return tradeConid;
            }
            case 2: return orderInfo.getOrder().action();
            case 3: return orderInfo.getOrder().totalQuantity();
            case 4: return orderInfo.getOrder().orderType();
            case 5: return orderInfo.getOrder().lmtPrice();
            case 6: return orderInfo.getFilled();
            case 7: return orderInfo.getRemaining();
            default: return null;
        }
    }
    
    @Override public String getColumnName(int col) {
        if(col < m_colNames.length){
            return m_colNames[col];
        }
        return null;
    }
    
    public synchronized void updateTableRow(OrderInfo orderInfo){
        Integer orderId = orderInfo.getOrder().orderId();
        if(m_orderIdList.contains(orderId)){
            m_orderMap.replace(orderId, orderInfo);
            this.fireTableDataChanged();
        } else {
            m_orderIdList.add(orderId);
            m_orderMap.put(orderId, orderInfo);
            this.fireTableDataChanged();
        }
    }
    
    public synchronized void removeTableRow(int orderId){
        for(int i = 0; i < m_orderIdList.size(); i++){
            if(Integer.compare(m_orderIdList.get(i), orderId) == 0){
                m_orderMap.remove((Integer) orderId);
                m_orderIdList.remove(i);
                this.fireTableDataChanged();
                LOG.debug(("Removed orderId = " + orderId + " from table"));
                return;
            }
        }
        LOG.debug("OrderId " + orderId + " is not in table. Remove failed.");
    }
    
    private void fetchTradeConid(){
        if(tradeConid == Integer.MAX_VALUE){
            tradeConid = Integer.parseInt(ConfigFrame.getInstance().getTradeConidField());
        }
    }
    
    public void updateAllConfigs(){
        tradeConid = Integer.parseInt(ConfigFrame.getInstance().getTradeConidField());
    }
}
