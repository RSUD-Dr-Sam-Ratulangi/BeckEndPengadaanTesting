# BeckEndPengadaanTesting
Beckend Aplikasi Pendaftaran RSUD dr Sam Ratulangi tondano
API Endpoint untuk Product
Mendapatkan semua produk
bash
Copy code
GET /products
Endpoint ini akan mengembalikan daftar semua produk yang ada dalam database.

Request
bash
Copy code
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
bash
Copy code
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
bash
Copy code
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



dark zill
bagaimana dengan add producttovendor
Untuk API endpoint add product to vendor, Anda dapat mengirimkan POST request ke /vendors/{vendorId}/products dengan mengirimkan body JSON berisi informasi produk yang ingin ditambahkan ke vendor. Berikut adalah contoh body JSON untuk menambahkan produk dengan id 1 ke vendor dengan id 2:

json
Copy code
{
    "id": 1,
    "name": "Product A",
    "description": "This is product A",
    "price": 1000,
    "quantity": 10,
    "imageUrl": "https://example.com/image.png"
}
Setelah berhasil ditambahkan, API akan mengembalikan response dengan status code 201 CREATED dan body JSON yang berisi informasi vendor yang telah ditambahkan produknya:

json
Copy code
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
