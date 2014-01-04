/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jskj.asset.client.panel.jichuxinxi;

import com.jskj.asset.client.AssetClientApp;
import com.jskj.asset.client.bean.entity.Supplier;
import com.jskj.asset.client.bean.entity.SupplierFindEntity;
import com.jskj.asset.client.layout.AssetMessage;
import com.jskj.asset.client.panel.jichuxinxi.task.SupplierTask;
import com.jskj.asset.client.panel.jichuxinxi.task.SupplierUpdateTask;
import com.jskj.asset.client.util.BindTableHelper;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.jdesktop.beansbinding.BindingGroup;

/**
 *
 * @author huiqi
 */
public class GongYingDanWeiJDialog extends javax.swing.JDialog {

    private final static Logger logger = Logger.getLogger(GongYingDanWeiJDialog.class);
    private int pageIndex;
    private int count;
    private List<Supplier> suppliers;
    private GongYingDanWeiJDialog gongYingDanWeiJDialog;
    private GongYingDanWeiInfoJDialog gongYingDanWeiInfoJDialog;

    /**
     * Creates new form YiMiaoJDialog
     */
    public GongYingDanWeiJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        new RefureTask(0).execute();
        gongYingDanWeiJDialog = this;
        pageIndex = 1;
        count = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSupplier = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(GongYingDanWeiJDialog.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(GongYingDanWeiJDialog.class, this);
        jButton6.setAction(actionMap.get("addGongYingDanWei")); // NOI18N
        jButton6.setIcon(resourceMap.getIcon("jButton6.icon")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.setName("jButton6"); // NOI18N
        jToolBar1.add(jButton6);

        jButton7.setAction(actionMap.get("updateDanWei")); // NOI18N
        jButton7.setIcon(resourceMap.getIcon("jButton7.icon")); // NOI18N
        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.setName("jButton7"); // NOI18N
        jToolBar1.add(jButton7);

        jButton8.setAction(actionMap.get("deleteSupplier")); // NOI18N
        jButton8.setIcon(resourceMap.getIcon("jButton8.icon")); // NOI18N
        jButton8.setText(resourceMap.getString("jButton8.text")); // NOI18N
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.setName("jButton8"); // NOI18N
        jToolBar1.add(jButton8);

        jButton4.setAction(actionMap.get("refresh")); // NOI18N
        jButton4.setIcon(resourceMap.getIcon("jButton4.icon")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setName("jButton4"); // NOI18N
        jToolBar1.add(jButton4);

        jButton5.setIcon(resourceMap.getIcon("jButton5.icon")); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setName("jButton5"); // NOI18N
        jToolBar1.add(jButton5);

        jButton3.setIcon(resourceMap.getIcon("jButton3.icon")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setName("jButton3"); // NOI18N
        jToolBar1.add(jButton3);

        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setName("jButton2"); // NOI18N
        jToolBar1.add(jButton2);

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setName("jButton1"); // NOI18N
        jToolBar1.add(jButton1);

        jButton9.setIcon(resourceMap.getIcon("jButton9.icon")); // NOI18N
        jButton9.setText(resourceMap.getString("jButton9.text")); // NOI18N
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton9.setName("jButton9"); // NOI18N
        jToolBar1.add(jButton9);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableSupplier.setName("jTableSupplier"); // NOI18N
        jScrollPane2.setViewportView(jTableSupplier);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(GongYingDanWeiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GongYingDanWeiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GongYingDanWeiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GongYingDanWeiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GongYingDanWeiJDialog dialog = new GongYingDanWeiJDialog(new javax.swing.JFrame(), true);
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

    @Action
    public void addGongYingDanWei() {
        SwingUtilities.invokeLater(new Runnable() {
            private GongYingDanWeiInfoJDialog gongYingDanWeiInfoJDialog;

            @Override
            public void run() {
                if (gongYingDanWeiInfoJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    gongYingDanWeiInfoJDialog = new GongYingDanWeiInfoJDialog(new javax.swing.JFrame(), true);
                    gongYingDanWeiInfoJDialog.setLocationRelativeTo(mainFrame);
                }
                gongYingDanWeiInfoJDialog.setAddOrUpdate(true);
                AssetClientApp.getApplication().show(gongYingDanWeiInfoJDialog);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSupplier;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private class RefureTask extends SupplierTask {

        BindingGroup bindingGroup = new BindingGroup();

        public RefureTask(int pageIndex) {
            super(pageIndex);
        }

        @Override
        public void onSucceeded(Object object) {
            if (object instanceof Exception) {
                Exception e = (Exception) object;
                AssetMessage.ERRORSYS(e.getMessage());
                logger.error(e);
                return;
            }

            SupplierFindEntity suppliertbs = (SupplierFindEntity) object;

            if (suppliertbs != null && suppliertbs.getSuppliers().size() > 0) {
                count = suppliertbs.getCount();
//                jLabelTotal.setText(((pageIndex - 1) * SupplierTask.pageSize + 1) + "/" + count);
                logger.debug("total:" + count + ",get supplier size:" + suppliertbs.getSuppliers().size());

                //存下所有的数据
                suppliers = suppliertbs.getSuppliers();

                BindTableHelper<Supplier> bindTable = new BindTableHelper<Supplier>(jTableSupplier, suppliers);
                bindTable.createTable(new String[][]{{"supplierId", "供应单位编号"}, {"supplierName", "供应单位名称"}, {"supplierConstactperson", "联系人"}, {"supplierPhone", "电话"}, {"supplierFax", "传真"}, {"supplierAddr", "单位地址"}, {"supplierRemark", "备注"}});
                bindTable.setIntegerType(1);
                bindTable.bind().setColumnWidth(new int[]{0, 100}).setRowHeight(30);
            }
        }

    }

    @Action
    public void refresh() {
        gongYingDanWeiJDialog.reload().execute();
    }
    @Action
    public Task reload() {
        return new RefureTask(0);
    }
    
        private Supplier selectedSupplier() {
        if (jTableSupplier.getSelectedRow() >= 0) {
            if (suppliers != null) {
                return suppliers.get(jTableSupplier.getSelectedRow());
            }
        }
        return null;
    }
    
      @Action
    public void updateDanWei() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Supplier supplier = selectedSupplier();
                if (supplier == null) {
                    AssetMessage.ERRORSYS("请选择供应单位!");
                    return;
                }

                if (gongYingDanWeiInfoJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    gongYingDanWeiInfoJDialog = new GongYingDanWeiInfoJDialog(new javax.swing.JFrame(), true);
                    gongYingDanWeiInfoJDialog.setLocationRelativeTo(mainFrame);
                }

                gongYingDanWeiInfoJDialog.setAddOrUpdate(false);
                gongYingDanWeiInfoJDialog.setUpdatedData(supplier);
                AssetClientApp.getApplication().show(gongYingDanWeiInfoJDialog);
            }
        });
    }

    @Action
    public Task deleteSupplier() {
        Supplier supplier = selectedSupplier();
        if (supplier == null) {
            AssetMessage.ERRORSYS("请选择供应单位!");
            return null;
        }
        int result = AssetMessage.CONFIRM("确定删除供应单位:" + supplier.getSupplierName());
        if (result == JOptionPane.OK_OPTION) {
            return new DeleteSupplierTask(supplier);
        }
        return null;
    }

    private class DeleteSupplierTask extends SupplierUpdateTask {

        DeleteSupplierTask(Supplier supplier) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to DeleteSupplierTask fields, here.
            super(supplier, ENTITY_DELETE);

        }

        @Override
        protected void succeeded(Object result) {
            gongYingDanWeiJDialog.reload().execute();
        }
    }
}
