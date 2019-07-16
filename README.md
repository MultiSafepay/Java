<p align="center">
  <img src="https://www.multisafepay.com/img/multisafepaylogo.svg" width="400px" position="center">
</p>

# Java wrapper for the MultiSafepay API
This wrapper simplifies working with the MultiSafepay API and allows you to integrate MultiSafepay within your Java application.

## About MultiSafepay ##
MultiSafepay is a collecting payment service provider which means we take care of the agreements, technical details and payment collection required for each payment method. You can start selling online today and manage all your transactions from one place.

## Requirements
- To use the wrapper you need a MultiSafepay account. You can create a test account on https://testmerchant.multisafepay.com/signup

## Installation
- Clone this git repository.

## Usage
Setup the client for testing
```java
MultiSafepayClient.init(true, "YOUR_API_KEY");
```
Setup the client for testing
```java
Order order = new Order();
order.setRedirect(
        '1234', 
        "Product description",
        1000, 
        "EUR", 
        new PaymentOptions(
            "https://example.com/notify",
            "https://example.com/success",
            "https://example.com/failed"
            )
        );

    JsonObject jsonResponse = MultiSafepayClient.createOrder(order);
    System.out.println(jsonResponse);

    String payment_url = MultiSafepayClient.getPaymenUrl(jsonResponse);
    System.out.println(payment_url);
```

Click [here](https://github.com/MultiSafepay/Java/tree/master/src/com/MspIntegration/tests) for more examples.

## Support
If you have any issues, problems or questions you can create an issue on this repository or contact us at <a href="mailto:techsupport@multisafepay.com">techsupport@multisafepay.com</a>

## Mistakes and improvements 
If you spot mistakes or want to contribute in improving this wrapper, feel free to [create pull requests](https://github.com/MultiSafepay/Java/pulls)

## API Documentation
[Click here](https://docs.multisafepay.com/api/) for the MultiSafepay API documentation.

## License
[MIT License](https://github.com/MultiSafepay/Java/blob/master/LICENSE)