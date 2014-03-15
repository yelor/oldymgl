/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jskj.asset.client.panel;

import com.jskj.asset.client.layout.BasePanel;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JLabel;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author 305027939
 */
public class MessagePanel extends BasePanel {
    
    private boolean maxWindow;

    /**
     * Creates new form MessagePanel
     */
    public MessagePanel() {
        initComponents();
        this.maxWindow = false;
    }
    
    public void isMaxWindow(boolean maxWindow) {
        this.maxWindow = maxWindow;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        messageMain = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        jButtonReload = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        messageMain.setName("messageMain"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(MessagePanel.class);
        messageLabel.setFont(resourceMap.getFont("messageLabel.font")); // NOI18N
        messageLabel.setText(resourceMap.getString("messageLabel.text")); // NOI18N
        messageLabel.setName("messageLabel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(MessagePanel.class, this);
        jButtonReload.setAction(actionMap.get("reload")); // NOI18N
        jButtonReload.setIcon(resourceMap.getIcon("jButtonReload.icon")); // NOI18N
        jButtonReload.setText(resourceMap.getString("jButtonReload.text")); // NOI18N
        jButtonReload.setToolTipText(resourceMap.getString("jButtonReload.toolTipText")); // NOI18N
        jButtonReload.setBorder(null);
        jButtonReload.setBorderPainted(false);
        jButtonReload.setContentAreaFilled(false);
        jButtonReload.setName("jButtonReload"); // NOI18N
        jButtonReload.setOpaque(false);

        javax.swing.GroupLayout messageMainLayout = new javax.swing.GroupLayout(messageMain);
        messageMain.setLayout(messageMainLayout);
        messageMainLayout.setHorizontalGroup(
            messageMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageMainLayout.createSequentialGroup()
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonReload)
                .addContainerGap())
        );
        messageMainLayout.setVerticalGroup(
            messageMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonReload)
            .addComponent(messageLabel)
        );

        jScrollPane1.setViewportView(messageMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReload;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel messageMain;
    // End of variables declaration//GEN-END:variables

    @Override
    @Action
    public Task reload() {        
        return new MyTaskFindTask(messageLabel, this) {
            
            @Override
            public void layout(List<JLabel> labelArray) {
                
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(messageMain);
                messageMain.setLayout(layout);

                //这里构造对个JLABEL，这样可以就可以单行触发事件，有没有更好的方法？HTML似乎在这里不好用了？？？？
                ParallelGroup paraHorizGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
                GroupLayout.SequentialGroup seqVertGroup = layout.createSequentialGroup();
                
                if (labelArray != null && labelArray.size() > 0) {
                    for (JLabel label : labelArray) {
                        paraHorizGroup.addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
                        seqVertGroup.addComponent(label);
                    }
                }
                
                paraHorizGroup.addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
                seqVertGroup.addComponent(messageLabel);
                
                layout.setHorizontalGroup(paraHorizGroup);
                
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(seqVertGroup));
            }
        };
    }
    
    @Override
    public Task reload(Object param) {
        return null;
    }
}
