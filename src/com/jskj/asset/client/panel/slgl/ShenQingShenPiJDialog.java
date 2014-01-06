/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jskj.asset.client.panel.slgl;

import com.jskj.asset.client.bean.entity.CaiGouShenQingFindEntity;
import com.jskj.asset.client.bean.entity.ShenPiEntity;
import com.jskj.asset.client.bean.entity.ZiChanCaiGouShenQing;
import com.jskj.asset.client.layout.AssetMessage;
import com.jskj.asset.client.layout.BaseTable;
import com.jskj.asset.client.util.BindTableHelper;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author tt
 */
public class ShenQingShenPiJDialog extends javax.swing.JDialog {

    private int pageIndex;

    private int count;

    private List<ZiChanCaiGouShenQing> cgsq;
    
    private String user;
    
    private ShenPiEntity shenPiEntity;
    
    private final ShenQingShenPiJDialog spdialog;
    
    /**
     * Creates new form GuDingZiChanRuKu
     */
    public ShenQingShenPiJDialog(java.awt.Frame parent,boolean modal) {
        super(parent,modal);
        spdialog = this;
        initComponents();
    }
    
    @Action
    public void login() {
        user = jTextField1.getText();
        JOptionPane.showMessageDialog(this, "登陆成功！");
    }
    
    @Action
    public Task reload() {
        return new RefreshTask(user);
    }
    
    private class RefreshTask extends ChaXunTask {

        BindingGroup bindingGroup = new BindingGroup();

        RefreshTask(String user) {
            super(user);
        }

        @Override
        public void onSucceeded(Object object) {

            if (object instanceof Exception) {
                Exception e = (Exception) object;
                AssetMessage.ERRORSYS(e.getMessage());
                logger.error(e);
                return;
            }

            CaiGouShenQingFindEntity sq = (CaiGouShenQingFindEntity) object;

            if (sq != null && sq.getShenQing().size() > 0) {
                count = sq.getCount();
//                jLabelTotal.setText(((pageIndex - 1) * UserTask.pageSize + 1) + "/" + count);
                logger.debug("total:" + count + ",get user size:" +  sq.getShenQing().size());

                //存下所有的数据
                cgsq =  sq.getShenQing();
                
                BindTableHelper<ZiChanCaiGouShenQing> bindTable = new BindTableHelper<ZiChanCaiGouShenQing>(jSQTable, cgsq);
                bindTable.createTable(new String[][]{{"cgsqId", "采购单号"}, {"gdzcId", "资产信息"}, {"quantity", "数量"}, {"price", "单价"},{"processId", "流程编号"}});
                bindTable.setIntegerType(1);
                bindTable.bind().setColumnWidth(new int[]{0, 100}, new int[]{1, 100}, new int[]{2, 100}, new int[]{3, 100}).setRowHeight(30);;
            }
        }
    }
    
    @Action
    public Task shenPiY(){
        ZiChanCaiGouShenQing cgsqdan = cgsq.get(jSQTable.getSelectedRow());
        shenPiEntity = new ShenPiEntity();
        shenPiEntity.setId(cgsqdan.getCgsqId().toString());
        shenPiEntity.setResult("同意");
        shenPiEntity.setUser(user);
        cgsq.remove(jSQTable.getSelectedRow());
        return new SPTask(shenPiEntity);
    }
    
    @Action
    public Task shenPiN(){
        ZiChanCaiGouShenQing cgsqdan = cgsq.get(jSQTable.getSelectedRow());
        shenPiEntity = new ShenPiEntity();
        shenPiEntity.setId(cgsqdan.getCgsqId().toString());
        shenPiEntity.setResult("拒绝");
        shenPiEntity.setUser(user);
        cgsq.remove(jSQTable.getSelectedRow());
        return new SPTask(shenPiEntity);
    }
    
    private class SPTask extends ShenPiTask{

        public SPTask(ShenPiEntity sp) {
            super(sp);
        }
        
        @Override
        protected void succeeded(Object result){
            JOptionPane.showMessageDialog(null, "审批成功！");
            spdialog.reload();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSQTable = new BaseTable(null);
        ctrlPane = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        jPanel2.setMinimumSize(new java.awt.Dimension(796, 577));
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jSQTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jSQTable.setColumnSelectionAllowed(true);
        jSQTable.setName("jSQTable"); // NOI18N
        jScrollPane1.setViewportView(jSQTable);
        jSQTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        ctrlPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ctrlPane.setName("ctrlPane"); // NOI18N
        ctrlPane.setPreferredSize(new java.awt.Dimension(796, 30));

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(ShenQingShenPiJDialog.class, this);
        jButton11.setAction(actionMap.get("shenPiN")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(ShenQingShenPiJDialog.class);
        jButton11.setText(resourceMap.getString("jButton11.text")); // NOI18N
        jButton11.setName("jButton11"); // NOI18N

        jButton12.setAction(actionMap.get("shenPiY")); // NOI18N
        jButton12.setText(resourceMap.getString("jButton12.text")); // NOI18N
        jButton12.setName("jButton12"); // NOI18N

        jButton13.setText(resourceMap.getString("jButton13.text")); // NOI18N
        jButton13.setName("jButton13"); // NOI18N

        jButton14.setText(resourceMap.getString("jButton14.text")); // NOI18N
        jButton14.setName("jButton14"); // NOI18N

        jButton15.setText(resourceMap.getString("jButton15.text")); // NOI18N
        jButton15.setName("jButton15"); // NOI18N

        jButton2.setAction(actionMap.get("login")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton1.setAction(actionMap.get("reload")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout ctrlPaneLayout = new javax.swing.GroupLayout(ctrlPane);
        ctrlPane.setLayout(ctrlPaneLayout);
        ctrlPaneLayout.setHorizontalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPaneLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addGap(2, 2, 2)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addGap(10, 10, 10)
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        ctrlPaneLayout.setVerticalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ctrlPaneLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton15)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addComponent(ctrlPane, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ctrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 817, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShenQingShenPiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShenQingShenPiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShenQingShenPiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShenQingShenPiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShenQingShenPiJDialog dialog = new ShenQingShenPiJDialog(new javax.swing.JFrame(),true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ctrlPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jSQTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}