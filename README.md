Clone repository dari GitHub ke dalam folder lokal Anda.
Pastikan Anda sudah memiliki MySQL yang terpasang di komputer Anda.
Buat database dengan nama "pengdaan_rsud_samrat" di MySQL.
Buka file "application.properties" di folder "src/main/resources".
Isi konfigurasi koneksi database MySQL pada file "application.properties" dengan konfigurasi berikut:


spring.datasource.url=jdbc:mysql://localhost:3306/pengdaan_rsud_samrat
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true

# Log SQL statements and parameters
logging.level.org.hibernate.SQL=debug
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=trace

# Enable Hibernate statistics
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.stat=debug
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.type.descriptor.sql=TRACE
Buka file "pom.xml" di folder utama projek.


Pastikan semua dependensi yang diperlukan sudah terdaftar dalam file "pom.xml".
Jalankan program dengan menggunakan IDE atau dengan perintah mvn spring-boot:run pada terminal di folder utama projek.
Setelah langkah-langkah pre tersebut dilakukan, program Spring Boot siap dijalankan dan dapat diakses melalui browser atau Postman pada alamat http://localhost:8080.



# BeckEndPengadaanTesting
Beckend Aplikasi Pendaftaran RSUD dr Sam Ratulangi tondano
API Endpoint untuk Product Mendapatkan semua produk

GET /products
Endpoint ini akan mengembalikan daftar semua produk yang ada dalam database.


GET /products
Response
makefile
Copy code
Status: 200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "name": "Product 1",
        "description": "Description of Product 1",
        "price": 100000,
        "quantity": 10,
        "vendor": {
            "id": 1,
            "name": "Vendor 1",
            "address": "Address of Vendor 1",
            "phoneNumber": "081234567890"
        },
        "imageUrl": "http://example.com/product1.jpg"
    },
    {
        "id": 2,
        "name": "Product 2",
        "description": "Description of Product 2",
        "price": 150000,
        "quantity": 5,
        "vendor": {
            "id": 1,
            "name": "Vendor 1",
            "address": "Address of Vendor 1",
            "phoneNumber": "081234567890"
        },
        "imageUrl": "http://example.com/product2.jpg"
    }
]
API Endpoint untuk Vendor
Mendapatkan semua vendor

GET /vendors
Endpoint ini akan mengembalikan daftar semua vendor yang ada dalam database.

Request
bash
Copy code
GET /vendors
Response
makefile
Copy code
Status: 200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "name": "Vendor 1",
        "address": "Address of Vendor 1",
        "phoneNumber": "081234567890",
        "products": [
            {
                "id": 1,
                "name": "Product 1",
                "description": "Description of Product 1",
                "price": 100000,
                "quantity": 10,
                "imageUrl": "http://example.com/product1.jpg"
            },
            {
                "id": 2,
                "name": "Product 2",
                "description": "Description of Product 2",
                "price": 150000,
                "quantity": 5,
                "imageUrl": "http://example.com/product2.jpg"
            }
        ]
    },
    {
        "id": 2,
        "name": "Vendor 2",
        "address": "Address of Vendor 2",
        "phoneNumber": "082345678901",
        "products": [
            {
                "id": 3,
                "name": "Product 3",
                "description": "Description of Product 3",
                "price": 200000,
                "quantity": 7,
                "imageUrl": "http://example.com/product3.jpg"
            }
        ]
    }
]
Membuat vendor baru

POST /vendors
Endpoint ini akan membuat vendor baru dalam database.

Request
bash
Copy code
POST /vendors
Content-Type: application/json

{
    "name": "Vendor 3",
    "address": "Address of Vendor 3",
    "phoneNumber": "083456789012"
}
Response
makefile
Copy code
Status: 201 Created
Content-Type: application/json

{
    "id": 3,
    "name": "Vendor 3",
    "address": "Address of Vendor 3",
    "phoneNumber": "083456789012",
    "products": []
}

json

{
    "id": 1,
    "name": "Product A",
    "description": "This is product A",
    "price": 1000,
    "quantity": 10,
    "imageUrl": "https://example.com/image.png"
}


{
    "id": 2,
    "name": "Vendor A",
    "address": "Jl. Vendor No. 1",
    "phoneNumber": "081234567890",
    "products": [
        {
            "id": 1,
            "name": "Product A",
            "description": "This is product A",
            "price": 1000,
            "quantity": 10,
            "imageUrl": "https://example.com/image.png"
        }
    ]
}
