/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jskj.asset.client.panel.jichuxinxi;

import com.jskj.asset.client.AssetClientApp;
import com.jskj.asset.client.bean.entity.UsertbAll;
import com.jskj.asset.client.bean.entity.YiMiaotb;
import com.jskj.asset.client.bean.entity.YiMiaotbFindEntity;
import com.jskj.asset.client.layout.AssetMessage;
import com.jskj.asset.client.layout.BasePanel;
import com.jskj.asset.client.panel.jichuxinxi.task.YiMiaoTask;
import com.jskj.asset.client.panel.jichuxinxi.task.YiMiaoUpdateTask;
import com.jskj.asset.client.util.BindTableHelper;
import java.util.ArrayList;
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
public class YiMiaoPanel extends BasePanel {

    private final static Logger logger = Logger.getLogger(YiMiaoPanel.class);
    private YiMiaoInfoJDialog yiMiaoInfoJDialog;

    private final YiMiaoPanel yiMiaoJDialog;

    private int pageIndex;

    private int count;

    private List<YiMiaotb> yimiaos;

    private YiMiaotb yimiao;

    private final BindTableHelper<YiMiaotb> bindTable;
              /**
             * Creates new form YiMiaoJDialog
             */

    public YiMiaoPanel() {
        super();
        initComponents();
        yiMiaoJDialog = this;
        pageIndex = 1;
        count = 0;

        bindTable = new BindTableHelper<YiMiaotb>(jTableYiMiao, new ArrayList<YiMiaotb>());
        bindTable.createTable(new String[][]{{"yimiaoId", "疫苗编号"}, {"yimiaoName", "疫苗名称"}, {"yimiaoType", "疫苗类别"}, {"yimiaoGuige", "规格"}, {"yimiaoJixing", "剂型"}, {"yimiaoId", "单位"}, {"yimiaoStockdown", "库存下限"}, {"yimiaoStockup", "库存上限"}, {"yimiaoTiaoxingma", "条形码"}});
        bindTable.setIntegerType(1);
        bindTable.bind().setColumnWidth(new int[]{0, 80}).setRowHeight(30);;
    }

    @Action
    @Override
    public Task reload() {
        return new RefureTask(0);
    }

