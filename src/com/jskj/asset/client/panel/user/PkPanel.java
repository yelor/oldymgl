/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserPanel.java
 *
 * Created on Feb 21, 2010, 10:42:18 PM
 */
package com.jskj.asset.client.panel.user;

import com.jskj.asset.client.AssetClientApp;
import com.jskj.asset.client.layout.ws.CommFindEntity;
import com.jskj.asset.client.bean.entity.Pkgenerator;
import com.jskj.asset.client.layout.BasePanel;
import com.jskj.asset.client.layout.AssetMessage;
import com.jskj.asset.client.layout.BaseTable;
import com.jskj.asset.client.util.BindTableHelper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author woderchen
 */
public final class PkPanel extends BasePanel {

    private final static Logger logger = Logger.getLogger(PkPanel.class);

    private PkDialog childDialog;
    private int pageIndex;
    public int pageSize;
    private int count;

    private List<Pkgenerator> currentPageData;

    private final BindTableHelper<Pkgenerator> bindTable;

    /**
     * Creates new form NoFoundPane
     */
    public PkPanel() {
        super();
        initComponents();
        pageIndex = 1;
        pageSize = 10;
        count = 0;
        bindTable = new BindTableHelper<Pkgenerator>(jTableParam, new ArrayList<Pkgenerator>());
        bindTable.createTable(new String[][]{{"id", "ID"}, {"targettable", "数据库表"}, {"pkcolumnname", "字段"}, {"initialvalue", "初始化值"}, {"allocationsize", "递增值"}});
        bindTable.setColumnType(Integer.class, 1, 4, 5);
        bindTable.bind().setColumnWidth(new int[]{0, 50}, new int[]{1, 200}, new int[]{2, 200}, new int[]{3, 100}, new int[]{4, 100}).setRowHeight(25);
    }

    @Action
    @Override
    public Task reload() {
        return new RefreshTask(0, 1000);
    }

    @Override
    public Task reload(Object param) {
        return null;
    }

    private class RefreshTask extends PkFindTask {

        RefreshTask(int pageIndex, int pageSize) {
            super(pageIndex, pageSize, "pk/","");
        }

        @Override
        public void responseResult(CommFindEntity<Pkgenerator> response) {

            count = response.getCount();
            jLabelTotal.setText(((pageIndex - 1) * pageSize + 1) + "/" + count);
            logger.debug("total:" + count + ",get current size:" + response.getResult().size());

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
        jButton1 = new javax.swing.JButton();
        jButtonReload = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParam = new BaseTable(null);

        setName("Form"); // NOI18N

        ctrlPane.setName("ctrlPane"); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setOpaque(false);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(PkPanel.class, this);
        jButton1.setAction(actionMap.get("update")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(PkPanel.class);
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setOpaque(false);
        jToolBar1.add(jButton1);

        jButtonReload.setAction(actionMap.get("reload")); // NOI18N
        jButtonReload.setIcon(resourceMap.getIcon("jButtonReload.icon")); // NOI18N
        jButtonReload.setText(resourceMap.getString("jButtonReload.text")); // NOI18N
        jButtonReload.setBorderPainted(false);
        jButtonReload.setFocusable(false);
        jButtonReload.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonReload.setName("jButtonReload"); // NOI18N
        jButtonReload.setOpaque(false);
        jToolBar1.add(jButtonReload);

        jButtonPrint.setAction(actionMap.get("print")); // NOI18N
        jButtonPrint.setIcon(resourceMap.getIcon("jButtonPrint.icon")); // NOI18N
        jButtonPrint.setText(resourceMap.getString("jButtonPrint.text")); // NOI18N
        jButtonPrint.setBorderPainted(false);
        jButtonPrint.setFocusable(false);
        jButtonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonPrint.setName("jButtonPrint"); // NOI18N
        jButtonPrint.setOpaque(false);
        jToolBar1.add(jButtonPrint);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setBorderPainted(false);
        jToolBar2.setName("jToolBar2"); // NOI18N
        jToolBar2.setOpaque(false);

        jButton3.setAction(actionMap.get("pagePrev")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(60, 25));
        jButton3.setMinimumSize(new java.awt.Dimension(60, 25));
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setOpaque(false);
        jButton3.setPreferredSize(new java.awt.Dimension(60, 25));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton3);

        jButton4.setAction(actionMap.get("pageNext")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(60, 25));
        jButton4.setMinimumSize(new java.awt.Dimension(60, 25));
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setOpaque(false);
        jButton4.setPreferredSize(new java.awt.Dimension(60, 25));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton4);

        jLabelTotal.setForeground(resourceMap.getColor("jLabelTotal.foreground")); // NOI18N
        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotal.setText(resourceMap.getString("jLabelTotal.text")); // NOI18N
        jLabelTotal.setName("jLabelTotal"); // NOI18N

        javax.swing.GroupLayout ctrlPaneLayout = new javax.swing.GroupLayout(ctrlPane);
        ctrlPane.setLayout(ctrlPaneLayout);
        ctrlPaneLayout.setHorizontalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctrlPaneLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ctrlPaneLayout.setVerticalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTableParam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableParam.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableParam.setName("jTableParam"); // NOI18N
        jTableParam.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableParam);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ctrlPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ctrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void update() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Pkgenerator selectedData = selectedDataFromTable();
                if (selectedData == null) {
                    AssetMessage.ERRORSYS("请选择一条数据!");
                    return;
                }
                if (childDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    childDialog = new PkDialog(PkPanel.this);
                    childDialog.setLocationRelativeTo(mainFrame);
                }
                childDialog.setUpdatedData(selectedData);
                AssetClientApp.getApplication().show(childDialog);
            }
        });
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

    public List<Pkgenerator> getTableData() {
        return currentPageData;
    }

    public Pkgenerator selectedDataFromTable() {
        if (jTableParam.getSelectedRow() >= 0) {
            if (currentPageData != null) {
                return currentPageData.get(jTableParam.getSelectedRow());
            }
        }
        return null;
    }

    @Action
    public Task print() {
        PkFindTask printData = new PkFindTask(0, count, "pk/","") {
            @Override
            public void responseResult(CommFindEntity<Pkgenerator> response) {
                bindTable.createPrinter("系统参数配置信息", response.getResult()).buildInBackgound().execute();
            }
        };
        return printData;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ctrlPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableParam;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}