/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jskj.asset.client.panel.ckgl;

import com.jskj.asset.client.AssetClientApp;
import com.jskj.asset.client.panel.slgl.GuDingZiChanChuKuJDialog;
import com.jskj.asset.client.panel.slgl.GuDingZiChanRuKuJDialog;
import com.jskj.asset.client.panel.slgl.YihaopinChuKuJDialog;
import com.jskj.asset.client.panel.slgl.YihaopinRuKuJDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jdesktop.application.Action;

/**
 *
 * @author Administrator
 */
public class SelectKucunchaxun extends javax.swing.JDialog {

    /**
     * Creates new form ymcrk
     */
    public SelectKucunchaxun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(SelectKucunchaxun.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(SelectKucunchaxun.class, this);
        jButton5.setAction(actionMap.get("zichanruku_pop")); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N

        jButton6.setAction(actionMap.get("zichanchuku_pop")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setName("jButton6"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(27, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(SelectKucunchaxun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectKucunchaxun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectKucunchaxun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectKucunchaxun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectKucunchaxun dialog = new SelectKucunchaxun(new javax.swing.JFrame(), true);
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
    public void ck1_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                YiMiaoChuKu1 ymck1 = new YiMiaoChuKu1(new javax.swing.JFrame(), true);
                ymck1.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(ymck1);
            }
        });
    }

    @Action
    public void rk1_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                YiMiaoRuKu1 ymrk1 = new YiMiaoRuKu1(new javax.swing.JFrame(), true);
                ymrk1.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(ymrk1);
            }
        });
    }

    @Action
    public void ck2_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                YiMiaoChuKu2 ymck2 = new YiMiaoChuKu2(new javax.swing.JFrame(), true);
                ymck2.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(ymck2);
            }
        });
    }

    @Action
    public void rk2_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                YiMiaoRuKu2 ymrk2 = new YiMiaoRuKu2(new javax.swing.JFrame(), true);
                ymrk2.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(ymrk2);
            }
        });
    }
    
    @Action
    public void zichanruku_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                GuDingZiChanRuKuJDialog zichanruku = new GuDingZiChanRuKuJDialog(new javax.swing.JFrame(), true);
                zichanruku.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(zichanruku);
            }
        });
    }
    
    @Action
    public void zichanchuku_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                GuDingZiChanChuKuJDialog zichanchuku = new GuDingZiChanChuKuJDialog(new javax.swing.JFrame(), true);
                zichanchuku.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(zichanchuku);
            }
        });
    }
    
    @Action
    public void yihaopinruku_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                YihaopinRuKuJDialog zichanruku = new YihaopinRuKuJDialog(new javax.swing.JFrame(), true);
                zichanruku.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(zichanruku);
            }
        });
    }
    
    @Action
    public void yihaopinchuku_pop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dispose();
                JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
                YihaopinChuKuJDialog zichanchuku = new YihaopinChuKuJDialog(new javax.swing.JFrame(), true);
                zichanchuku.setLocationRelativeTo(mainFrame);
                AssetClientApp.getApplication().show(zichanchuku);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    // End of variables declaration//GEN-END:variables
}
