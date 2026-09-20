# 🍣 POS Restaurant Management System

A desktop-based Point of Sale (POS) and Restaurant Management application built in **Java Swing** and integrated with a **MySQL** database. Designed to streamline ordering, order billing, menu category configuration, and transaction history tracking for food and beverage establishments.

---

## 🌟 Features

- **Interactive Ordering Terminal (`frame_main`):** Visual food & drink catalog with categories (e.g., Ramen, Sushi, Desserts, Beverages) and quick item addition to order cart.
- **Cart & Bill Summary:** Real-time calculation of item quantities, subtotals, VAT, and total payment.
- **Category & Menu Management (`frame_category_manage`):** Configure and organize food categories and item availability directly within the system.
- **Order & Sales History (`frame_history`):** Track, review, and inspect past billing transactions and receipts stored in the database.
- **Persistent Storage:** Backed by MySQL with standard JDBC connectivity (`mysql-connector-j-9.2.0`).

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 8 or higher)
- **GUI Framework:** Java Swing / AWT (NetBeans GUI Builder)
- **Database:** MySQL
- **Database Driver:** MySQL Connector/J 9.2.0
- **Build System:** Apache Ant / NetBeans IDE project

---

## 📂 Project Structure

```text
pos_restaurant_management_system/
├── nbproject/                          # NetBeans project configuration
├── src/
│   ├── frame_main.java                 # Main POS & order processing dashboard
│   ├── frame_main.form                 # GUI design form for main terminal
│   ├── frame_category_manage.java      # Category management window
│   ├── frame_category_manage.form      # GUI design form for category window
│   ├── frame_history.java              # Order history & transaction viewer
│   ├── frame_history.form              # GUI design form for history window
│   ├── Item.java                       # Data model class for menu items
│   ├── imgs/                           # Menu item images & icon assets
│   └── lib/
│       └── mysql-connector-j-9.2.0.jar # MySQL JDBC Driver
├── build.xml                           # Apache Ant build script
└── manifest.mf                         # Application manifest
```

# Screenshot
![App Screenshot](https://i.imgur.com/jKpQMsO.png)
