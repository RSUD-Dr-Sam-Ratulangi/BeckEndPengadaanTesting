<Header><center>Aplikasi backend untuk pengadaan di RSUD Dr. Samratulangi Tondano.
Aplikasi ini dibangun dengan menggunakan teknologi Java dan menerapkan arsitektur yang terstruktur 
dengan struktur folder yang tersusun dengan rapi.
Aplikasi ini terdiri dari beberapa paket (package) yang masing-masing berisi kelas-kelas yang terkait 
dengan fitur tertentu, seperti bid, DTO, exception, order, 
payment, ProductRequest, products, UTIL, dan vendor. 
Aplikasi ini juga memiliki folder resources yang berisi file statis dan template. 
Aplikasi ini dikembangkan dengan tujuan untuk mengelola pengadaan di RSUD Dr.
Samratulangi Tondano dengan lebih efisien</center></Header>


<table>
  <thead>
    <tr>
      <th>Endpoint</th>
      <th>Deskripsi</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><h2>Vendors</h2></td>
      <td></td>
    </tr>
    <tr>
      <td>GET /vendors</td>
      <td>Mendapatkan daftar semua vendor yang tersedia.</td>
    </tr>
    <tr>
      <td>POST /vendors</td>
      <td>Membuat vendor baru.</td>
    </tr>
    <tr>
      <td><h2>VendorProducts</h2></td>
      <td></td>
    </tr>
    <tr>
      <td>POST /vendors/{vendorId}/products</td>
      <td>Menambahkan produk baru ke vendor dengan ID yang diberikan.</td>
    </tr>
    <tr>
      <td><h2>Products</h2></td>
      <td></td>
    </tr>
    <tr>
      <td>GET /products</td>
      <td>Mendapatkan daftar semua produk yang tersedia.</td>
    </tr>
    <tr>
      <td>GET /products/products/{productuuid}</td>
      <td>Mendapatkan detail produk dengan UUID yang diberikan.</td>
    </tr>
    <tr>
      <td><h2>Orders</h2></td>
      <td></td>
    </tr>
    <tr>
      <td>GET /orders</td>
      <td>Mendapatkan daftar semua pesanan yang tersedia.</td>
    </tr>
    <tr>
      <td>POST /orders</td>
      <td>Membuat pesanan baru.</td>
    </tr>
  </tbody>
</table>
<h2>Product Requests</h2>
<table>
  <thead>
    <tr>
      <th>Endpoint</th>
      <th>Deskripsi</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>GET /api/product-requests</td>
      <td>Mendapatkan daftar semua permintaan produk yang tersedia.</td>
    </tr>
    <tr>
      <td>POST /api/product-requests</td>
      <td>Membuat permintaan produk baru.</td>
    </tr>
    <tr>
      <td>GET /api/product-requests/{id}</td>
      <td>Mendapatkan detail permintaan produk dengan ID yang diberikan.</td>
    </tr>
    <tr>
      <td>PUT /api/product-requests/{id}</td>
      <td>Memperbarui permintaan produk dengan ID yang diberikan.</td>
    </tr>
    <tr>
      <td>DELETE /api/product-requests/{id}</td>
      <td>Menghapus permintaan produk dengan ID yang diberikan.</td>
    </tr>
  </tbody>
</table>
<h2>Bids</h2>
<table>
  <thead>
    <tr>
      <th>Endpoint</th>
      <th>Deskripsi</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>POST /bids</td>
      <td>Membuat tawaran baru.</td>
    </tr>
    <tr>
      <td>GET /bids/product/{productRequestId}</td>
      <td>Mendapatkan daftar semua tawaran yang diberikan untuk permintaan produk dengan ID yang diberikan.</td>
    </tr>
    <tr>
      <td>PATCH /bids/{bidId}/select</td>
      <td>Memilih tawaran dengan ID yang diberikan sebagai pemenang.</td>
    </tr>
    <tr>
      <td>GET /bids/{id}</td>
      <td>Mendapatkan detail tawaran dengan ID yang diberikan.</td>
    </tr>
    <tr>
      <td>PUT /bids/{id}</td>
      <td>Memperbarui tawaran dengan ID yang diberikan.</td>
    </tr>
    <tr>
      <td>DELETE /bids/{id}</td>
      <td>Menghapus tawaran dengan ID yang diberikan.</td>
    </tr>
  </tbody>
</table>
