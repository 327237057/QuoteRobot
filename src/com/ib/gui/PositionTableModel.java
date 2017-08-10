/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.gui;

import java.util.concurrent.ConcurrentHashMap;
import javax.swing.table.AbstractTableModel;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.ib.position.Position;

/**
 *
 * @author Siteng Jin
 */
public class PositionTableModel extends AbstractTableModel{
    private static final Logger LOG = Logger.getLogger(PositionTableModel.class);
    
    protected static PositionTableModel _instance = null;
    
    private final Map<Integer, Position> m_positions = new ConcurrentHashMap<Integer, Position>();
    private final List<Integer> m_positionIdList = new ArrayList<Integer>();
    
    public static final int NUMOFCOLUMNS = 5;
    
    public static String[] m_colNames = {"Symbol", "ConId", "Account", "Position", "Average Cost"};
    
    public static PositionTableModel getInstance(){
        if(_instance == null){
            _instance = new PositionTableModel();
        }
        return _instance;
    }
    
    @Override
    public int getRowCount(){
        return m_positions.size();
    }
    
    @Override
    public int getColumnCount(){
        return NUMOFCOLUMNS;
    }
    
    @Override
    public synchronized Object getValueAt(int row, int column){
        if(m_positions.size() < row + 1){
            return null;
        }
        
        Position position = m_positions.get((Integer) m_positionIdList.get(row));
        switch(column){
            case 0: return position.getContract().symbol();
            case 1: return position.getContract().conid();
            case 2: return position.getAccount();
            case 3: return position.getPos();
            case 4: return position.getAvgCost();
            default: return null;
        }
    }
    
    @Override public String getColumnName(int col) {
        if(col < m_colNames.length){
            return m_colNames[col];
        }
        return null;
    }
    
    public synchronized void updateTableRow(Position position){
        Integer conId = position.getContract().conid();
        if(m_positionIdList.contains(conId)){
            m_positions.replace(conId, position);
            this.fireTableDataChanged();
        } else {
            m_positionIdList.add(conId);
            m_positions.put(conId, position);
            this.fireTableDataChanged();
        }
    }
}
