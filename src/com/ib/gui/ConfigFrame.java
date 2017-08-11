/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.gui;

import com.ib.api.IBClient;
import com.ib.config.*;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 *
 * @author Siteng Jin
 */
public class ConfigFrame extends javax.swing.JFrame {
    public static final Logger LOG = Logger.getLogger(ConfigFrame.class);
    
    protected static ConfigFrame _instance = new ConfigFrame();
    
    private HashMap<String, String> m_backupConfig = null;
    
    // Connection getter and setters
    public String getHostField() {
        return hostField.getText();
    }

    public void setHostField(String host) {
        this.hostField.setText(host);
    }

    public String getPortField() {
        return portField.getText();
    }

    public void setPortField(String port) {
        this.portField.setText(port);
    }
    
    public String getClientidField() {
        return clientidField.getText();
    }

    public void setClientidField(String clientId) {
        this.clientidField.setText(clientId);
    }

    // Config getters and setters
    public String getAccountField() {
        return accountField.getText();
    }

    public void setAccountField(String account) {
        this.accountField.setText(account);
    }
    
    public String getOrderSizeDefaultField(){
        return orderSizeDefaultField.getText();
    }
    
    public void setOrderSizeDefaultField(String orderSizeDefault){
        this.orderSizeDefaultField.setText(orderSizeDefault);
    }

    public String getDefaultSpreadField() {
        return defaultSpreadField.getText();
    }

    public void setDefaultSpreadField(String defaultSpread) {
        this.defaultSpreadField.setText(defaultSpread);
    }

    public String getHedgeMultiField() {
        return hedgeMultiField.getText();
    }

    public void setHedgeMultiField(String hedgeMulti) {
        this.hedgeMultiField.setText(hedgeMulti);
    }
    
    public String getPositionAdjustField() {
        return positionAdjustField.getText();
    }

    public void setPositionAdjustField(String positionAdjust) {
        this.positionAdjustField.setText(positionAdjust);
    }

    public String getPriceDistortionRateField() {
        return priceDistortionRateField.getText();
    }

    public void setPriceDistortionRateField(String priceDistortionRate) {
        this.priceDistortionRateField.setText(priceDistortionRate);
    }

    public String getSizeDistortionRateField() {
        return sizeDistortionRateField.getText();
    }

    public void setSizeDistortionRateField(String sizeDistortionRate) {
        this.sizeDistortionRateField.setText(sizeDistortionRate);
    }

    public String getSourceConidField() {
        return sourceConidField.getText();
    }

    public void setSourceConidField(String sourceConid) {
        this.sourceConidField.setText(sourceConid);
    }

    public String getSourceExchangeField() {
        return sourceExchangeField.getText();
    }

    public void setSourceExchangeField(String sourceExchange) {
        this.sourceExchangeField.setText(sourceExchange);
    }

    public String getStaticOffsetField() {
        return staticOffsetField.getText();
    }

    public void setStaticOffsetField(String staticOffset) {
        this.staticOffsetField.setText(staticOffset);
    }

    public String getStopQuoteSizeField() {
        return stopQuoteSizeField.getText();
    }

    public void setStopQuoteSizeField(String stopQuoteSize) {
        this.stopQuoteSizeField.setText(stopQuoteSize);
    }

    public String getTradeConidField() {
        return tradeConidField.getText();
    }

    public void setTradeConidField(String tradeConid) {
        this.tradeConidField.setText(tradeConid);
    }

    public String getTradeExchangeField() {
        return tradeExchangeField.getText();
    }

    public void setTradeExchangeField(String tradeExchange) {
        this.tradeExchangeField.setText(tradeExchange);
    }
    
    public void backupConfigs(){
        if(m_backupConfig == null){
            m_backupConfig = new HashMap<String, String>();
        } else {
            m_backupConfig.clear();
        }
        
        m_backupConfig.put("HOST", this.getHostField());
        m_backupConfig.put("PORT", this.getPortField());
        m_backupConfig.put("CLIENTID", this.getClientidField());
        
        m_backupConfig.put(Configs.ACCOUNT, this.getAccountField());
        m_backupConfig.put(Configs.ORDER_SIZE_DEFAULT, this.getOrderSizeDefaultField());
        m_backupConfig.put(Configs.STATIC_OFFSET, this.getStaticOffsetField());
        m_backupConfig.put(Configs.PRICE_DISTORTION_RATE, this.getPriceDistortionRateField());
        m_backupConfig.put(Configs.SIZE_DISTORTION_RATE, this.getSizeDistortionRateField());
        m_backupConfig.put(Configs.SOURCE_CONID, this.getSourceConidField());
        m_backupConfig.put(Configs.SOURCE_EXCHANGE, this.getSourceExchangeField());
        m_backupConfig.put(Configs.TRADE_CONID, this.getTradeConidField());
        m_backupConfig.put(Configs.TRADE_EXCHANGE, this.getTradeExchangeField());
        m_backupConfig.put(Configs.HEDGE_MULTIPLIER, this.getHedgeMultiField());
        m_backupConfig.put(Configs.DEFAULT_SPREAD, this.getDefaultSpreadField());
        m_backupConfig.put(Configs.STOP_QUOTING_SIZE, this.getStopQuoteSizeField());
        m_backupConfig.put(Configs.POSITION_ADJUSTMENT, this.getPositionAdjustField());
    }
    
