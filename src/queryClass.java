import java.awt.List;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class queryClass {
    
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    PreparedStatement ps;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://103.82.249.195:3306/foodmanage_db";
            String username = "root";
            String password = "zz112233";
            
            Connection conn = DriverManager.getConnection(url, username, password);
            
            if (conn != null && conn.isValid(2)) { // 2 วินาทีสำหรับการเช็ค
                System.out.println("Database connection successful.");
            } else {
                System.out.println("Unable to connect to database.");
            }
            
            return conn;
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
//    public static void readData() {
//        String query = "SELECT * FROM food_items";
//
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                int id = rs.getInt("food_id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//
//                System.out.println("ID: " + id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    

    public ArrayList<String> getCategory() {
        
        ArrayList<String> cateList = new ArrayList<>();
        
        String query = "SELECT * FROM food_category";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String cateName = rs.getString("ct_name");
                String cateLabel = rs.getString("ct_lebel");
                
                cateList.add(cateLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cateList;
    }
      
//    public ArrayList<String> getCategoryByID(String categoName) {
//        String sql = "SELECT * FROM food_items WHERE food_label = ?";
//        Connection conn = getConnection();
//        ArrayList<String> cateList = new ArrayList<>();
//
//        try {
//            
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, categoName);
//
//            // Execute query
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                String cateLabel = rs.getString("ct_lebel");
//                cateList.add(cateLabel);                
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cateList;
//    }
    
    public ArrayList<String> getAllItemId() {
        
        ArrayList<String> ListItemId = new ArrayList<>();
        
        String query = "SELECT food_id FROM food_items";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String itemId = rs.getString("food_id");
                
                
                ListItemId.add(itemId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListItemId;
    }
    
//    public ArrayList<String> getItemById(int fid) {
//        ArrayList<String> ListItemId = new ArrayList<>();
//
//        String query = "SELECT * FROM food_items WHERE food_id = ?";
//
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//
//            stmt.setInt(1, fid);
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    String itemId = rs.getString("food_id");
//                    String itemCate = rs.getString("food_category");
//                    String itemName = rs.getString("food_name");
//                    String itemLabel = rs.getString("food_label");
//                    String itemPrice = rs.getString("food_price");
//                    String itemImg = rs.getString("food_img");
//                    String itemDate = rs.getString("food_date");
//                    
//                    ListItemId.add(itemId);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return ListItemId;
//    }

    
    public ArrayList<String> getAllItemLebel() {
        
        ArrayList<String> ListItemLabel = new ArrayList<>();
        
        String query = "SELECT food_label FROM food_items";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String itemLabel = rs.getString("food_label");
                
                
                ListItemLabel.add(itemLabel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListItemLabel;
    }
    
    public ArrayList<String> getAllItemPrice() {
        
        ArrayList<String> ListItemPrice = new ArrayList<>();
        
        String query = "SELECT food_price FROM food_items";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String itemPrice = rs.getString("food_price");
                
                
                ListItemPrice.add(itemPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListItemPrice;
    }
    
    
    public ArrayList<String> getAllItemImg() {
        
        ArrayList<String> ListItemImg = new ArrayList<>();
        
        String query = "SELECT food_img FROM food_items";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String itemImg = rs.getString("food_img");
                
                
                ListItemImg.add(itemImg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ListItemImg;
    }
    
    
    
    
    public Item getItemById(String id) {
        Connection conn = getConnection();
        
        Item item = null;
        String sql = "SELECT * FROM food_items WHERE food_category = ?";

        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);

            // Execute query
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //System.out.println("Food id : " + rs.getInt("food_id"));
                item = new Item(rs.getInt("food_id"), rs.getString("food_category"), rs.getString("food_name"), rs.getString("food_label"), rs.getDouble("food_price"), rs.getString("food_img"), rs.getString("food_date"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }
    
    public ArrayList<Item> getItemsByCategory(String category_id) {
        ArrayList<Item> items = new ArrayList<>();
        Connection conn = getConnection();

        String sql = "SELECT * FROM food_items WHERE food_category = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // สมมุติว่า Item มีคอนสตรัคเตอร์ที่รับค่าจาก ResultSet
                Item item = new Item(rs.getInt("food_id"), rs.getString("food_category"), rs.getString("food_name"), rs.getString("food_label"), rs.getDouble("food_price"), rs.getString("food_img"), rs.getString("food_date"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    
    
    public void insertCatetoryData(String ctName, String ctLabel) {
        // สร้างการเชื่อมต่อกับฐานข้อมูล
        Connection conn = getConnection();

        if (conn != null) {
            try {
                // Query สำหรับการ insert ข้อมูล
                String query = "INSERT INTO food_category (ct_name, ct_lebel) VALUES (?, ?)";

                // สร้าง PreparedStatement
                PreparedStatement pstmt = conn.prepareStatement(query);

                // ตั้งค่าพารามิเตอร์ให้กับ PreparedStatement
                pstmt.setString(1, ctName);
                pstmt.setString(2, ctLabel);

                // Execute การ insert ข้อมูล
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Insert data successful!");
                } else {
                    System.out.println("Insert data failed!");
                }

                // ปิดการเชื่อมต่อ
                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    public void deleteCategoryData(String ctName) {
        // สร้างการเชื่อมต่อกับฐานข้อมูล
        Connection conn = getConnection();

        if (conn != null) {
            try {
                // Query สำหรับการ delete ข้อมูล
                String query = "DELETE FROM food_category WHERE ct_name = ?";

                // สร้าง PreparedStatement
                PreparedStatement pstmt = conn.prepareStatement(query);

                // ตั้งค่าพารามิเตอร์ให้กับ PreparedStatement
                pstmt.setString(1, ctName);

                // Execute การ delete ข้อมูล
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Delete data successful!");
                } else {
                    System.out.println("No data found with the given ct_name.");
                }

                // ปิดการเชื่อมต่อ
                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCategoryData(String oldCtName, String newCtName, String newCtLabel) {
        // สร้างการเชื่อมต่อกับฐานข้อมูล
        queryClass qc = new queryClass();
        Connection conn = qc.getConnection();

        if (conn != null) {
            try {
                // Query สำหรับการ update ข้อมูลทั้งสองคอลัมน์
                String query = "UPDATE food_category SET ct_name = ?, ct_lebel = ? WHERE ct_name = ?";

                // สร้าง PreparedStatement
                PreparedStatement pstmt = conn.prepareStatement(query);

                // ตั้งค่าพารามิเตอร์ให้กับ PreparedStatement
                pstmt.setString(1, newCtName);   // อัปเดต ct_name
                pstmt.setString(2, newCtLabel);  // อัปเดต ct_lebel
                pstmt.setString(3, oldCtName);  // ใช้ ct_name เก่ากำหนดแถวที่จะอัปเดต

                // Execute การ update ข้อมูล
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update data successful!");
                } else {
                    System.out.println("No data found with the given ct_name.");
                }

                // ปิดการเชื่อมต่อ
                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    
    
    
    
    public String getCategoryByName(String name) {
        String categoryLabel = null; // ตัวแปรที่จะเก็บค่า ct_lebel ที่ค้นหา

        String query = "SELECT ct_lebel FROM food_category WHERE ct_name = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // กำหนดค่าให้กับ ? ใน query
            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                // หากพบข้อมูลใน ResultSet
                if (rs.next()) {
                    categoryLabel = rs.getString("ct_lebel"); // ดึงค่าจาก ct_lebel
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryLabel; // คืนค่าที่ดึงมา หรือ null หากไม่พบข้อมูล
    }
    
    
    
    
    
    
    // Item Query
    public void insertItemData(String food_category, String food_name, String food_label, double food_price, String food_img, String time) {
        Connection conn = getConnection();

        if (conn != null) {
            try {
                String query = "INSERT INTO food_items (food_category, food_name, food_label, food_price, food_img, food_date) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(query);

                //pstmt.setInt(1, food_id);
                pstmt.setString(1, food_category);
                pstmt.setString(2, food_name);
                pstmt.setString(3, food_label);
                pstmt.setDouble(4, food_price);
                pstmt.setString(5, food_img);
                pstmt.setString(6, time);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Insert data successful!");
                } else {
                    System.out.println("Insert data failed!");
                }

                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateItemData(int food_id, String food_category, String food_name, String food_label, double food_price, String food_img, String time) {
        Connection conn = getConnection();

        if (conn != null) {
            try {
                String query = "UPDATE food_items SET food_id = ?, food_category = ?, food_name = ?, food_label = ?, food_price = ?, food_img = ?, food_date = ? WHERE food_id = ?";

                PreparedStatement pstmt = conn.prepareStatement(query);
                
                pstmt.setInt(1, food_id);
                pstmt.setString(2, food_category);
                pstmt.setString(3, food_name);
                pstmt.setString(4, food_label);
                pstmt.setDouble(5, food_price);
                pstmt.setString(6, food_img);
                pstmt.setString(7, time);
                pstmt.setInt(8, food_id);  // Assuming food_id is the primary key

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update data successful!");
                } else {
                    System.out.println("Update data failed or no changes made.");
                }

                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    public void deleteItemData(int food_id) {
        Connection conn = getConnection();

        if (conn != null) {
            try {
                String query = "DELETE FROM food_items WHERE food_id = ?";

                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, food_id);  // Assuming food_id is the primary key

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Delete data successful!");
                } else {
                    System.out.println("Delete data failed or no record found.");
                }

                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    // Insert History
    
    public void insertDataHistory(int h_qty, int h_id, String h_name, double price, String genInvoiceID) {
        Connection conn = getConnection();

        if (conn != null) {
            try {
                String query = "INSERT INTO food_history (h_idinvoice, h_qty, h_id, h_name, h_price, h_date) VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(query);

                //pstmt.setInt(1, food_id);
                pstmt.setString(1, genInvoiceID);
                pstmt.setInt(2, h_qty);
                pstmt.setInt(3, h_id);
                pstmt.setString(4, h_name);
                pstmt.setDouble(5, price);
                pstmt.setString(6, getCurrentTime());
                

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Insert data successful!");
                } else {
                    System.out.println("Insert data failed!");
                }

                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    


    
    public static String getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        return currentDateTime.format(formatter);
    }
    
}
