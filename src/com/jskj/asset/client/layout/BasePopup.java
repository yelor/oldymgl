/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jskj.asset.client.layout;

import com.jskj.asset.client.util.BeanFactory;
import com.jskj.asset.client.util.BindTableHelper;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.List;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import org.apache.log4j.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author 305027939
 */
public class BasePopup extends BasePanel implements KeyListener {

    private final static Logger logger = Logger.getLogger(BasePopup.class);
    private String key;
    private String oldKey;
    private final PropertyChangeSupport changeSupport;
    private int pageIndex;
    private final int pageSize;
    private int count;
    private BindTableHelper<HashMap> bindTable;
    private final BaseTextFiled parentComponent;
    private final IPopupBuilder popBuilder;

    /**
     * Creates new form BasePopup
     *
     * @param parentComponent
     * @param popBuilder
     */
    public BasePopup(BaseTextFiled parentComponent, IPopupBuilder popBuilder) {
        initComponents();
        this.parentComponent = parentComponent;
        this.popBuilder = popBuilder;

        // setBorder(BorderFactory.createLineBorder(Color.blue));
        jPanelTop.setBackground(new Color(160, 185, 215));
        pageIndex = 1;
        pageSize = 10;
        count = 0;
        key = "";
        oldKey = "";
        bindTable = null;
        changeSupport = new PropertyChangeSupport(this);
        changeSupport.addPropertyChangeListener("KEY_CHANGE", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                logger.debug("BasePopup KEY_CHANGE");
                if (evt.getNewValue() != null) {
                    String key = evt.getNewValue().toString();
                    logger.debug("BasePopup run FindDataTask.");
                    new FindDataTask(1).execute();

                }
            }

        });
        jTableResult.setSelectionMode(SINGLE_SELECTION);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("@@@@@@@@@@@@@:up");
            int selectedrow = jTableResult.getSelectedRow();
            int upRow = selectedrow - 1;
            if (upRow < 0) {
                jTableResult.setRowSelectionInterval(upRow, upRow);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("@@@@@@@@@@@@@:down");
            int selectedrow = jTableResult.getSelectedRow();
            int upRow = selectedrow + 1;
            if (upRow > jTableResult.getRowCount()) {
                jTableResult.setRowSelectionInterval(upRow, upRow);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (bindTable != null) {
                HashMap map = bindTable.getSelectedBean();
                popBuilder.setBindedMap(map);
                parentComponent.hidePanel();
            }
        }

    }

    public void keyReleased(KeyEvent e) {

    }

    private class FindDataTask extends BaseTask {

        private int pageIndex = 1;

        public FindDataTask(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        @Override
        public Object doBackgrounp() {
            jLabelTotal.setText("正在查询相关结果...");
            if (popBuilder.getWebServiceURI() != null && !popBuilder.getWebServiceURI().trim().equals("")) {
                try {
                    //使用Spring3 RESTful client来获取http数据
                    RestTemplate restTemplate = (RestTemplate) BeanFactory.instance().createBean(RestTemplate.class);
  
                    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(popBuilder.getWebServiceURI())
                            .queryParam("pagesize", pageSize).queryParam("pageindex", pageIndex);

                    String sql = popBuilder.getConditionSQL();
                    if (sql != null && !sql.trim().equals("")) {
                        builder.queryParam("conditionSql", sql);
                    }

                    HashMap result = restTemplate.getForObject(builder.build().toUri(), HashMap.class);
                    return result;
                } catch (Exception e) {
                    return e;
                }
            }
            return null;
        }

        @Override
        public void onSucceeded(Object object) {
            if (object != null) {
                if (object instanceof Exception) {
                    Exception e = (Exception) object;
                    AssetMessage.ERRORSYS(e.getMessage());
                    logger.error(e);
                }

                if (object instanceof HashMap) {
                    HashMap sourceData = (HashMap) object;
                    Object countObj = sourceData.get("count");
                    Object resultObj = sourceData.get("result");
                    count = countObj == null ? 0 : Integer.parseInt(countObj.toString());
                    jLabelTotal.setText((((pageIndex - 1) * pageSize) + 1) + "/" + count);
                    if (resultObj != null) {
                        if (resultObj instanceof List) {
                            List resultList = (List) resultObj;
                            bindTable = new BindTableHelper<HashMap>(jTableResult, resultList);
                            bindTable.createTable(popBuilder.displayColumns());
                            bindTable.bind();
                            if (resultList.size() > 0) {
                                jTableResult.setRowSelectionInterval(0, 0);
                            }
                        }
                    }
                    return;
                }

            }
            jLabelTotal.setText("");
        }

    }

    @Action
    public void pagePrev() {
        pageIndex = pageIndex - 1;
        pageIndex = pageIndex <= 0 ? 1 : pageIndex;
        new FindDataTask(pageIndex).execute();
    }

    @Action
    public void pageNext() {
        if (pageSize * (pageIndex) <= count) {
            pageIndex = pageIndex + 1;
        }
        new FindDataTask(pageIndex).execute();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();
        jPanelTop = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        prepPageBubtton = new javax.swing.JButton();
        nextPageButton = new javax.swing.JButton();

        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTableResult.setAutoCreateRowSorter(true);
        jTableResult.setFont(new java.awt.Font("宋体", 0, 12)); // NOI18N
        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jTableResult.setFocusable(false);
        jTableResult.setName("jTableResult"); // NOI18N
        jTableResult.setRowHeight(30);
        jTableResult.setShowVerticalLines(false);
        jTableResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResultMouseClicked(evt);
            }
        });
        jTableResult.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTableResultMouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(jTableResult);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );

        jPanelTop.setName("jPanelTop"); // NOI18N

        jLabelTotal.setForeground(new java.awt.Color(0, 102, 153));
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(BasePopup.class);
        jLabelTotal.setText(resourceMap.getString("jLabelTotal.text")); // NOI18N
        jLabelTotal.setName("jLabelTotal"); // NOI18N

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setOpaque(false);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(BasePopup.class, this);
        prepPageBubtton.setAction(actionMap.get("pagePrev")); // NOI18N
        prepPageBubtton.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        prepPageBubtton.setText(resourceMap.getString("prepPageBubtton.text")); // NOI18N
        prepPageBubtton.setBorder(null);
        prepPageBubtton.setBorderPainted(false);
        prepPageBubtton.setFocusable(false);
        prepPageBubtton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        prepPageBubtton.setName("prepPageBubtton"); // NOI18N
        prepPageBubtton.setOpaque(false);
        prepPageBubtton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(prepPageBubtton);

        nextPageButton.setAction(actionMap.get("pageNext")); // NOI18N
        nextPageButton.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        nextPageButton.setText(resourceMap.getString("nextPageButton.text")); // NOI18N
        nextPageButton.setBorder(null);
        nextPageButton.setBorderPainted(false);
        nextPageButton.setFocusable(false);
        nextPageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextPageButton.setName("nextPageButton"); // NOI18N
        nextPageButton.setOpaque(false);
        nextPageButton.setPreferredSize(new java.awt.Dimension(37, 27));
        nextPageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(nextPageButton);

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultMouseClicked
        if (bindTable != null) {
            HashMap map = bindTable.getSelectedBean();
            popBuilder.setBindedMap(map);
            parentComponent.hidePanel();
        }
    }//GEN-LAST:event_jTableResultMouseClicked

    private void jTableResultMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultMouseMoved
        int selectedrow = jTableResult.getSelectedRow();
        if (selectedrow > -1) {
            Point p = evt.getPoint();//首先获取鼠标坐标
            int current = jTableResult.rowAtPoint(p);//根据坐标获取所在行
            // System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@jTableResultMouseMoved:"+current);

        }
    }//GEN-LAST:event_jTableResultMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResult;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton nextPageButton;
    private javax.swing.JButton prepPageBubtton;
    // End of variables declaration//GEN-END:variables

    @Override
    public Task reload() {
        return null;
    }

    @Override
    public Task reload(Object param) {
        return null;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        oldKey = this.key;
        this.key = key;
        logger.debug("new value:" + key + ",old value:" + oldKey);
        changeSupport.firePropertyChange(new PropertyChangeEvent(this, "KEY_CHANGE", oldKey, key));
    }
}