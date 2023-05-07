# openapi-java-client

PengadaanRSUDSamrat API
- API version: 1.0.0
    - Build date: 2023-04-30T00:49:02.225447600+08:00[Asia/Singapore]

PengadaanRSUDSamrat API





## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://rsudsamrat.site:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    BigDecimal orderId = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.addOrderItemToOrder(orderId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addOrderItemToOrder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://rsudsamrat.site:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addOrderItemToOrder**](DefaultApi.md#addOrderItemToOrder) | **POST** /pengadaan/dev/v1/orders/{orderId}/items | POST pengadaan/dev/v1/orders/{orderId}/items
[**addProductToVendor**](DefaultApi.md#addProductToVendor) | **POST** /pengadaan/dev/v1/products/{vendorUuid} | POST pengadaan/dev/v1/products/{vendorUuid}
[**createBid**](DefaultApi.md#createBid) | **POST** /pengadaan/dev/v1/bids | POST pengadaan/dev/v1/bids
[**createEmployee**](DefaultApi.md#createEmployee) | **POST** /employee | POST employee
[**createOrder**](DefaultApi.md#createOrder) | **POST** /pengadaan/dev/v1/orders | POST pengadaan/dev/v1/orders
[**createOrderItem**](DefaultApi.md#createOrderItem) | **POST** /pengadaan/dev/v1/orderitems | POST pengadaan/dev/v1/orderitems
[**createProductRequest**](DefaultApi.md#createProductRequest) | **POST** /pengadaan/dev/v1//product-requests | POST pengadaan/dev/v1//product-requests
[**createVendor**](DefaultApi.md#createVendor) | **POST** /pengadaan/dev/v1/vendors | POST pengadaan/dev/v1/vendors
[**deleteBid**](DefaultApi.md#deleteBid) | **DELETE** /pengadaan/dev/v1/bids/{id} | DELETE pengadaan/dev/v1/bids/{id}
[**deleteOrderById**](DefaultApi.md#deleteOrderById) | **DELETE** /pengadaan/dev/v1/orders/{id} | DELETE pengadaan/dev/v1/orders/{id}
[**deleteOrderItemById**](DefaultApi.md#deleteOrderItemById) | **DELETE** /pengadaan/dev/v1/orderitems/{id} | DELETE pengadaan/dev/v1/orderitems/{id}
[**deleteProductByUuid**](DefaultApi.md#deleteProductByUuid) | **DELETE** /pengadaan/dev/v1/products/{uuid} | DELETE pengadaan/dev/v1/products/{uuid}
[**deleteProductRequest**](DefaultApi.md#deleteProductRequest) | **DELETE** /pengadaan/dev/v1//product-requests/{id} | DELETE pengadaan/dev/v1//product-requests/{id}
[**deleteVendorByUuid**](DefaultApi.md#deleteVendorByUuid) | **DELETE** /pengadaan/dev/v1/vendors/{vendorUuid} | DELETE pengadaan/dev/v1/vendors/{vendorUuid}
[**findVendorByUuid**](DefaultApi.md#findVendorByUuid) | **GET** /pengadaan/dev/v1/vendors/{vendorUuid} | GET pengadaan/dev/v1/vendors/{vendorUuid}
[**getAllBidsByProductRequestId**](DefaultApi.md#getAllBidsByProductRequestId) | **GET** /pengadaan/dev/v1/bids/product/{productRequestId} | GET pengadaan/dev/v1/bids/product/{productRequestId}
[**getAllOrderItemDetails**](DefaultApi.md#getAllOrderItemDetails) | **GET** /pengadaan/dev/v1/orders/orders/items/details | GET pengadaan/dev/v1/orders/orders/items/details
[**getAllOrderItems**](DefaultApi.md#getAllOrderItems) | **GET** /pengadaan/dev/v1/orderitems | GET pengadaan/dev/v1/orderitems
[**getAllOrderItemsInOrders**](DefaultApi.md#getAllOrderItemsInOrders) | **GET** /pengadaan/dev/v1/orders/orders/items | GET pengadaan/dev/v1/orders/orders/items
[**getAllOrderItemsWithProductStock**](DefaultApi.md#getAllOrderItemsWithProductStock) | **GET** /pengadaan/dev/v1/orders/orders/items/product-stock | GET pengadaan/dev/v1/orders/orders/items/product-stock
[**getAllOrders**](DefaultApi.md#getAllOrders) | **GET** /pengadaan/dev/v1/orders | GET pengadaan/dev/v1/orders
[**getAllProductRequests**](DefaultApi.md#getAllProductRequests) | **GET** /pengadaan/dev/v1//product-requests | GET pengadaan/dev/v1//product-requests
[**getAllProducts**](DefaultApi.md#getAllProducts) | **GET** /pengadaan/dev/v1/products/{page}/{size} | GET pengadaan/dev/v1/products/{page}/{size}
[**getAllProductsByVendorUuid**](DefaultApi.md#getAllProductsByVendorUuid) | **GET** /pengadaan/dev/v1/products/vendor/{vendorUuid} | GET pengadaan/dev/v1/products/vendor/{vendorUuid}
[**getAllVendors**](DefaultApi.md#getAllVendors) | **GET** /pengadaan/dev/v1/vendors | GET pengadaan/dev/v1/vendors
[**getBidById**](DefaultApi.md#getBidById) | **GET** /pengadaan/dev/v1/bids/{id} | GET pengadaan/dev/v1/bids/{id}
[**getOrderById**](DefaultApi.md#getOrderById) | **GET** /pengadaan/dev/v1/orders/{orderId} | GET pengadaan/dev/v1/orders/{orderId}
[**getOrderItemById**](DefaultApi.md#getOrderItemById) | **GET** /pengadaan/dev/v1/orderitems/{id} | GET pengadaan/dev/v1/orderitems/{id}
[**getOrderItemProductInOrderRevenueAndStock**](DefaultApi.md#getOrderItemProductInOrderRevenueAndStock) | **GET** /pengadaan/dev/v1/orders/revenue-and-stock | GET pengadaan/dev/v1/orders/revenue-and-stock
[**getOrdersByVendor**](DefaultApi.md#getOrdersByVendor) | **GET** /pengadaan/dev/v1/orders/{vendorId}/vendor | GET pengadaan/dev/v1/orders/{vendorId}/vendor
[**getOrdersByVendorIdWithPagination**](DefaultApi.md#getOrdersByVendorIdWithPagination) | **GET** /pengadaan/dev/v1/orders/{vendorId}/{page}/{size} | GET pengadaan/dev/v1/orders/{vendorId}/{page}/{size}
[**getProductByUuid**](DefaultApi.md#getProductByUuid) | **GET** /pengadaan/dev/v1/products/{uuid} | GET pengadaan/dev/v1/products/{uuid}
[**getProductRequestById**](DefaultApi.md#getProductRequestById) | **GET** /pengadaan/dev/v1//product-requests/{id} | GET pengadaan/dev/v1//product-requests/{id}
[**getVendorByOwnerId**](DefaultApi.md#getVendorByOwnerId) | **GET** /pengadaan/dev/v1/vendors/owner/{ownerId} | GET pengadaan/dev/v1/vendors/owner/{ownerId}
[**getVendorProductRevenue**](DefaultApi.md#getVendorProductRevenue) | **GET** /pengadaan/dev/v1/orders/{vendorUUID}/revenue | GET pengadaan/dev/v1/orders/{vendorUUID}/revenue
[**login**](DefaultApi.md#login) | **POST** /employee/login | POST employee/login
[**searchOrdersByKeyword**](DefaultApi.md#searchOrdersByKeyword) | **GET** /pengadaan/dev/v1/orders/orders/search | GET pengadaan/dev/v1/orders/orders/search
[**searchProducts**](DefaultApi.md#searchProducts) | **GET** /pengadaan/dev/v1/products/search | GET pengadaan/dev/v1/products/search
[**searchVendorsByName**](DefaultApi.md#searchVendorsByName) | **GET** /pengadaan/dev/v1/vendors/search | GET pengadaan/dev/v1/vendors/search
[**selectWinningBid**](DefaultApi.md#selectWinningBid) | **PATCH** /pengadaan/dev/v1/bids/{bidId}/select | PATCH pengadaan/dev/v1/bids/{bidId}/select
[**updateBid**](DefaultApi.md#updateBid) | **PUT** /pengadaan/dev/v1/bids/{id} | PUT pengadaan/dev/v1/bids/{id}
[**updateOrder**](DefaultApi.md#updateOrder) | **PUT** /pengadaan/dev/v1/orders/{orderId} | PUT pengadaan/dev/v1/orders/{orderId}
[**updateProduct**](DefaultApi.md#updateProduct) | **PUT** /pengadaan/dev/v1/products/{uuid} | PUT pengadaan/dev/v1/products/{uuid}
[**updateProductRequest**](DefaultApi.md#updateProductRequest) | **PUT** /pengadaan/dev/v1//product-requests/{id} | PUT pengadaan/dev/v1//product-requests/{id}
[**updateVendorByUuid**](DefaultApi.md#updateVendorByUuid) | **PUT** /pengadaan/dev/v1/vendors/{vendorUuid} | PUT pengadaan/dev/v1/vendors/{vendorUuid}



## Documentation for Models



## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

Darkzill
UPTIRS RSUD SAM RATULANGI TONDANO



