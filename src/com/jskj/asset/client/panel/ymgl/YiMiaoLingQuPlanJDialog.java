/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jskj.asset.client.panel.ymgl;

import com.jskj.asset.client.AssetClientApp;
import com.jskj.asset.client.bean.entity.Shenqingdantb;
import com.jskj.asset.client.bean.entity.YimiaoAll;
import com.jskj.asset.client.bean.entity.YimiaocaigouEntity;
import com.jskj.asset.client.bean.entity.YimiaocaigouxiangdanEntity;
import com.jskj.asset.client.bean.entity.Yimiaoshenqingdantb;
import com.jskj.asset.client.bean.entity.YimiaoshenqingdantbFindEntity;
import com.jskj.asset.client.constants.Constants;
import com.jskj.asset.client.layout.AssetMessage;
import com.jskj.asset.client.layout.BaseDialog;
import com.jskj.asset.client.layout.BaseTable;
import com.jskj.asset.client.layout.IPopupBuilder;
import com.jskj.asset.client.panel.ymgl.task.YimiaoshenqingdanUpdateTask;
import com.jskj.asset.client.util.DanHao;
import com.jskj.asset.client.util.DateChooser;
import com.jskj.asset.client.util.DateHelper;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author huiqi
 */
public class YiMiaoLingQuPlanJDialog extends BaseDialog {

    private static final Logger logger = Logger.getLogger(YiMiaoLingQuPlanJDialog.class);
    private Yimiaoshenqingdantb yimiaoshenqingdan;
    private YimiaoshenqingdantbFindEntity yimiaoshenbao;
    private Shenqingdantb shenqingdan;
    private SimpleDateFormat dateformate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean isNew;
    private YimiaocaigouxiangdanEntity yimiaocaigouxiangdanEntity;

    DateChooser dateChooser1;
    JTextField regTextField;

    /**
     * Creates new form yimiaoyanshouJDialog
     */
    public YiMiaoLingQuPlanJDialog() {
        super();
        initComponents();

        jTextFieldYimiaoshenbaodanId.setText(DanHao.getDanHao(DanHao.TYPE_YIMIAOSB));
        jTextFieldYimiaoshenbaodanId.setEditable(false);
        jTextFieldzhidanDate.setText(dateformate.format(new Date()));
        jTextFieldshenqingren.setText(AssetClientApp.getSessionMap().getUsertb().getUserName());
        jTextFieldzhidanren.setText(AssetClientApp.getSessionMap().getUsertb().getUserName());
        jTextFielddepartment.setText(AssetClientApp.getSessionMap().getDepartment().getDepartmentName());

//疫苗表中的内容
        final BaseTable.SingleEditRowTable editTable = ((BaseTable) jTableyimiao).createSingleEditModel(new String[][]{
            {"yimiaoId", "疫苗编号"}, {"yimiaoName", "疫苗名称", "true"}, {"yimiaoGuige", "规格", "false"},
            {"yimiaoJixing", "剂型", "true"}, {"yimiaoShengchanqiye", "生产企业", "true"}, {"unitId", "单位", "false"}, {"quantity", "数量", "true"}});

        editTable.registerPopup(1, new IPopupBuilder() {
            public int getType() {
                return IPopupBuilder.TYPE_POPUP_TABLE;
            }

            public String getWebServiceURI() {
                return Constants.HTTP + Constants.APPID + "addyimiao";
            }

            public String getConditionSQL() {
                int selectedColumn = jTableyimiao.getSelectedColumn();
                int selectedRow = jTableyimiao.getSelectedRow();
                Object newColumnObj = jTableyimiao.getValueAt(selectedRow, selectedColumn);
                String sql = "";
                if (newColumnObj instanceof String && !newColumnObj.toString().trim().equals("")) {
                    sql += "(yimiao_name like \"%" + newColumnObj.toString() + "%\" or zujima like \"%" + newColumnObj.toString() + "%\") and yimiao_id in (select distinct yimiao_id from yimiao where yimiao_type=\"Ⅰ类疫苗\")";
                } else {
                    sql += "yimiao_id in (select distinct yimiao_id from yimiao where yimiao_type=\"Ⅰ类疫苗\")";
                }
                return sql;
            }

            public String[][] displayColumns() {
                return new String[][]{{"yimiaoId", "疫苗编号"}, {"yimiaoName", "疫苗名称"}, {"yimiaoGuige", "规格"},
                {"yimiaoJixing", "剂型"}};
            }

            public void setBindedMap(HashMap bindedMap) {
                if (bindedMap != null) {
                    Object yimiaoId = bindedMap.get("yimiaoId");
                    Object yimiaoName = bindedMap.get("yimiaoName");
                    Object yimiaoGuige = bindedMap.get("yimiaoGuige");
                    Object yimiaoJixing = bindedMap.get("yimiaoJixing");
                    Object shengchanqiye = bindedMap.get("yimiaoShengchanqiye");
                    Object unit = bindedMap.get("unitId");

                    editTable.insertValue(0, yimiaoId);
                    editTable.insertValue(1, yimiaoName);
                    editTable.insertValue(2, yimiaoGuige);
                    editTable.insertValue(3, yimiaoJixing);
                    editTable.insertValue(4, shengchanqiye);
                    editTable.insertValue(5, unit);
                }

            }
        });

//        editTable.registerPopup(4, new IPopupBuilder() {
//            public int getType() {
//                return IPopupBuilder.TYPE_POPUP_TABLE;
//            }
//
//            public String getWebServiceURI() {
//                return Constants.HTTP + Constants.APPID + "addyimiao";
//            }
//
//            public String getConditionSQL() {
//                int selectedColumn = jTableyimiao.getSelectedColumn();
//                int selectedRow = jTableyimiao.getSelectedRow();
//                Object newColumnObj = jTableyimiao.getValueAt(selectedRow, selectedColumn);
//                String sql = "";
//                if (newColumnObj instanceof String && !newColumnObj.toString().trim().equals("")) {
//                    sql += "yimiao_shengchanqiye like \"%" + newColumnObj.toString() + "%\" and yimiao_id in (select distinct yimiao_id from yimiao where yimiao_type=\"Ⅰ类疫苗\")";
//                } else {
//                    sql += "yimiao_id in (select distinct yimiao_id from yimiao where yimiao_type=\"Ⅰ类疫苗\")";
//                }
//                return sql;
//            }
//
//            public String[][] displayColumns() {
//                return new String[][]{{"yimiaoId", "疫苗编号"}, {"yimiaoName", "疫苗名称"}, {"yimiaoGuige", "规格"},
//                {"yimiaoJixing", "剂型"}};
//            }
//
//            public void setBindedMap(HashMap bindedMap) {
//                if (bindedMap != null) {
//                    Object yimiaoId = bindedMap.get("yimiaoId");
//                    Object yimiaoName = bindedMap.get("yimiaoName");
//                    Object yimiaoGuige = bindedMap.get("yimiaoGuige");
//                    Object yimiaoJixing = bindedMap.get("yimiaoJixing");
//                    Object shengchanqiye = bindedMap.get("yimiaoShengchanqiye");
//                    Object unit = bindedMap.get("unitId");
//
//                    editTable.insertValue(0, yimiaoId);
//                    editTable.insertValue(1, yimiaoName);
//                    editTable.insertValue(2, yimiaoGuige);
//                    editTable.insertValue(3, yimiaoJixing);
//                    editTable.insertValue(4, shengchanqiye);
//                    editTable.insertValue(5, unit);
//
//                }
//
//            }
//        });
//
//        editTable.registerPopup(3, new IPopupBuilder() {
//            public int getType() {
//                return IPopupBuilder.TYPE_POPUP_TABLE;
//            }
//
//            public String getWebServiceURI() {
//                return Constants.HTTP + Constants.APPID + "addyimiao";
//            }
//
//            public String getConditionSQL() {
//                int selectedColumn = jTableyimiao.getSelectedColumn();
//                int selectedRow = jTableyimiao.getSelectedRow();
//                Object newColumnObj = jTableyimiao.getValueAt(selectedRow, selectedColumn);
//                String sql = "";
//                if (newColumnObj instanceof String && !newColumnObj.toString().trim().equals("")) {
//                    sql += "yimiao_jixing like \"%" + newColumnObj.toString() + "%\" and yimiao_id in (select distinct yimiao_id from yimiao where yimiao_type=\"Ⅰ类疫苗\")";
//                } else {
//                    sql += "yimiao_id in (select distinct yimiao_id from yimiao where yimiao_type=\"Ⅰ类疫苗\")";
//                }
//                return sql;
//            }
//
//            public String[][] displayColumns() {
//                return new String[][]{{"yimiaoId", "疫苗编号"}, {"yimiaoName", "疫苗名称"}, {"yimiaoGuige", "规格"},
//                {"yimiaoJixing", "剂型"}};
//            }
//
//            public void setBindedMap(HashMap bindedMap) {
//                if (bindedMap != null) {
//                    Object yimiaoId = bindedMap.get("yimiaoId");
//                    Object yimiaoName = bindedMap.get("yimiaoName");
//                    Object yimiaoGuige = bindedMap.get("yimiaoGuige");
//                    Object yimiaoJixing = bindedMap.get("yimiaoJixing");
//                    Object shengchanqiye = bindedMap.get("yimiaoShengchanqiye");
//                    Object unit = bindedMap.get("unitId");
//
//                    editTable.insertValue(0, yimiaoId);
//                    editTable.insertValue(1, yimiaoName);
//                    editTable.insertValue(2, yimiaoGuige);
//                    editTable.insertValue(3, yimiaoJixing);
//                    editTable.insertValue(4, shengchanqiye);
//                    editTable.insertValue(5, unit);
//
//                }
//
//            }
//        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldzhidanren = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableyimiao = new BaseTable(null);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRemark = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldshenqingren = new javax.swing.JTextField();
        jTextFieldYimiaoshenbaodanId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFielddepartment = new javax.swing.JTextField();
        jTextFieldzhidanDate = new javax.swing.JTextField();

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane2.setViewportView(jTable1);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setName("jTable2"); // NOI18N
        jScrollPane3.setViewportView(jTable2);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setName("jTable3"); // NOI18N
        jScrollPane4.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getResourceMap(YiMiaoLingQuPlanJDialog.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setOpaque(false);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(com.jskj.asset.client.AssetClientApp.class).getContext().getActionMap(YiMiaoLingQuPlanJDialog.class, this);
        jButton1.setAction(actionMap.get("submitForm")); // NOI18N
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setOpaque(false);
        jToolBar1.add(jButton1);

        jButton4.setIcon(resourceMap.getIcon("jButton4.icon")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setOpaque(false);
        jToolBar1.add(jButton4);

        jButton5.setAction(actionMap.get("exit")); // NOI18N
        jButton5.setIcon(resourceMap.getIcon("jButton5.icon")); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setFocusable(false);
        jButton5.setName("jButton5"); // NOI18N
        jButton5.setOpaque(false);
        jToolBar1.add(jButton5);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jTextFieldzhidanren.setEditable(false);
        jTextFieldzhidanren.setName("jTextFieldzhidanren"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        jTableyimiao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "疫苗编号", "疫苗名称", "规格", "剂型", "生产企业", "单位", "数量"
            }
        ));
        jTableyimiao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableyimiao.setName("jTableyimiao"); // NOI18N
        jScrollPane5.setViewportView(jTableyimiao);
        if (jTableyimiao.getColumnModel().getColumnCount() > 0) {
            jTableyimiao.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableyimiao.columnModel.title0")); // NOI18N
            jTableyimiao.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableyimiao.columnModel.title1")); // NOI18N
            jTableyimiao.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTableyimiao.columnModel.title2")); // NOI18N
            jTableyimiao.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTableyimiao.columnModel.title3")); // NOI18N
            jTableyimiao.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTableyimiao.columnModel.title4")); // NOI18N
            jTableyimiao.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTableyimiao.columnModel.title5")); // NOI18N
            jTableyimiao.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTable4.columnModel.title7")); // NOI18N
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextAreaRemark.setColumns(20);
        jTextAreaRemark.setRows(2);
        jTextAreaRemark.setName("jTextAreaRemark"); // NOI18N
        jScrollPane1.setViewportView(jTextAreaRemark);

        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jTextFieldshenqingren.setEditable(false);
        jTextFieldshenqingren.setText(resourceMap.getString("jTextFieldshenqingren.text")); // NOI18N
        jTextFieldshenqingren.setName("jTextFieldshenqingren"); // NOI18N

        jTextFieldYimiaoshenbaodanId.setEditable(false);
        jTextFieldYimiaoshenbaodanId.setText(resourceMap.getString("jTextFieldYimiaoshenbaodanId.text")); // NOI18N
        jTextFieldYimiaoshenbaodanId.setName("jTextFieldYimiaoshenbaodanId"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jTextFielddepartment.setEditable(false);
        jTextFielddepartment.setText(resourceMap.getString("jTextFielddepartment.text")); // NOI18N
        jTextFielddepartment.setName("jTextFielddepartment"); // NOI18N

        jTextFieldzhidanDate.setEditable(false);
        jTextFieldzhidanDate.setText(resourceMap.getString("jTextFieldzhidanDate.text")); // NOI18N
        jTextFieldzhidanDate.setName("jTextFieldzhidanDate"); // NOI18N
        jTextFieldzhidanDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldzhidanDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldzhidanren, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel25))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldshenqingren, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldYimiaoshenbaodanId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldzhidanDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFielddepartment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldYimiaoshenbaodanId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldzhidanDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldshenqingren, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jTextFielddepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldzhidanren, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldzhidanDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldzhidanDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldzhidanDateActionPerformed

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
            java.util.logging.Logger.getLogger(YiMiaoLingQuPlanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YiMiaoLingQuPlanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YiMiaoLingQuPlanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YiMiaoLingQuPlanJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    public void setAddOrUpdate(boolean b) {
        isNew = b;
        if (isNew) {
            this.setTitle("Ⅰ类疫苗申报计划申请单");
            shenqingdan = new Shenqingdantb();
            yimiaoshenqingdan = new Yimiaoshenqingdantb();
        } else {
            this.setTitle("Ⅰ类疫苗申报计划申请单");
        }
    }

    public void setUpdatedData(Yimiaoshenqingdantb yimiaoshenqingdan) {
        if (yimiaoshenqingdan == null) {
            return;
        }
        this.yimiaoshenqingdan = yimiaoshenqingdan;
        jTextFieldYimiaoshenbaodanId.setText((yimiaoshenqingdan.getShenqingdanId()).toString());

    }

    @Action
    public Task submitForm() throws ParseException {
        jTableyimiao.getCellEditor(jTableyimiao.getSelectedRow(),
                jTableyimiao.getSelectedColumn()).stopCellEditing();
        yimiaoshenbao = new YimiaoshenqingdantbFindEntity();
        shenqingdan.setShenqingdanId(jTextFieldYimiaoshenbaodanId.getText());
        shenqingdan.setShenqingdanDate(dateformate.parse(jTextFieldzhidanDate.getText()));
        shenqingdan.setJingbanrenId(AssetClientApp.getSessionMap().getUsertb().getUserId());
        shenqingdan.setZhidanrenId(AssetClientApp.getSessionMap().getUsertb().getUserId());
        shenqingdan.setDanjuleixingId(3);
        shenqingdan.setShenqingdanRemark(jTextAreaRemark.getText());

        List<Yimiaoshenqingdantb> list = new ArrayList<Yimiaoshenqingdantb>();
        for (int i = 0; i < jTableyimiao.getRowCount() - 1; i++) {
            BaseTable yimiaotable = ((BaseTable) jTableyimiao);
            yimiaoshenqingdan = new Yimiaoshenqingdantb();
            yimiaoshenqingdan.setShenqingdanId(jTextFieldYimiaoshenbaodanId.getText());
            System.out.println(yimiaotable.getValue(i, "yimiaoId"));
            yimiaoshenqingdan.setDanjuleixingId(3);
            yimiaoshenqingdan.setStatus(8);
            yimiaoshenqingdan.setYimiaoId(Integer.parseInt(yimiaotable.getValue(i, "yimiaoId").toString()));
            if (yimiaotable.getValue(i, "quantity").equals(0)) {
                AssetMessage.ERRORSYS("请输入疫苗申报数量!");
                return null;
            }
            yimiaoshenqingdan.setQuantity(Integer.parseInt((String) ("" + yimiaotable.getValue(i, "quantity"))));
            list.add(yimiaoshenqingdan);
        }
        yimiaoshenbao.setShenqingdan(shenqingdan);
        yimiaoshenbao.setYimiaoshenqingdans(list);

        return new SubmitFormTask(yimiaoshenbao);
    }

    @Action
    public void exit() {
        this.dispose();
    }

    private class SubmitFormTask extends YimiaoshenqingdanUpdateTask {

        SubmitFormTask(YimiaoshenqingdantbFindEntity yimiaoshenqingdan) {
            super(yimiaoshenqingdan, isNew ? YimiaoshenqingdanUpdateTask.ENTITY_SAVE : YimiaoshenqingdanUpdateTask.ENTITY_UPDATE);
        }

        @Override
        public void onSucceeded(Object result) {
            if (result instanceof Exception) {
                Exception e = (Exception) result;
                AssetMessage.ERRORSYS(e.getMessage());
                logger.error(e);
                return;
            }
            AssetMessage.INFO("提交成功！", YiMiaoLingQuPlanJDialog.this);
            exit();
            JFrame mainFrame = AssetClientApp.getApplication().getMainFrame();
            YiMiaoLingQuPlanJDialog shenbaoPlanJDialog = new YiMiaoLingQuPlanJDialog();
            shenbaoPlanJDialog.setLocationRelativeTo(mainFrame);
            shenbaoPlanJDialog.setAddOrUpdate(true);
            AssetClientApp.getApplication().show(shenbaoPlanJDialog);
        }
    }

    public YiMiaoLingQuPlanJDialog(final JDialog parent, YimiaocaigouxiangdanEntity yimiaocaigouxiangdanEntity) {
        super();
        initComponents();
        this.yimiaocaigouxiangdanEntity = yimiaocaigouxiangdanEntity;
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                if (parent != null) {
                    parent.setVisible(true);
                }
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

        });

        jButton1.setEnabled(false);

        jTextFieldYimiaoshenbaodanId.setEditable(false);
        jTextFieldYimiaoshenbaodanId.setText(yimiaocaigouxiangdanEntity.getShenqingdantb().getShenqingdanId());
        jTextFieldzhidanDate.setText(DateHelper.format(yimiaocaigouxiangdanEntity.getShenqingdantb().getShenqingdanDate(), "yyyy-MM-dd HH:mm:ss"));
        jTextFieldzhidanDate.setEditable(false);
        jTextFieldshenqingren.setEditable(false);
        jTextFieldshenqingren.setText(yimiaocaigouxiangdanEntity.getUserAll().getUserName());
        jTextFieldzhidanren.setEditable(false);
        jTextFieldzhidanren.setText(yimiaocaigouxiangdanEntity.getUserAll().getUserName());
        jTextFielddepartment.setEditable(false);
        jTextFielddepartment.setText(yimiaocaigouxiangdanEntity.getUserAll().getDepartment().getDepartmentName());
        jTextAreaRemark.setEditable(false);
        jTextAreaRemark.setText("" + yimiaocaigouxiangdanEntity.getShenqingdantb().getShenqingdanRemark());

        setListTable(yimiaocaigouxiangdanEntity.getResult());
    }

