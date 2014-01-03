/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NoFoundPanel.java
 *
 * Created on Feb 21, 2010, 10:42:18 PM
 */
package com.jskj.asset.client.panel.ymgl;

import com.jskj.asset.client.panel.slgl.*;
import com.jskj.asset.client.AssetClientApp;
import com.jskj.asset.client.panel.*;
import com.jskj.asset.client.layout.BasePanel;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author woderchen
 */
public class MainPanel extends BasePanel {

    private selecteInvoiceJDialog selecteInvoiceJDialog;
    private selecteInvoiceJDialog2 selecteInvoiceJDialog2;
    private selecteInvoiceJDialog3 selecteInvoiceJDialog3;

    /**
     * Creates new form NoFoundPane
     */
    public MainPanel() {
        super();
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setName("Form"); // NOI18N

        ctrlPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ctrlPane.setName("ctrlPane"); // NOI18N

        javax.swing.GroupLayout ctrlPaneLayout = new javax.swing.GroupLayout(ctrlPane);
        ctrlPane.setLayout(ctrlPaneLayout);
        ctrlPaneLayout.setHorizontalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        ctrlPaneLayout.setVerticalGroup(
            ctrlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(MainPanel.class, this);
        jButton1.setAction(actionMap.get("selecteInvoice3Action")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(MainPanel.class);
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("selecteInvoiceAction")); // NOI18N
        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setName("jButton2"); // NOI18N

        jButton3.setAction(actionMap.get("selecteInvoice2Action")); // NOI18N
        jButton3.setIcon(resourceMap.getIcon("jButton3.icon")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jButton4.setAction(actionMap.get("yiMiaoYanShouAction")); // NOI18N
        jButton4.setIcon(resourceMap.getIcon("jButton4.icon")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N

        jButton5.setAction(actionMap.get("YiMiaoBaoSunShenHeAction")); // NOI18N
        jButton5.setIcon(resourceMap.getIcon("jButton5.icon")); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ctrlPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ctrlPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void selecteInvoiceAction() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (selecteInvoiceJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    selecteInvoiceJDialog = new selecteInvoiceJDialog(new javax.swing.JFrame(), true);
                    selecteInvoiceJDialog.setLocationRelativeTo(mainFrame);
                }
                AssetClientApp.getApplication().show(selecteInvoiceJDialog);
            }
        });
    }

    @Action

    public void selecteInvoice2Action() {
        if (selecteInvoiceJDialog2 == null) {
            JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
            selecteInvoiceJDialog2 = new selecteInvoiceJDialog2(new javax.swing.JFrame(), true);
            selecteInvoiceJDialog2.setLocationRelativeTo(mainFrame);
        }
        AssetClientApp.getApplication().show(selecteInvoiceJDialog2);
    }

    @Action
    public void selecteInvoice3Action() {
        if (selecteInvoiceJDialog3 == null) {
            JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
            selecteInvoiceJDialog3 = new selecteInvoiceJDialog3(new javax.swing.JFrame(), true);
            selecteInvoiceJDialog3.setLocationRelativeTo(mainFrame);
        }
        AssetClientApp.getApplication().show(selecteInvoiceJDialog3);
    }

//    @Action
//    public void selecteInvoice3Action() {
//        if (selecteInvoiceJDialog3 == null) {
//            JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
//            selecteInvoiceJDialog3 = new selecteInvoiceJDialog3(new javax.swing.JFrame(), true);
//            selecteInvoiceJDialog3.setLocationRelativeTo(mainFrame);
//        }
//        AssetClientApp.getApplication().show(selecteInvoiceJDialog3);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ctrlPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    @Override
    public Task reload() {
        return null;
    }

    @Override
    public Task reload(Object param) {
        return null;
    }

    @Action
    public void YiMiaoBaoSunShenHeAction() {
        SwingUtilities.invokeLater(new Runnable() {
            private YiMiaoBaoSunShenHeJDialog yiMiaoBaoSunShenHeJDialog;

            public void run() {
                if (yiMiaoBaoSunShenHeJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    yiMiaoBaoSunShenHeJDialog = new YiMiaoBaoSunShenHeJDialog(new javax.swing.JFrame(), true);
                    yiMiaoBaoSunShenHeJDialog.setLocationRelativeTo(mainFrame);
                }
                AssetClientApp.getApplication().show(yiMiaoBaoSunShenHeJDialog);
            }

        });
    }

    @Action
    public void yiMiaoYanShouAction() {
        SwingUtilities.invokeLater(new Runnable() {
            private YiMiaoYanShouDanJDialog yiMiaoYanShouJDialog;

            public void run() {
                if (yiMiaoYanShouJDialog == null) {
                    JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                    yiMiaoYanShouJDialog = new YiMiaoYanShouDanJDialog(new javax.swing.JFrame(), true);
                    yiMiaoYanShouJDialog.setLocationRelativeTo(mainFrame);
                }
                yiMiaoYanShouJDialog.setAddOrUpdate(true);
                AssetClientApp.getApplication().show(yiMiaoYanShouJDialog);
            }
        });

    }
}