    private void restoreConfigsFromBackup(){
        if(m_backupConfig == null || m_backupConfig.isEmpty()){
            LOG.debug("No back is available to restore");
            return;
        }
        
        this.setHostField(m_backupConfig.get("HOST"));
        this.setPortField(m_backupConfig.get("PORT"));
        this.setClientidField(m_backupConfig.get("CLIENTID"));
        
        this.setAccountField(m_backupConfig.get(Configs.ACCOUNT));
        this.setOrderSizeDefaultField(m_backupConfig.get(Configs.ORDER_SIZE_DEFAULT));
        this.setStaticOffsetField(m_backupConfig.get(Configs.STATIC_OFFSET));
        this.setPriceDistortionRateField(m_backupConfig.get(Configs.PRICE_DISTORTION_RATE));
        this.setSizeDistortionRateField(m_backupConfig.get(Configs.SIZE_DISTORTION_RATE));
        this.setSourceConidField(m_backupConfig.get(Configs.SOURCE_CONID));
        this.setSourceExchangeField(m_backupConfig.get(Configs.SOURCE_EXCHANGE));
        this.setTradeConidField(m_backupConfig.get(Configs.TRADE_CONID));
        this.setTradeExchangeField(m_backupConfig.get(Configs.TRADE_EXCHANGE));
        this.setHedgeMultiField(m_backupConfig.get(Configs.HEDGE_MULTIPLIER));
        this.setDefaultSpreadField(m_backupConfig.get(Configs.DEFAULT_SPREAD));
        this.setStopQuoteSizeField(m_backupConfig.get(Configs.STOP_QUOTING_SIZE));
        this.setPositionAdjustField(m_backupConfig.get(Configs.POSITION_ADJUSTMENT));
    }
    
    public void disableConnConfigs(){
        this.hostField.setEnabled(false);
        this.portField.setEnabled(false);
        this.clientidField.setEnabled(false);
    }

    /**
     * Creates new form ConfigFrame
     */
    public ConfigFrame() {
        initComponents();
        setLoc();
    }
    
