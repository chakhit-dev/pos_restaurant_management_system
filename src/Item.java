
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Item {
    
    private int id;
    private String category;
    private String name;
    private String label;
    private double price;
    private String img;
    private String date;
    
    public Item(int fID, String fCategory, String fName, String fLabel, double fPrice, String fImg, String fDate) {
        this.id = fID;
        this.category = fCategory;
        this.name = fName;
        this.label = fLabel;
        this.price = fPrice;
        this.img =  fImg;
        this.date = fDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public String getDate() {
        return date;
    }
    
    public void printData() {
        String Str = "Item Detail : \n id = %s \n";
        String result = String.format(Str, id);
        System.out.println(result);
    }
    
//    public String getTimeStr() {
//        long currentTimeMillis = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(currentTimeMillis);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = sdf.format(timestamp);
//        
//        return formattedDate;
//    }
    
}
