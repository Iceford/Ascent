# **<center>Ascent Medical Systems</center>**

## 1. Introduction
&emsp;Ascent Pharmaceutical System is a comprehensive pharmaceutical mall, including client and management platform. The system is designed to provide pharmaceutical business services efficiently and conveniently to meet the needs of users and managers. The client provides a wealth of functions to facilitate users to browse, query products, and manage shopping carts and orders. The management platform supports management functions such as products, orders, members, and addresses, as well as system settings and permissions management. Through the integration of advanced technology and functional modules, Ascent Pharmaceutical System brings a better user experience to the pharmaceutical industry, provides powerful operation management functions, and assists the development of the industry.


## 2. Functional design
&emsp;The Ascent pharmaceutical system mainly includes the client accessed by buyers and the management end accessed by administrators. The specific functions are as follows

<div style="display: inline-block; width: 30%;">

### Client functions

#### basic function
- [x] User registration
- [x] User login
- [x] User exit
- [x] Product list
- [x] Product Category
- [x] Product details
- [x] Place an order to purchase
- [x] Search for products
- [x] Random recommendations

#### User Center
- [x] Contact information
- [x] Change password
- [x] Delete order
- [x] Harvest address

#### shopping cart
- [x] Delete product
- [x] Product settlement

#### Order
- [x] Delete order
</div>
<div style="display: inline-block; width: 30%;">

### Management function

#### Category Management
- [x] Product Category
- [x] Add category

#### Product Management
- [x] All products
- [x] Add product
- [x] Transfer product category

#### Order Management
- [x] Orders to be paid
- [x] paid order
- [x] Unshipped orders
- [x] Order shipped

#### User Management
- [x] Member Management
- [x] Member Order

#### System settings
- [x] Administrator
- [x] Permission settings
</div>


## 3. Database design

![Database design diagram](assets/diagram.png)


## 4. Technology Selection
Backend framework:&emsp;Spring + Spring MVC + MyBatis <br>
Front-end framework:&emsp;HTML + CSS + Juery + Layui <br>
Database:&emsp;MySQL <br>
Logging framework:&emsp;Log4j2 <br>
Project management tool:&emsp;Maven <br>
Test running environment:&emsp;Tomcat <br>


## 5. Project structure
```
Ascent
├───assets                                store the static resources of the project
└───src                                   root directory of source code
     └───main                             main source code directory
         ├───java                         Java source code directory
         │ └───com
         │ └───whimsyquester              top package name
         │ ├───controller                 controller class, handles requests and responses
         │ │ └───admin                    Administrator-related controller classes
         │ ├───dao                        data access object, used to interact with the database
         │ ├───enums                      enumeration type
         │ ├───interceptors               interceptor class, used to intercept requests and process them
         │ ├───po                         persistent object, Java object corresponding to database table
         │ ├───service                    service interface and implementation class
         │ │ ├───impl                     implementation class of service interface
         │ │ │ └───admin                  administrator-related service interface implementation class
         │ │ └───inter                    service interface
         │ │ └───admin                    Administrator-related service interface
         │ └───util                       tool class
         ├───resources                    resource directory, where configuration files are stored, etc.
         │ ├───mybatis                    MyBatis related configuration files, including mapping files, etc.
         │ └───spring                     Spring framework related configuration files
         └───webapp                       Web application directory, storing Web resources
             ├───admin                    Administrator-related pages and resources
             │ └───Images                 picture resources
             │ └───modules                CSS folder related to modules
             │ ├───laydate                Default CSS folder for LayDate module
             │ │ └───default
             │ └───Default                CSS folder of layer Layer module
             │ └───default
             ├───css                      style sheet file
             ├───images                   picture resources
             │ └───Images                 picture resources
             ├───js                       JavaScript file
             │ ├───Js                     JavaScript file
             │ └───pages                  JavaScript files related to pages
             │ ├───css                    JavaScript files related to page style
             │ │ └───modules              JavaScript files related to modules
             │ │ ├───laydate              Default JavaScript folder for LayDate module
             │ │ │ └───default
             │ │ └───Default              JavaScript folder for layer Layer module
             │ │ └───default
             │ ├───font                   font file
             │ ├───images                 page image resources
             │ │ └───face                 emoticon picture resources
             │ └───lay                    LayUI related JavaScript files
             │ └───modules                JavaScript folder related to modules
             ├───META-INF                 stores meta-information related to deployment
             ├───user                     user-related pages and resources
             └───WEB-INF                  stores the configuration files and protected resources of web applications
```

## 6. Run the demo
**1. Open the project, execute the [ascent.sql](src\main\resources\ascent.sql) file to create the database required for the project**

![](assets/屏幕截图-2023-11-26-211550.png)


**2. Set the account and password for the database connection in the [db.properties](src\main\resources\db.properties) file**

![](assets/屏幕截图-2023-11-26-212106.png)


**3. Run the batch script file [start.bat](start.bat) and the project will start running**

![](assets/屏幕截图-2023-11-26-212428.png)

**4.Client and management access**

Client address:&emsp;[http://localhost:8888/Ascent/user/](http://localhost:8888/Ascent/user/) 

![](assets/网页捕获_26-11-2023_22854_localhost.jpeg)

<br>Management address:&emsp;[http://localhost:8888/Ascent/admin/](http://localhost:8888/Ascent/admin/)

![](assets/屏幕截图-2023-11-26-212936.png)

## 7. Star History

[![Star History Chart](https://api.star-history.com/svg?repos=WhimsyQuester/Ascent&type=Date)](https://star-history.com/#WhimsyQuester/Ascent&Date)