    private YiMiaotb selectedYiMiao() {
        if (jTableYiMiao.getSelectedRow() >= 0) {
            if (yimiaos != null) {
                return yimiaos.get(jTableYiMiao.getSelectedRow());
            }
        }
        return null;
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
        jTableYiMiao = new javax.swing.JTable();

        setName("Form"); // NOI18N

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setOpaque(false);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(YiMiaoPanel.class, this);
        jButton6.setAction(actionMap.get("addYiMiao")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(YiMiaoPanel.class);
        jButton6.setIcon(resourceMap.getIcon("jButton6.icon")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.setName("jButton6"); // NOI18N
        jButton6.setOpaque(false);
        jToolBar1.add(jButton6);

        jButton7.setAction(actionMap.get("updateYiMiao")); // NOI18N
        jButton7.setIcon(resourceMap.getIcon("jButton7.icon")); // NOI18N
        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.setName("jButton7"); // NOI18N
        jButton7.setOpaque(false);
        jToolBar1.add(jButton7);

        jButton8.setIcon(resourceMap.getIcon("jButton8.icon")); // NOI18N
        jButton8.setText(resourceMap.getString("jButton8.text")); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.setName("jButton8"); // NOI18N
        jToolBar1.add(jButton8);

        jButton4.setAction(actionMap.get("reflesh")); // NOI18N
        jButton4.setIcon(resourceMap.getIcon("jButton4.icon")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setOpaque(false);
        jToolBar1.add(jButton4);

        jButton5.setIcon(resourceMap.getIcon("jButton5.icon")); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setName("jButton5"); // NOI18N
        jButton5.setOpaque(false);
        jToolBar1.add(jButton5);

        jButton3.setIcon(resourceMap.getIcon("jButton3.icon")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setOpaque(false);
        jToolBar1.add(jButton3);

        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setOpaque(false);
        jToolBar1.add(jButton2);

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setOpaque(false);
        jToolBar1.add(jButton1);

        jButton9.setAction(actionMap.get("exit")); // NOI18N
        jButton9.setIcon(resourceMap.getIcon("jButton9.icon")); // NOI18N
        jButton9.setText(resourceMap.getString("jButton9.text")); // NOI18N
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton9.setName("jButton9"); // NOI18N
        jButton9.setOpaque(false);
        jToolBar1.add(jButton9);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTableYiMiao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableYiMiao.setName("jTableYiMiao"); // NOI18N
        jScrollPane2.setViewportView(jTableYiMiao);
        if (jTableYiMiao.getColumnModel().getColumnCount() > 0) {
            jTableYiMiao.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title0")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title1")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title2")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title3")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title4")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title5")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title6")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title7")); // NOI18N
            jTableYiMiao.getColumnModel().getColumn(8).setHeaderValue(resourceMap.getString("jTableYiMiao.columnModel.title8")); // NOI18N
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
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
            java.util.logging.Logger.getLogger(YiMiaoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YiMiaoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YiMiaoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YiMiaoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                YiMiaoJDialog dialog = new YiMiaoJDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    @Action
    public void addYiMiao() {
        SwingUtilities.invokeLater(new Runnable() {
            private YiMiaoInfoJDialog yiMiaoInfoJDialog;

            @Override
            public void run() {
                if (yiMiaoInfoJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    yiMiaoInfoJDialog = new YiMiaoInfoJDialog();
                    yiMiaoInfoJDialog.setLocationRelativeTo(mainFrame);
                }
                yiMiaoInfoJDialog.setAddOrUpdate(true);
                AssetClientApp.getApplication().show(yiMiaoInfoJDialog);
            }
        });
    }

    @Action
    public void reflesh() {
        yiMiaoJDialog.reload().execute();
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
    private javax.swing.JTable jTableYiMiao;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public Task reload(Object param) {
        return null;
    }

    private class RefureTask extends YiMiaoTask {

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

            YiMiaotbFindEntity yimiaotbs = (YiMiaotbFindEntity) object;

            if (yimiaotbs != null && yimiaotbs.getResult().size() > 0) {
                count = yimiaotbs.getCount();
                //             jLabelTotal.setText(((pageIndex - 1) * YiMiaoTask.pageSize + 1) + "/" + count);
                logger.debug("total:" + count + ",get yimao size:" + yimiaotbs.getResult().size());

                //存下所有的数据
                yimiaos = yimiaotbs.getResult();

                bindTable.refreshData(yimiaos);
                
            }
        }
    }

    @Action
    public void updateYiMiao() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                YiMiaotb yimiao = selectedYiMiao();
                if (yimiao == null) {
                    AssetMessage.ERRORSYS("请选择疫苗!");
                    return;
                }

                if (yiMiaoInfoJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    yiMiaoInfoJDialog = new YiMiaoInfoJDialog();
                    yiMiaoInfoJDialog.setLocationRelativeTo(mainFrame);
                }

                yiMiaoInfoJDialog.setAddOrUpdate(false);
                yiMiaoInfoJDialog.setUpdatedData(yimiao);
                AssetClientApp.getApplication().show(yiMiaoInfoJDialog);
            }
        });
    }

    @Action
    public Task deleteYiMiaotb() {
        YiMiaotb yimiao = selectedYiMiao();
        if (yimiao == null) {
            AssetMessage.ERRORSYS("请选择疫苗!");
            return null;
        }
        int result = AssetMessage.CONFIRM("确定删除疫苗:" + yimiao.getYimiaoName());
        if (result == JOptionPane.OK_OPTION) {
            return new DeleteYiMiaotbTask(yimiao);
        }
        return null;
    }

    private class DeleteYiMiaotbTask extends YiMiaoUpdateTask {

        DeleteYiMiaotbTask(YiMiaotb yimiao) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to DeleteYiMiaotbTask fields, here.
            super(yimiao, ENTITY_DELETE);

        }

        @Override
        protected void succeeded(Object result) {
            yiMiaoJDialog.reload().execute();
        }
    }

    @Action
    public void exit() {

    }

    @Action
    public void refresh() {
        yiMiaoJDialog.reload().execute();
    }
}