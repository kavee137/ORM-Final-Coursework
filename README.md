# Culinary Academy Management System

This project is a **Hibernate-based Java application** for managing the culinary academy's data. Below are the steps to get started with the project.

## Prerequisites

1. **Java Development Kit (JDK)**: Make sure JDK is installed.
2. **MySQL Database**: Required for database setup.
3. **Hibernate**: Hibernate ORM for Java to interact with the database.

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/kavee137/ORM-Final-Coursework.git
```

### 2. Database Setup

This project is configured to use MySQL as the database. When you run the application for the first time, it will create the database automatically if it does not already exist.

1. Open MySQL and ensure you have access to the database server.
2. You **must** create a MySQL database named `theCulinaryAcademy`.

### 3. Hibernate Configuration

This project uses a `hibernate.properties` file to configure Hibernate. Here’s how it is set up:

Create a file named `hibernate.properties` in the `src/main/resources` directory with the following content:

```properties
# JDBC driver for MySQL
hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver

# Database connection URL, specifying the database name and the option to create it if it doesn't exist
hibernate.connection.url=jdbc:mysql://localhost:3306/theCulinaryAcademy?createDatabaseIfNotExist=true

# Database login credentials
hibernate.connection.username=root
hibernate.connection.password=123

# MySQL dialect for Hibernate
hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Schema update setting (auto-creates and updates tables based on entity mappings)
hibernate.hbm2ddl.auto=update

# Show SQL statements in the console
hibernate.show_sql=true
```

**Note:** Replace `root` and `123` with your actual MySQL username and password if different.

### 4. Initial User Setup

To start using the system:
1. Log in with the **temporary username and password** below:
    - **Username**: `admin`
    - **Password**: `admin`
2. Once logged in, you can add a new user (Admin) with a secure password.
3. Log out and use the newly created credentials to access the system.

### 5. Running the Application

Run the main application class to start the project. The application will connect to the database using the properties defined in the `hibernate.properties` file.

### 6. Additional Configuration

If needed, adjust the settings in `hibernate.properties` according to your environment, such as changing the database connection details.