    public static ConfigFrame getInstance(){
        if(_instance == null){
            _instance = new ConfigFrame();
        }
        return _instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hostLabel = new javax.swing.JLabel();
        hostField = new javax.swing.JTextField();
        portlabel = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        clientIdLabel = new javax.swing.JLabel();
        clientidField = new javax.swing.JTextField();
        accountLabel = new javax.swing.JLabel();
        orderSizeDefaultLabel = new javax.swing.JLabel();
        staticOffsetLabel = new javax.swing.JLabel();
        priceDistortionRateLabel = new javax.swing.JLabel();
        sizeDistortionRateLabel = new javax.swing.JLabel();
        sourceConidLabel = new javax.swing.JLabel();
        sourceExchangeLabel = new javax.swing.JLabel();
        tradeConidLabel = new javax.swing.JLabel();
        tradeExchangeLabel = new javax.swing.JLabel();
        hedgeMultiLabel = new javax.swing.JLabel();
        defaultSpreadlLbel = new javax.swing.JLabel();
        stopQuoteSizeLabel = new javax.swing.JLabel();
        positionAdjustLabel = new javax.swing.JLabel();
        priceDistortionRateField = new javax.swing.JTextField();
        staticOffsetField = new javax.swing.JTextField();
        orderSizeDefaultField = new javax.swing.JTextField();
        accountField = new javax.swing.JTextField();
        sourceConidField = new javax.swing.JTextField();
        sizeDistortionRateField = new javax.swing.JTextField();
        sourceExchangeField = new javax.swing.JTextField();
        tradeConidField = new javax.swing.JTextField();
        tradeExchangeField = new javax.swing.JTextField();
        hedgeMultiField = new javax.swing.JTextField();
        defaultSpreadField = new javax.swing.JTextField();
        stopQuoteSizeField = new javax.swing.JTextField();
        positionAdjustField = new javax.swing.JTextField();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        hostLabel.setText("Host: ");

        hostField.setText("127.0.0.1");

        portlabel.setText("Port: ");

        portField.setText("7496");

        clientIdLabel.setText("Client ID: ");

        clientidField.setText("0");

        accountLabel.setText("ACCOUNT: ");

        orderSizeDefaultLabel.setText("ORDER_SIZE_DEFAULT: ");

        staticOffsetLabel.setText("STATIC_OFFSET: ");

        priceDistortionRateLabel.setText("PRICE_DISTORTION_RATE: ");

        sizeDistortionRateLabel.setText("SIZE_DISTORTION_RATE: ");

        sourceConidLabel.setText("SOURCE_CONID: ");

        sourceExchangeLabel.setText("SOURCE_EXCHANGE: ");

        tradeConidLabel.setText("TRADE_CONID: ");

        tradeExchangeLabel.setText("TRADE_EXCHANGE: ");

        hedgeMultiLabel.setText("HEDGE_MULTIPLIER: ");

        defaultSpreadlLbel.setText("DEFAULT_SPREAD: ");

        stopQuoteSizeLabel.setText("STOP_QUOTING_SIZE: ");

        positionAdjustLabel.setText("POSITION_ADJUSTMENT: ");

        positionAdjustField.setEnabled(false);

        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(hostLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(portlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clientIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(positionAdjustLabel)
                            .addComponent(priceDistortionRateLabel)
                            .addComponent(staticOffsetLabel)
                            .addComponent(orderSizeDefaultLabel)
                            .addComponent(accountLabel)
                            .addComponent(sourceConidLabel)
                            .addComponent(sizeDistortionRateLabel)
                            .addComponent(sourceExchangeLabel)
                            .addComponent(tradeConidLabel)
                            .addComponent(tradeExchangeLabel)
                            .addComponent(hedgeMultiLabel)
                            .addComponent(defaultSpreadlLbel)
                            .addComponent(stopQuoteSizeLabel)
                            .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stopQuoteSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(positionAdjustField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(defaultSpreadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hedgeMultiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tradeExchangeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tradeConidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sourceExchangeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sourceConidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sizeDistortionRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceDistortionRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staticOffsetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderSizeDefaultField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clientidField, hostField, portField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {accountField, defaultSpreadField, hedgeMultiField, orderSizeDefaultField, positionAdjustField, priceDistortionRateField, sizeDistortionRateField, sourceConidField, sourceExchangeField, staticOffsetField, stopQuoteSizeField, tradeConidField, tradeExchangeField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelBtn, confirmBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostLabel)
                    .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portlabel)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientIdLabel)
                    .addComponent(clientidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountLabel)
                    .addComponent(accountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderSizeDefaultLabel)
                    .addComponent(orderSizeDefaultField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staticOffsetLabel)
                    .addComponent(staticOffsetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceDistortionRateLabel)
                    .addComponent(priceDistortionRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeDistortionRateLabel)
                    .addComponent(sizeDistortionRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceConidLabel)
                    .addComponent(sourceConidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceExchangeLabel)
                    .addComponent(sourceExchangeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tradeConidLabel)
                    .addComponent(tradeConidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tradeExchangeLabel)
                    .addComponent(tradeExchangeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hedgeMultiLabel)
                    .addComponent(hedgeMultiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultSpreadlLbel)
                    .addComponent(defaultSpreadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopQuoteSizeLabel)
                    .addComponent(stopQuoteSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionAdjustLabel)
                    .addComponent(positionAdjustField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void setLoc(){
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getPreferredSize().width/2, dim.height/2-getPreferredSize().height/2);
    }
    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigFrame.getInstance().setVisible(false);
                ConfigFrame.getInstance().restoreConfigsFromBackup();
            }
        });
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run(){
               ConfigFrame.getInstance().setVisible(false);
               // Refresh all configs
               IBClient.getInstance().updateAllConfigs();
           } 
        });
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigFrame.getInstance().setVisible(false);
                ConfigFrame.getInstance().restoreConfigsFromBackup();
            }
        });
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountField;
    private javax.swing.JLabel accountLabel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel clientIdLabel;
    private javax.swing.JTextField clientidField;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField defaultSpreadField;
    private javax.swing.JLabel defaultSpreadlLbel;
    private javax.swing.JTextField hedgeMultiField;
    private javax.swing.JLabel hedgeMultiLabel;
    private javax.swing.JTextField hostField;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JTextField orderSizeDefaultField;
    private javax.swing.JLabel orderSizeDefaultLabel;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portlabel;
    private javax.swing.JTextField positionAdjustField;
    private javax.swing.JLabel positionAdjustLabel;
    private javax.swing.JTextField priceDistortionRateField;
    private javax.swing.JLabel priceDistortionRateLabel;
    private javax.swing.JTextField sizeDistortionRateField;
    private javax.swing.JLabel sizeDistortionRateLabel;
    private javax.swing.JTextField sourceConidField;
    private javax.swing.JLabel sourceConidLabel;
    private javax.swing.JTextField sourceExchangeField;
    private javax.swing.JLabel sourceExchangeLabel;
    private javax.swing.JTextField staticOffsetField;
    private javax.swing.JLabel staticOffsetLabel;
    private javax.swing.JTextField stopQuoteSizeField;
    private javax.swing.JLabel stopQuoteSizeLabel;
    private javax.swing.JTextField tradeConidField;
    private javax.swing.JLabel tradeConidLabel;
    private javax.swing.JTextField tradeExchangeField;
    private javax.swing.JLabel tradeExchangeLabel;
    // End of variables declaration//GEN-END:variables
}
