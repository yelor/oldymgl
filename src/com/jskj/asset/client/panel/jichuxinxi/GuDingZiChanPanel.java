/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jskj.asset.client.panel.jichuxinxi;

import com.jskj.asset.client.AssetClientApp;
import com.jskj.asset.client.bean.entity.GudingzichanAll;
import com.jskj.asset.client.bean.entity.GudingzichanFindEntity;
import com.jskj.asset.client.bean.entity.Gudingzichantb;
import com.jskj.asset.client.layout.AssetMessage;
import com.jskj.asset.client.layout.BasePanel;
import com.jskj.asset.client.layout.ITableHeaderPopupBuilder;
import com.jskj.asset.client.layout.ws.ComResponse;
import com.jskj.asset.client.layout.ws.CommUpdateTask;
import com.jskj.asset.client.panel.jichuxinxi.task.GudingzichanFindTask;
import com.jskj.asset.client.util.BindTableHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author huiqi
 */
public class GuDingZiChanPanel extends BasePanel {

    private final static Logger logger = Logger.getLogger(GuDingZiChanPanel.class);

    private int pageIndex;
    public int pageSize;
    private int count;
    private String conditionSql;
    private List<GudingzichanAll> currentPageData;

    private final BindTableHelper<GudingzichanAll> bindTable;

    /**
     * Creates new form YiMiaoJDialog
     */
    public GuDingZiChanPanel() {
        super();
        initComponents();
        conditionSql = "";
        pageIndex = 1;
        pageSize = 20;
        count = 0;
        bindTable = new BindTableHelper<GudingzichanAll>(jTable1, new ArrayList<GudingzichanAll>());
        bindTable.createTable(new String[][]{{"gdzcId", "固定资产编号"}, {"gdzcName", "固定资产名称"}, {"gdzcType", "资产类型"}, {"gdzcGuige", "规格"},
        {"gdzcXinghao", "型号"}, {"unitId", "单位"}, {"kucunshangxian", "库存上限"}, {"kucunxiaxian", "库存下限"}, {"gdzcSequence", "条形码"}});
        bindTable.setColumnType(Integer.class, 1);
        bindTable.bind().setColumnWidth(new int[]{0, 100}, new int[]{1, 100}, new int[]{2, 100}, new int[]{3, 80}).setRowHeight(30);

        bindTable.createHeaderFilter(new ITableHeaderPopupBuilder() {

            @Override
            public int[] getFilterColumnHeader() {
                //那些列需要有查询功能，这样就可以点击列头弹出一个popup
                return new int[]{0,1, 2, 3, 4,8};
            }

            @Override
            public Task filterData(HashMap<Integer, String> searchKeys) {

                if (searchKeys.size() > 0) {
                    StringBuilder sql = new StringBuilder();
                    if (!searchKeys.get(0).trim().equals("")) {
                        sql.append("gdzc_id =").append(searchKeys.get(0).trim()).append(" and ");
                    }
                    if (!searchKeys.get(1).trim().equals("")) {
                        sql.append("gdzc_name like \"%").append(searchKeys.get(1).trim()).append("%\"").append(" and ");
                    }
                    if (!searchKeys.get(2).trim().equals("")) {
                        sql.append("gdzc_type like \"%").append(searchKeys.get(2).trim()).append("%\"").append(" and ");
                    }
                    if (!searchKeys.get(3).trim().equals("")) {
                        sql.append("gdzc_guige like \"%").append(searchKeys.get(3).trim()).append("%\"").append(" and ");
                    }
                    if (!searchKeys.get(4).trim().equals("")) {
                        sql.append("gdzc_xinghao like \"%").append(searchKeys.get(4).trim()).append("%\"").append(" and ");
                    }
                    if (sql.length() > 0) {
                        sql.delete(sql.length() - 5, sql.length() - 1);
                    }
                     if (!searchKeys.get(8).trim().equals("")) {
                        sql.append("gdzc_sequence = ").append(searchKeys.get(8).trim()).append(" and ");
                    }
                    conditionSql = sql.toString();
                } else {
                    conditionSql = "";
                }

                return reload();
            }

        });
    }

