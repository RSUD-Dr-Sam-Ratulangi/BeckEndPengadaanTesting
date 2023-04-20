# **AplikasiPengedaanBeckEndTesting**

`dikembangkan oleh UPTIRS  RSUD DR SAM RATULANGI TONDANO 2023`

## langkah-langkah start aplikasi :

1. [x] 1 Intall maven terbaru
2. [x] 2 install jdk 17++
3. [x] 3 vscode > install mvn & springboot plugin
4. [x] 4 clone project  https://github.com/RSUD-Dr-Sam-Ratulangi/BeckEndPengadaanTesting.git
5. [x] 5 install mysql 8.0 ++
6. [x] 6 buat database pengdaan_rsud_samrat dimysql
7. [x] 7 mvn clean install
8. [x] 8 mvn deploy

## langkah untuk testing endpoint gunakan postman

1. install postman / buka postman di web
2. fork https://www.postman.com/altimetry-explorer-5015872/workspace/darkzill/collection/24300822-226eea7f-5a14-42f1-bd03-e9474133f8cd?action=share&creator=24300822)`


<table>
  <thead>
    <tr>
      <th>Endpoint</th>
      <th>Metode HTTP</th>
      <th>Deskripsi</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>/vendors</td>
      <td>GET</td>
      <td>Mengambil daftar vendor</td>
    </tr>
    <tr>
      <td>/vendors</td>
      <td>POST</td>
      <td>Menambahkan vendor baru</td>
    </tr>
    <tr>
      <td>/vendors/{vendorUuid}</td>
      <td>GET</td>
      <td>Mengambil data vendor berdasarkan UUID</td>
    </tr>
    <tr>
      <td>/vendors/{vendorUuid}</td>
      <td>PUT</td>
      <td>Mengubah data vendor berdasarkan UUID</td>
    </tr>
    <tr>
      <td>/vendors/{vendorUuid}</td>
      <td>DELETE</td>
      <td>Menghapus data vendor berdasarkan UUID</td>
    </tr>
    <tr>
      <td>/products</td>
      <td>GET</td>
      <td>Mengambil daftar produk</td>
    </tr>
    <tr>
      <td>/products/search</td>
      <td>GET</td>
      <td>Mencari produk berdasarkan nama atau deskripsi</td>
    </tr>
    <tr>
      <td>/products/vendor/{vendorUuid}</td>
      <td>GET</td>
      <td>Mengambil daftar produk milik vendor tertentu</td>
    </tr>
    <tr>
      <td>/products/{uuid}</td>
      <td>GET</td>
      <td>Mengambil data produk berdasarkan UUID</td>
    </tr>
    <tr>
      <td>/products/{uuid}</td>
      <td>PUT</td>
      <td>Mengubah data produk berdasarkan UUID</td>
    </tr>
    <tr>
      <td>/products/{uuid}</td>
      <td>DELETE</td>
      <td>Menghapus data produk berdasarkan UUID</td>
    </tr>
    <tr>
      <td>/products/{vendorUuid}</td>
      <td>POST</td>
      <td>Menambahkan produk baru milik vendor tertentu</td>
    </tr>
    <tr>
      <td>/orders</td>
      <td>GET</td>
      <td>Mengambil daftar pesanan</td>
    </tr>
    <tr>
      <td>/orders</td>
      <td>POST</td>
      <td>Menambahkan pesanan baru</td>
    </tr>
    <tr>
      <td>/api/product-requests</td>
      <td>GET</td>
      <td>Mengambil daftar permintaan produk</td>
    </tr>
    <tr>
      <td>/api/product-requests</td>
      <td>POST</td>
      <td>Menambahkan permintaan produk baru</td>
    </tr>
    <tr>
      <td>/api/product-requests/{id}</td>
      <td>GET</td>
      <td>Mengambil data permintaan product baru</td>
    </tr>
  <tr>
      <td>/api/product-requests/{id}</td>
      <td>PUT</td>
      <td>Mengubah data permintaan produk berdasarkan ID</td>
    </tr>
    <tr>
      <td>/api/product-requests/{id}</td>
      <td>DELETE</td>
      <td>Menghapus data permintaan produk berdasarkan ID</td>
    </tr>
    <tr>
      <td>/bids</td>
      <td>POST</td>
      <td>Menambahkan tawaran baru</td>
    </tr>
    <tr>
      <td>/bids/product/{productRequestId}</td>
      <td>GET</td>
      <td>Mengambil daftar tawaran untuk permintaan produk tertentu</td>
    </tr>
    <tr>
      <td>/bids/{bidId}/select</td>
      <td>PATCH</td>
      <td>Memilih tawaran sebagai pemenang untuk permintaan produk tertentu</td>
    </tr>
    <tr>
      <td>/bids/{id}</td>
      <td>GET</td>
      <td>Mengambil data tawaran berdasarkan ID</td>
    </tr>
    <tr>
      <td>/bids/{id}</td>
      <td>PUT</td>
      <td>Mengubah data tawaran berdasarkan ID</td>
    </tr>
    <tr>
      <td>/bids/{id}</td>
      <td>DELETE</td>
      <td>Menghapus data tawaran berdasarkan ID</td>
    </tr>
  </tbody>
</table>
