
import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Jonathan_Dev
 */
public class panel_item1 extends javax.swing.JPanel {
    
    private int itemId;
    private String itemname;
    private double itemprice;
    private String itemimg;
    
    private frame_main mf;
    
    public panel_item1() {
        initComponents();
        loadPanelInfo();
    }

    public panel_item1(int sid, String sname, double sprice, String simg, frame_main mf) {
        this.itemId = sid;
        this.itemname = sname;
        this.itemprice = sprice;
        this.itemimg = simg;
        this.mf = mf;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemname() {
        return itemname;
    }

    public double getItemprice() {
        return itemprice;
    }

    public String getItemImg() {
        return itemimg;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setItemimg(String itemimg) {
        this.itemimg = itemimg;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }
    
    
    public void loadPanelInfo() {
        lb_name.setText(itemname);
        lb_price.setText(itemprice+"");
        
        if (itemimg == null || itemimg.trim().isEmpty()) {
            lb_img.setIcon(null);  // ถ้า sImg เป็น null หรือค่าว่าง ก็ให้ลบไอคอนใน JLabel
        } else {
            // โหลดภาพจาก Resource และตั้งค่าให้กับ lb_img
            lb_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/" + itemimg + ".png"))); // NOI18N
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_img = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_price = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lb_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_name.setText("ItemName");

        lb_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_price.setText("20.00 ฿");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lb_img, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lb_price)
                                .addGap(12, 12, 12))
                            .addComponent(lb_name))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_img, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_price)
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

//        String itemN = lb_name.getText();
//        double pricE = Double.valueOf(lb_price.getText());
        
        

//        mf.updateTableList(itemId, itemname, itemprice);
//        mf.updateTotalValue(itemprice);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_img;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_price;
    // End of variables declaration//GEN-END:variables
}
