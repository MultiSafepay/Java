<p align="center">
  <img src="https://www.multisafepay.com/img/multisafepaylogo.svg" width="400px" position="center">
</p>

# Java wrapper for the MultiSafepay API
This wrapper simplifies working with the MultiSafepay API and lets you integrate MultiSafepay in your Java application.

## About MultiSafepay
MultiSafepay is a Dutch payment services provider, which takes care of contracts, processing transactions, and collecting payments for a range of local and international payment methods. Start selling online today and manage all your transactions in one place!

## Requirements
You will need a MultiSafepay account. Consider a [test account](https://testmerchant.multisafepay.com/signup) first.

## Installation
Clone this git repository.

## Usage
Set up the client for testing:

```java
MultiSafepayClient.init(true, "YOUR_API_KEY");
```
Create an order:

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

See [more examples](https://github.com/MultiSafepay/Java/tree/master/src/com/MspIntegration/tests).

## Support

Create an issue on this repository or email <a href="mailto:integration@multisafepay.com">integration@multisafepay.com</a>

## Mistakes and improvements 
If you spot mistakes or want to help improve this wrapper, feel free to [create a pull request](https://github.com/MultiSafepay/Java/pulls).

## API reference
See MultiSafepay Docs – [API reference](https://docs.multisafepay.com/api/).

## License
[MIT License](https://github.com/MultiSafepay/Java/blob/master/LICENSE)
