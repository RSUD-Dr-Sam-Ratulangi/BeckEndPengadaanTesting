Base URL: http://localhost:8080

Endpoint	Method	Deskripsi
/vendors	GET	Mengambil daftar vendor
/vendors	POST	Menambahkan vendor baru
/vendors/{vendorUuid}	GET	Mengambil data vendor berdasarkan UUID
/vendors/{vendorUuid}	PUT	Mengubah data vendor berdasarkan UUID
/vendors/{vendorUuid}	DELETE	Menghapus data vendor berdasarkan UUID
/products	GET	Mengambil daftar produk
/products/search	GET	Mencari produk berdasarkan nama atau deskripsi
/products/vendor/{vendorUuid}	GET	Mengambil daftar produk milik vendor tertentu
/products/{uuid}	GET	Mengambil data produk berdasarkan UUID
/products/{uuid}	PUT	Mengubah data produk berdasarkan UUID
/products/{uuid}	DELETE	Menghapus data produk berdasarkan UUID
/products/{vendorUuid}	POST	Menambahkan produk baru milik vendor tertentu
/orders	GET	Mengambil daftar pesanan
/orders	POST	Menambahkan pesanan baru
/api/product-requests	GET	Mengambil daftar permintaan produk
/api/product-requests	POST	Menambahkan permintaan produk baru
/api/product-requests/{id}	GET	Mengambil data permintaan produk berdasarkan ID
/api/product-requests/{id}	PUT	Mengubah data permintaan produk berdasarkan ID
/api/product-requests/{id}	DELETE	Menghapus data permintaan produk berdasarkan ID
/bids	POST	Menambahkan tawaran baru
/bids/product/{productRequestId}	GET	Mengambil daftar tawaran untuk permintaan produk tertentu
/bids/{bidId}/select	PATCH	Memilih tawaran sebagai pemenang untuk permintaan produk tertentu
/bids/{id}	GET	Mengambil data tawaran berdasarkan ID
/bids/{id}	PUT	Mengubah data tawaran berdasarkan ID
/bids/{id}	DELETE	Menghapus data tawaran berdasarkan ID
Anda dapat menggunakan link Postman berikut ini untuk menyalin koleksi: 
https://web.postman.co/workspace/48a92302-680d-40e6-8582-28222fd0c40a/collection/24300822-226eea7f-5a14-42f1-bd03-e9474133f8cd?action=share&creator=24300822.