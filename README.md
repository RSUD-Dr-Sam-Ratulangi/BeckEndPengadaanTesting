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

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**addOrderItemToOrder**](docs/DefaultApi.md#addOrderItemToOrder) | **POST** /pengadaan/dev/v1/orders/{orderId}/items | POST pengadaan/dev/v1/orders/{orderId}/items
*DefaultApi* | [**addProductToVendor**](docs/DefaultApi.md#addProductToVendor) | **POST** /pengadaan/dev/v1/products/{vendorUuid} | POST pengadaan/dev/v1/products/{vendorUuid}
*DefaultApi* | [**createBid**](docs/DefaultApi.md#createBid) | **POST** /pengadaan/dev/v1/bids | POST pengadaan/dev/v1/bids
*DefaultApi* | [**createOrder**](docs/DefaultApi.md#createOrder) | **POST** /pengadaan/dev/v1/orders | POST pengadaan/dev/v1/orders
*DefaultApi* | [**createOrderItem**](docs/DefaultApi.md#createOrderItem) | **POST** /pengadaan/dev/v1/orderitems | POST pengadaan/dev/v1/orderitems
*DefaultApi* | [**createProductRequest**](docs/DefaultApi.md#createProductRequest) | **POST** /pengadaan/dev/v1//product-requests | POST pengadaan/dev/v1//product-requests
*DefaultApi* | [**createVendor**](docs/DefaultApi.md#createVendor) | **POST** /vendors | POST vendors
*DefaultApi* | [**deleteBid**](docs/DefaultApi.md#deleteBid) | **DELETE** /pengadaan/dev/v1/bids/{id} | DELETE pengadaan/dev/v1/bids/{id}
*DefaultApi* | [**deleteOrderItemById**](docs/DefaultApi.md#deleteOrderItemById) | **DELETE** /pengadaan/dev/v1/orderitems/{id} | DELETE pengadaan/dev/v1/orderitems/{id}
*DefaultApi* | [**deleteProductByUuid**](docs/DefaultApi.md#deleteProductByUuid) | **DELETE** /pengadaan/dev/v1/products/{uuid} | DELETE pengadaan/dev/v1/products/{uuid}
*DefaultApi* | [**deleteProductRequest**](docs/DefaultApi.md#deleteProductRequest) | **DELETE** /pengadaan/dev/v1//product-requests/{id} | DELETE pengadaan/dev/v1//product-requests/{id}
*DefaultApi* | [**deleteVendorByUuid**](docs/DefaultApi.md#deleteVendorByUuid) | **DELETE** /vendors/{vendorUuid} | DELETE vendors/{vendorUuid}
*DefaultApi* | [**findVendorByUuid**](docs/DefaultApi.md#findVendorByUuid) | **GET** /vendors/{vendorUuid} | GET vendors/{vendorUuid}
*DefaultApi* | [**getAllBidsByProductRequestId**](docs/DefaultApi.md#getAllBidsByProductRequestId) | **GET** /pengadaan/dev/v1/bids/product/{productRequestId} | GET pengadaan/dev/v1/bids/product/{productRequestId}
*DefaultApi* | [**getAllOrderItems**](docs/DefaultApi.md#getAllOrderItems) | **GET** /pengadaan/dev/v1/orderitems | GET pengadaan/dev/v1/orderitems
*DefaultApi* | [**getAllOrders**](docs/DefaultApi.md#getAllOrders) | **GET** /pengadaan/dev/v1/orders | GET pengadaan/dev/v1/orders
*DefaultApi* | [**getAllProductRequests**](docs/DefaultApi.md#getAllProductRequests) | **GET** /pengadaan/dev/v1//product-requests | GET pengadaan/dev/v1//product-requests
*DefaultApi* | [**getAllProducts**](docs/DefaultApi.md#getAllProducts) | **GET** /pengadaan/dev/v1/products/{page}/{size} | GET pengadaan/dev/v1/products/{page}/{size}
*DefaultApi* | [**getAllProductsByVendorUuid**](docs/DefaultApi.md#getAllProductsByVendorUuid) | **GET** /pengadaan/dev/v1/products/vendor/{vendorUuid} | GET pengadaan/dev/v1/products/vendor/{vendorUuid}
*DefaultApi* | [**getAllVendors**](docs/DefaultApi.md#getAllVendors) | **GET** /vendors | GET vendors
*DefaultApi* | [**getBidById**](docs/DefaultApi.md#getBidById) | **GET** /pengadaan/dev/v1/bids/{id} | GET pengadaan/dev/v1/bids/{id}
*DefaultApi* | [**getOrderById**](docs/DefaultApi.md#getOrderById) | **GET** /pengadaan/dev/v1/orders/{orderId} | GET pengadaan/dev/v1/orders/{orderId}
*DefaultApi* | [**getOrderItemById**](docs/DefaultApi.md#getOrderItemById) | **GET** /pengadaan/dev/v1/orderitems/{id} | GET pengadaan/dev/v1/orderitems/{id}
*DefaultApi* | [**getOrdersByVendor**](docs/DefaultApi.md#getOrdersByVendor) | **GET** /pengadaan/dev/v1/orders/{vendorId}/vendor | GET pengadaan/dev/v1/orders/{vendorId}/vendor
*DefaultApi* | [**getOrdersByVendorIdWithPagination**](docs/DefaultApi.md#getOrdersByVendorIdWithPagination) | **GET** /pengadaan/dev/v1/orders/{vendorId}/{page}/{size} | GET pengadaan/dev/v1/orders/{vendorId}/{page}/{size}
*DefaultApi* | [**getProductByUuid**](docs/DefaultApi.md#getProductByUuid) | **GET** /pengadaan/dev/v1/products/{uuid} | GET pengadaan/dev/v1/products/{uuid}
*DefaultApi* | [**getProductRequestById**](docs/DefaultApi.md#getProductRequestById) | **GET** /pengadaan/dev/v1//product-requests/{id} | GET pengadaan/dev/v1//product-requests/{id}
*DefaultApi* | [**searchProducts**](docs/DefaultApi.md#searchProducts) | **GET** /pengadaan/dev/v1/products/search | GET pengadaan/dev/v1/products/search
*DefaultApi* | [**selectWinningBid**](docs/DefaultApi.md#selectWinningBid) | **PATCH** /pengadaan/dev/v1/bids/{bidId}/select | PATCH pengadaan/dev/v1/bids/{bidId}/select
*DefaultApi* | [**updateBid**](docs/DefaultApi.md#updateBid) | **PUT** /pengadaan/dev/v1/bids/{id} | PUT pengadaan/dev/v1/bids/{id}
*DefaultApi* | [**updateOrder**](docs/DefaultApi.md#updateOrder) | **PUT** /pengadaan/dev/v1/orders/{orderId} | PUT pengadaan/dev/v1/orders/{orderId}
*DefaultApi* | [**updateProduct**](docs/DefaultApi.md#updateProduct) | **PUT** /pengadaan/dev/v1/products/{uuid} | PUT pengadaan/dev/v1/products/{uuid}
*DefaultApi* | [**updateProductRequest**](docs/DefaultApi.md#updateProductRequest) | **PUT** /pengadaan/dev/v1//product-requests/{id} | PUT pengadaan/dev/v1//product-requests/{id}
*DefaultApi* | [**updateVendorByUuid**](docs/DefaultApi.md#updateVendorByUuid) | **PUT** /vendors/{vendorUuid} | PUT vendors/{vendorUuid}


## Documentation for Models



## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

Darkzill
UPTIRS RSUD SAM RATULANGI TONDANO


# DefaultApi

All URIs are relative to *http://rsudsamrat.site:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addOrderItemToOrder**](DefaultApi.md#addOrderItemToOrder) | **POST** /pengadaan/dev/v1/orders/{orderId}/items | POST pengadaan/dev/v1/orders/{orderId}/items
[**addProductToVendor**](DefaultApi.md#addProductToVendor) | **POST** /pengadaan/dev/v1/products/{vendorUuid} | POST pengadaan/dev/v1/products/{vendorUuid}
[**createBid**](DefaultApi.md#createBid) | **POST** /pengadaan/dev/v1/bids | POST pengadaan/dev/v1/bids
[**createOrder**](DefaultApi.md#createOrder) | **POST** /pengadaan/dev/v1/orders | POST pengadaan/dev/v1/orders
[**createOrderItem**](DefaultApi.md#createOrderItem) | **POST** /pengadaan/dev/v1/orderitems | POST pengadaan/dev/v1/orderitems
[**createProductRequest**](DefaultApi.md#createProductRequest) | **POST** /pengadaan/dev/v1//product-requests | POST pengadaan/dev/v1//product-requests
[**createVendor**](DefaultApi.md#createVendor) | **POST** /vendors | POST vendors
[**deleteBid**](DefaultApi.md#deleteBid) | **DELETE** /pengadaan/dev/v1/bids/{id} | DELETE pengadaan/dev/v1/bids/{id}
[**deleteOrderItemById**](DefaultApi.md#deleteOrderItemById) | **DELETE** /pengadaan/dev/v1/orderitems/{id} | DELETE pengadaan/dev/v1/orderitems/{id}
[**deleteProductByUuid**](DefaultApi.md#deleteProductByUuid) | **DELETE** /pengadaan/dev/v1/products/{uuid} | DELETE pengadaan/dev/v1/products/{uuid}
[**deleteProductRequest**](DefaultApi.md#deleteProductRequest) | **DELETE** /pengadaan/dev/v1//product-requests/{id} | DELETE pengadaan/dev/v1//product-requests/{id}
[**deleteVendorByUuid**](DefaultApi.md#deleteVendorByUuid) | **DELETE** /vendors/{vendorUuid} | DELETE vendors/{vendorUuid}
[**findVendorByUuid**](DefaultApi.md#findVendorByUuid) | **GET** /vendors/{vendorUuid} | GET vendors/{vendorUuid}
[**getAllBidsByProductRequestId**](DefaultApi.md#getAllBidsByProductRequestId) | **GET** /pengadaan/dev/v1/bids/product/{productRequestId} | GET pengadaan/dev/v1/bids/product/{productRequestId}
[**getAllOrderItems**](DefaultApi.md#getAllOrderItems) | **GET** /pengadaan/dev/v1/orderitems | GET pengadaan/dev/v1/orderitems
[**getAllOrders**](DefaultApi.md#getAllOrders) | **GET** /pengadaan/dev/v1/orders | GET pengadaan/dev/v1/orders
[**getAllProductRequests**](DefaultApi.md#getAllProductRequests) | **GET** /pengadaan/dev/v1//product-requests | GET pengadaan/dev/v1//product-requests
[**getAllProducts**](DefaultApi.md#getAllProducts) | **GET** /pengadaan/dev/v1/products/{page}/{size} | GET pengadaan/dev/v1/products/{page}/{size}
[**getAllProductsByVendorUuid**](DefaultApi.md#getAllProductsByVendorUuid) | **GET** /pengadaan/dev/v1/products/vendor/{vendorUuid} | GET pengadaan/dev/v1/products/vendor/{vendorUuid}
[**getAllVendors**](DefaultApi.md#getAllVendors) | **GET** /vendors | GET vendors
[**getBidById**](DefaultApi.md#getBidById) | **GET** /pengadaan/dev/v1/bids/{id} | GET pengadaan/dev/v1/bids/{id}
[**getOrderById**](DefaultApi.md#getOrderById) | **GET** /pengadaan/dev/v1/orders/{orderId} | GET pengadaan/dev/v1/orders/{orderId}
[**getOrderItemById**](DefaultApi.md#getOrderItemById) | **GET** /pengadaan/dev/v1/orderitems/{id} | GET pengadaan/dev/v1/orderitems/{id}
[**getOrdersByVendor**](DefaultApi.md#getOrdersByVendor) | **GET** /pengadaan/dev/v1/orders/{vendorId}/vendor | GET pengadaan/dev/v1/orders/{vendorId}/vendor
[**getOrdersByVendorIdWithPagination**](DefaultApi.md#getOrdersByVendorIdWithPagination) | **GET** /pengadaan/dev/v1/orders/{vendorId}/{page}/{size} | GET pengadaan/dev/v1/orders/{vendorId}/{page}/{size}
[**getProductByUuid**](DefaultApi.md#getProductByUuid) | **GET** /pengadaan/dev/v1/products/{uuid} | GET pengadaan/dev/v1/products/{uuid}
[**getProductRequestById**](DefaultApi.md#getProductRequestById) | **GET** /pengadaan/dev/v1//product-requests/{id} | GET pengadaan/dev/v1//product-requests/{id}
[**searchProducts**](DefaultApi.md#searchProducts) | **GET** /pengadaan/dev/v1/products/search | GET pengadaan/dev/v1/products/search
[**selectWinningBid**](DefaultApi.md#selectWinningBid) | **PATCH** /pengadaan/dev/v1/bids/{bidId}/select | PATCH pengadaan/dev/v1/bids/{bidId}/select
[**updateBid**](DefaultApi.md#updateBid) | **PUT** /pengadaan/dev/v1/bids/{id} | PUT pengadaan/dev/v1/bids/{id}
[**updateOrder**](DefaultApi.md#updateOrder) | **PUT** /pengadaan/dev/v1/orders/{orderId} | PUT pengadaan/dev/v1/orders/{orderId}
[**updateProduct**](DefaultApi.md#updateProduct) | **PUT** /pengadaan/dev/v1/products/{uuid} | PUT pengadaan/dev/v1/products/{uuid}
[**updateProductRequest**](DefaultApi.md#updateProductRequest) | **PUT** /pengadaan/dev/v1//product-requests/{id} | PUT pengadaan/dev/v1//product-requests/{id}
[**updateVendorByUuid**](DefaultApi.md#updateVendorByUuid) | **PUT** /vendors/{vendorUuid} | PUT vendors/{vendorUuid}


<a name="addOrderItemToOrder"></a>
# **addOrderItemToOrder**
> addOrderItemToOrder(orderId)

POST pengadaan/dev/v1/orders/{orderId}/items

### Example
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**orderId** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="addProductToVendor"></a>
# **addProductToVendor**
> addProductToVendor(vendorUuid)

POST pengadaan/dev/v1/products/{vendorUuid}

### Example
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
    String vendorUuid = "vendorUuid_example"; // String | 
    try {
      apiInstance.addProductToVendor(vendorUuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#addProductToVendor");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**vendorUuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="createBid"></a>
# **createBid**
> createBid()

POST pengadaan/dev/v1/bids

### Example
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
    try {
      apiInstance.createBid();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createBid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="createOrder"></a>
# **createOrder**
> createOrder()

POST pengadaan/dev/v1/orders

### Example
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
    try {
      apiInstance.createOrder();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createOrder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="createOrderItem"></a>
# **createOrderItem**
> createOrderItem()

POST pengadaan/dev/v1/orderitems

### Example
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
    try {
      apiInstance.createOrderItem();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createOrderItem");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="createProductRequest"></a>
# **createProductRequest**
> createProductRequest()

POST pengadaan/dev/v1//product-requests

### Example
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
    try {
      apiInstance.createProductRequest();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createProductRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="createVendor"></a>
# **createVendor**
> createVendor()

POST vendors

### Example
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
    try {
      apiInstance.createVendor();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createVendor");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteBid"></a>
# **deleteBid**
> deleteBid(id)

DELETE pengadaan/dev/v1/bids/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.deleteBid(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteBid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteOrderItemById"></a>
# **deleteOrderItemById**
> deleteOrderItemById(id)

DELETE pengadaan/dev/v1/orderitems/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.deleteOrderItemById(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteOrderItemById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteProductByUuid"></a>
# **deleteProductByUuid**
> deleteProductByUuid(uuid)

DELETE pengadaan/dev/v1/products/{uuid}

### Example
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
    String uuid = "uuid_example"; // String | 
    try {
      apiInstance.deleteProductByUuid(uuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteProductByUuid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**uuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteProductRequest"></a>
# **deleteProductRequest**
> deleteProductRequest(id)

DELETE pengadaan/dev/v1//product-requests/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.deleteProductRequest(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteProductRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="deleteVendorByUuid"></a>
# **deleteVendorByUuid**
> deleteVendorByUuid(vendorUuid)

DELETE vendors/{vendorUuid}

### Example
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
    String vendorUuid = "vendorUuid_example"; // String | 
    try {
      apiInstance.deleteVendorByUuid(vendorUuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteVendorByUuid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**vendorUuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="findVendorByUuid"></a>
# **findVendorByUuid**
> findVendorByUuid(vendorUuid)

GET vendors/{vendorUuid}

### Example
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
    String vendorUuid = "vendorUuid_example"; // String | 
    try {
      apiInstance.findVendorByUuid(vendorUuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#findVendorByUuid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**vendorUuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getAllBidsByProductRequestId"></a>
# **getAllBidsByProductRequestId**
> getAllBidsByProductRequestId(productRequestId)

GET pengadaan/dev/v1/bids/product/{productRequestId}

### Example
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
    BigDecimal productRequestId = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.getAllBidsByProductRequestId(productRequestId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAllBidsByProductRequestId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**productRequestId** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getAllOrderItems"></a>
# **getAllOrderItems**
> getAllOrderItems()

GET pengadaan/dev/v1/orderitems

### Example
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
    try {
      apiInstance.getAllOrderItems();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAllOrderItems");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getAllOrders"></a>
# **getAllOrders**
> getAllOrders()

GET pengadaan/dev/v1/orders

### Example
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
    try {
      apiInstance.getAllOrders();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAllOrders");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getAllProductRequests"></a>
# **getAllProductRequests**
> getAllProductRequests()

GET pengadaan/dev/v1//product-requests

### Example
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
    try {
      apiInstance.getAllProductRequests();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAllProductRequests");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getAllProducts"></a>
# **getAllProducts**
> getAllProducts(page, size)

GET pengadaan/dev/v1/products/{page}/{size}

### Example
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
    BigDecimal page = new BigDecimal(78); // BigDecimal | 
    BigDecimal size = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.getAllProducts(page, size);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAllProducts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**page** | **BigDecimal**|  |
**size** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getAllProductsByVendorUuid"></a>
# **getAllProductsByVendorUuid**
> getAllProductsByVendorUuid(vendorUuid)

GET pengadaan/dev/v1/products/vendor/{vendorUuid}

### Example
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
    String vendorUuid = "vendorUuid_example"; // String | 
    try {
      apiInstance.getAllProductsByVendorUuid(vendorUuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAllProductsByVendorUuid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**vendorUuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getAllVendors"></a>
# **getAllVendors**
> getAllVendors()

GET vendors

### Example
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
    try {
      apiInstance.getAllVendors();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getAllVendors");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getBidById"></a>
# **getBidById**
> getBidById(id)

GET pengadaan/dev/v1/bids/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.getBidById(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getBidById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getOrderById"></a>
# **getOrderById**
> getOrderById(orderId)

GET pengadaan/dev/v1/orders/{orderId}

### Example
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
      apiInstance.getOrderById(orderId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getOrderById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**orderId** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getOrderItemById"></a>
# **getOrderItemById**
> getOrderItemById(id)

GET pengadaan/dev/v1/orderitems/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.getOrderItemById(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getOrderItemById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getOrdersByVendor"></a>
# **getOrdersByVendor**
> getOrdersByVendor(vendorId)

GET pengadaan/dev/v1/orders/{vendorId}/vendor

### Example
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
    BigDecimal vendorId = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.getOrdersByVendor(vendorId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getOrdersByVendor");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**vendorId** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getOrdersByVendorIdWithPagination"></a>
# **getOrdersByVendorIdWithPagination**
> getOrdersByVendorIdWithPagination(vendorId, page, size)

GET pengadaan/dev/v1/orders/{vendorId}/{page}/{size}

### Example
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
    BigDecimal vendorId = new BigDecimal(78); // BigDecimal | 
    BigDecimal page = new BigDecimal(78); // BigDecimal | 
    BigDecimal size = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.getOrdersByVendorIdWithPagination(vendorId, page, size);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getOrdersByVendorIdWithPagination");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**vendorId** | **BigDecimal**|  |
**page** | **BigDecimal**|  |
**size** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getProductByUuid"></a>
# **getProductByUuid**
> getProductByUuid(uuid)

GET pengadaan/dev/v1/products/{uuid}

### Example
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
    String uuid = "uuid_example"; // String | 
    try {
      apiInstance.getProductByUuid(uuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getProductByUuid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**uuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="getProductRequestById"></a>
# **getProductRequestById**
> getProductRequestById(id)

GET pengadaan/dev/v1//product-requests/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.getProductRequestById(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getProductRequestById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="searchProducts"></a>
# **searchProducts**
> searchProducts(keyword, page, size)

GET pengadaan/dev/v1/products/search

### Example
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
    String keyword = "keyword_example"; // String | 
    BigDecimal page = new BigDecimal(78); // BigDecimal | 
    BigDecimal size = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.searchProducts(keyword, page, size);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#searchProducts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**keyword** | **String**|  |
**page** | **BigDecimal**|  |
**size** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="selectWinningBid"></a>
# **selectWinningBid**
> selectWinningBid(bidId)

PATCH pengadaan/dev/v1/bids/{bidId}/select

### Example
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
    BigDecimal bidId = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.selectWinningBid(bidId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#selectWinningBid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**bidId** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateBid"></a>
# **updateBid**
> updateBid(id)

PUT pengadaan/dev/v1/bids/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.updateBid(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateBid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateOrder"></a>
# **updateOrder**
> updateOrder(orderId)

PUT pengadaan/dev/v1/orders/{orderId}

### Example
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
      apiInstance.updateOrder(orderId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateOrder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**orderId** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateProduct"></a>
# **updateProduct**
> updateProduct(uuid)

PUT pengadaan/dev/v1/products/{uuid}

### Example
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
    String uuid = "uuid_example"; // String | 
    try {
      apiInstance.updateProduct(uuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateProduct");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**uuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateProductRequest"></a>
# **updateProductRequest**
> updateProductRequest(id)

PUT pengadaan/dev/v1//product-requests/{id}

### Example
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
    BigDecimal id = new BigDecimal(78); // BigDecimal | 
    try {
      apiInstance.updateProductRequest(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateProductRequest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **BigDecimal**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="updateVendorByUuid"></a>
# **updateVendorByUuid**
> updateVendorByUuid(vendorUuid)

PUT vendors/{vendorUuid}

### Example
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
    String vendorUuid = "vendorUuid_example"; // String | 
    try {
      apiInstance.updateVendorByUuid(vendorUuid);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateVendorByUuid");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**vendorUuid** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |


