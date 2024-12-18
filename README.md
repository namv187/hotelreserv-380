<!-- ROE you are not to make changes to this git repository. use your own repository and i will pull as needed and make the changes. -->

JAVADOCS: [Link](https://rpalmon.github.io/hotelreserv-380/main/package-summary.html)

# MySQL Setup and Database Integration Guide

## 1. MySQL Setup

### a. Install MySQL
1. Download the MySQL installer from [MySQL Downloads](https://dev.mysql.com/downloads/installer/).
2. Select the latest version of **MySQL Workbench** and **MySQL Server**.
3. Follow the installation steps to complete the process.

### b. Set Up Administrative Account
1. Open **MySQL Workbench**.
2. Create a new user with the following settings:
   - **Username**: `admin`
   - **Password**: `password`
   - **Limit to Hosts Matching**: `localhost`
3. Assign administrative roles:
   - Apply **All Privileges**.

---

## 2. Database Setup

### a. Download Database
1. Download the `test_db.sql` file.
2. Save it in an accessible location.

### b. Import Database
1. Open **MySQL Workbench**.
2. Navigate to the **Server** tab and select **Data Import**.
3. Choose the option **Import from Self-Contained File**.
   - Click the `[...]` button and select the `test_db.sql` file.
4. Specify where to import the database:
   - Click **[New]** to create a new database and name it `test_db`.
5. Click **[Start Import]** to finalize the import process.

---

## 3. Running the Application

### Change to the project directory (Hotel Reservation System) and rebuild the classes.  
- Use the appropriate command line for your operating system.

---

### Linux
```bash
linux:
javac --module-path ./lib --add-modules javafx.controls,javafx.fxml -classpath .:linux-mysql-connector/mysql-connector-java-9.1.0.jar main/*.java

java --module-path ./lib --add-modules javafx.controls,javafx.fxml -classpath .:linux-mysql-connector/mysql-connector-java-9.1.0.jar main.Main

windows:
javac --module-path ./lib/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -classpath .;window-mysql-connector/* main/*.java

java --module-path ./lib/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -classpath .;window-mysql-connector/* main.Main

Windows-JUnit-Tests:
javac --module-path ./lib/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -cp ".;lib/junit/*;main/*;window-mysql-connector/*" -d bin main/*.java

java -cp "lib/junit/*;main" org.junit.platform.console.ConsoleLauncher --scan-class-path

windows prototyping:
javac --module-path ./lib/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -classpath .;window-mysql-connector/* main/*.java

java --module-path ./lib/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -classpath .;window-mysql-connector/* main.HotelSystem