    public void setListTable(List<YimiaocaigouEntity> yimiaocaigouEntityList) {

        int size = yimiaocaigouEntityList.size();
        Object[][] o = new Object[size][7];
        for (int i = 0; i < size; i++) {
            Yimiaoshenqingdantb yimiaoshenqingdantb = yimiaocaigouEntityList.get(i).getYimiaoshenqingdantb();
            YimiaoAll yimiaoAll = yimiaocaigouEntityList.get(i).getYimiaoAll();
            o[i] = new Object[]{yimiaoAll.getYimiaoId(), yimiaoAll.getYimiaoName(), yimiaoAll.getYimiaoGuige(), yimiaoAll.getYimiaoJixing(), yimiaoAll.getYimiaoShengchanqiye(), yimiaoAll.getUnitId(),
                yimiaoshenqingdantb.getQuantity()};
        }

        jTableyimiao.setModel(new javax.swing.table.DefaultTableModel(
                o,
                new String[]{
                    "疫苗编号", "疫苗名称", "规格", "剂型", "生产企业", "单位", "数量"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTableyimiao;
    private javax.swing.JTextArea jTextAreaRemark;
    private javax.swing.JTextField jTextFieldYimiaoshenbaodanId;
    private javax.swing.JTextField jTextFielddepartment;
    private javax.swing.JTextField jTextFieldshenqingren;
    private javax.swing.JTextField jTextFieldzhidanDate;
    private javax.swing.JTextField jTextFieldzhidanren;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