    private class RefreshTask extends GudingzichanFindTask {

        RefreshTask(int pageIndex, int pageSize) {
            super(pageIndex, pageSize, "gdzc", conditionSql);
        }

        @Override
        public void responseResult(GudingzichanFindEntity response) {
            count = response.getCount();
            jLabelTotal.setText(((pageIndex - 1) * pageSize + 1) + "/" + count);
            logger.debug("total:" + count + ",get total size:" + response.getResult().size());

            //存下所有的数据
            currentPageData = response.getResult();
            bindTable.refreshData(currentPageData);
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

        ctrlPane = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setName("Form"); // NOI18N

        ctrlPane.setName("ctrlPane"); // NOI18N

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setOpaque(false);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(GuDingZiChanPanel.class, this);
        jButton6.setAction(actionMap.get("addGuDingZhiChan")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(GuDingZiChanPanel.class);
        jButton6.setIcon(resourceMap.getIcon("jButton6.icon")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.setName("jButton6"); // NOI18N
        jButton6.setOpaque(false);
        jToolBar1.add(jButton6);

        jButton7.setAction(actionMap.get("updateGuDingZhiChan")); // NOI18N
        jButton7.setIcon(resourceMap.getIcon("jButton7.icon")); // NOI18N
        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.setName("jButton7"); // NOI18N
        jButton7.setOpaque(false);
        jToolBar1.add(jButton7);

        jButton8.setAction(actionMap.get("delete")); // NOI18N
        jButton8.setIcon(resourceMap.getIcon("jButton8.icon")); // NOI18N
        jButton8.setText(resourceMap.getString("jButton8.text")); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.setName("jButton8"); // NOI18N
        jButton8.setOpaque(false);
        jToolBar1.add(jButton8);

        jButton4.setAction(actionMap.get("reload")); // NOI18N
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

        jButton3.setAction(actionMap.get("print")); // NOI18N
        jButton3.setIcon(resourceMap.getIcon("jButton3.icon")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setOpaque(false);
        jToolBar1.add(jButton3);

        jButton2.setAction(actionMap.get("print")); // NOI18N
        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setOpaque(false);
        jToolBar1.add(jButton2);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setBorderPainted(false);
        jToolBar2.setName("jToolBar2"); // NOI18N
        jToolBar2.setOpaque(false);

        jButton10.setAction(actionMap.get("pagePrev")); // NOI18N
        jButton10.setText(resourceMap.getString("jButton10.text")); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMaximumSize(new java.awt.Dimension(60, 25));
        jButton10.setMinimumSize(new java.awt.Dimension(60, 25));
        jButton10.setName("jButton10"); // NOI18N
        jButton10.setOpaque(false);
        jButton10.setPreferredSize(new java.awt.Dimension(60, 25));
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton10);

        jButton11.setAction(actionMap.get("pageNext")); // NOI18N
        jButton11.setText(resourceMap.getString("jButton11.text")); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMaximumSize(new java.awt.Dimension(60, 25));
        jButton11.setMinimumSize(new java.awt.Dimension(60, 25));
        jButton11.setName("jButton11"); // NOI18N
        jButton11.setOpaque(false);
        jButton11.setPreferredSize(new java.awt.Dimension(60, 25));
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton11);

        jLabelTotal.setForeground(resourceMap.getColor("jLabelTotal.foreground")); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText(resourceMap.getString("jLabelTotal.text")); // NOI18N
        jLabelTotal.setName("jLabelTotal"); // NOI18N

        javax.swing.GroupLayout ctrlPaneLayout = new javax.swing.GroupLayout(ctrlPane);
        ctrlPane.setLayout(ctrlPaneLayout);
        ctrlPaneLayout.setHorizontalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPaneLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ctrlPaneLayout.setVerticalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1.columnModel.title5")); // NOI18N
            jTable1.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1.columnModel.title2")); // NOI18N
            jTable1.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1.columnModel.title3")); // NOI18N
            jTable1.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTable1.columnModel.title4")); // NOI18N
            jTable1.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTable1.columnModel.title6")); // NOI18N
            jTable1.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("jTable1.columnModel.title7")); // NOI18N
            jTable1.getColumnModel().getColumn(8).setHeaderValue(resourceMap.getString("jTable1.columnModel.title8")); // NOI18N
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ctrlPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ctrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(GuDingZiChanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuDingZiChanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuDingZiChanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuDingZiChanPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                GuDingZiChanJDialog dialog = new GuDingZiChanJDialog(new javax.swing.JFrame(), true);
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
    public void addGuDingZhiChan() {
        SwingUtilities.invokeLater(new Runnable() {
            private GuDingZiChanInfoJDialog guDingZhiChanInfoJDialog;

            @Override
            public void run() {
                if (guDingZhiChanInfoJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    guDingZhiChanInfoJDialog = new GuDingZiChanInfoJDialog(GuDingZiChanPanel.this);
                    guDingZhiChanInfoJDialog.setLocationRelativeTo(mainFrame);
                }
                guDingZhiChanInfoJDialog.setUpdatedData(new GudingzichanAll());
                AssetClientApp.getApplication().show(guDingZhiChanInfoJDialog);
            }
        });
    }

    @Action
    public void updateGuDingZhiChan() {
        Gudingzichantb dps = selectedDataFromTable();
        if (dps == null) {
            AssetMessage.ERRORSYS("请选择一条数据!");
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {
            private GuDingZiChanInfoJDialog guDingZhiChanInfoJDialog;

            @Override
            public void run() {
                if (guDingZhiChanInfoJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    guDingZhiChanInfoJDialog = new GuDingZiChanInfoJDialog(GuDingZiChanPanel.this);
                    guDingZhiChanInfoJDialog.setLocationRelativeTo(mainFrame);
                }
                guDingZhiChanInfoJDialog.setUpdatedData(selectedDataFromTable());
                AssetClientApp.getApplication().show(guDingZhiChanInfoJDialog);
            }
        });
    }

    @Action
    public Task delete() {
        GudingzichanAll selectedData = selectedDataFromTable();
        if (selectedData == null) {
            AssetMessage.ERRORSYS("请选择一条数据!");
            return null;
        }
        int result = AssetMessage.CONFIRM("确定删除数据:" + selectedData.getGdzcName());
        if (result == JOptionPane.OK_OPTION) {
            return new CommUpdateTask<GudingzichanAll>(selectedData, "gdzc/delete/" + selectedData.getGdzcId()) {
                @Override
                public void responseResult(ComResponse<GudingzichanAll> response) {
                    if (response.getResponseStatus() == ComResponse.STATUS_OK) {
                        reload().execute();
                    } else {
                        AssetMessage.ERROR(response.getErrorMessage(), GuDingZiChanPanel.this);
                    }
                }

            };
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ctrlPane;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables

    @Override
    @Action
    public Task reload() {
        return new RefreshTask(0, 20);
    }

    @Override
    public Task reload(Object param) {
        return null;
    }

    @Action
    public void pagePrev() {
        pageIndex = pageIndex - 1;
        pageIndex = pageIndex <= 0 ? 1 : pageIndex;
        new RefreshTask(pageIndex, pageSize).execute();
    }

    @Action
    public void pageNext() {
        if (pageSize * (pageIndex) <= count) {
            pageIndex = pageIndex + 1;
        }
        new RefreshTask(pageIndex, pageSize).execute();
    }

    public List<GudingzichanAll> getTableData() {
        return currentPageData;
    }

    public GudingzichanAll selectedDataFromTable() {
        if (jTable1.getSelectedRow() >= 0) {
            if (currentPageData != null) {
                return currentPageData.get(jTable1.getSelectedRow());
            }
        }
        return null;
    }

    @Action
    public Task print() {
        GudingzichanFindTask printData = new GudingzichanFindTask(0, count, "gdzc/", conditionSql) {
            @Override
            public void responseResult(GudingzichanFindEntity response) {
                bindTable.createPrinter("固定资产", response.getResult()).buildInBackgound().execute();
            }
        };
        return printData;
    }

}
