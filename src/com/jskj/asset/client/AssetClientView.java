/*
 * AssetClientView.java
 */
package com.jskj.asset.client;

import com.jskj.asset.client.constants.Constants;
import com.jskj.asset.client.panel.MainWorkPane;
import org.jdesktop.application.FrameView;
import javax.swing.JProgressBar;
import org.apache.log4j.Logger;
import org.jdesktop.application.Application;
import org.jdesktop.application.Task;
//import sun.swing.SwingAccessor;

/**
 * The application's main frame.
 */
public final class AssetClientView extends FrameView {

    private final static Logger logger = Logger.getLogger(AssetClientView.class);

    public AssetClientView(Application app) {
        super(app);
        initComponents();
    }

    public Task loadMoudule() {
        return new LoadModule(menuBar);
    }
    
    public void setMessage(String message){
        messageLabel.setText(message);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        taskMessagePanel = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(AssetClientView.class);
        mainPanel.setBackground(resourceMap.getColor("mainPanel.background")); // NOI18N
        mainPanel.setName("mainPanel"); // NOI18N

        taskMessagePanel.setBackground(resourceMap.getColor("taskMessagePanel.background")); // NOI18N
        taskMessagePanel.setName("taskMessagePanel"); // NOI18N

        messageLabel.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(0, 102, 204));
        messageLabel.setName("messageLabel"); // NOI18N

        org.jdesktop.layout.GroupLayout taskMessagePanelLayout = new org.jdesktop.layout.GroupLayout(taskMessagePanel);
        taskMessagePanel.setLayout(taskMessagePanelLayout);
        taskMessagePanelLayout.setHorizontalGroup(
            taskMessagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(taskMessagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(messageLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );
        taskMessagePanelLayout.setVerticalGroup(
            taskMessagePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(messageLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(taskMessagePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .add(taskMessagePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 286, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N
        menuBar.setPreferredSize(new java.awt.Dimension(0, 25));

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        org.jdesktop.layout.GroupLayout statusPanelLayout = new org.jdesktop.layout.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .add(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(statusMessageLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 372, Short.MAX_VALUE)
                .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(statusPanelLayout.createSequentialGroup()
                .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(statusMessageLabel)
                    .add(statusAnimationLabel)
                    .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    /**
     * 显示面板主要的内容
     */
    public void displayMainView() {
        MainViewPane = new MainWorkPane();
        mainPanel.add(MainViewPane);
        mainPanel.repaint();
        mainPanel.validate();

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(taskMessagePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .add(getMainViewPane(), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, mainPanelLayout.createSequentialGroup()
                        .add(taskMessagePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(getMainViewPane(), org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getMainViewPane().changeTreeView(Constants.VIEW_TABLES_TREE);//初始化左边树
        getMainViewPane().reload().execute();
    }

    /**
     * @return the MainViewPane
     */
    public MainWorkPane getMainViewPane() {
        return MainViewPane;
    }

    /**
     * @param MainViewPane the MainViewPane to set
     */
    public void setMainViewPane(MainWorkPane MainViewPane) {
        this.MainViewPane = MainViewPane;
    }

    public void setStatus(String text, int messageType) {
        statusMessageLabel.setText(text);
      // ImageIcon icon = new ImageIcon(this.getClass().getResource("/com/jskj/asset/client/resources/icon.png"));
        // statusMessageLabel.setIcon(icon);
        Thread one1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    statusMessageLabel.setText("");
                    statusMessageLabel.setIcon(null);
                } catch (InterruptedException ex) {
                }
            }

        });
        one1.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel taskMessagePanel;
    // End of variables declaration//GEN-END:variables

    private MainWorkPane MainViewPane;
}
