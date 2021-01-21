This is a simple application developed for payment integration with Razor pay using Java.

These options are used:

- Spring Boot
- Java
- Mysql databse
- Hibernate
- Html,CSS for form

*Before Running this project, you have to create an account in RazorPay. Below is the url:
- https://dashboard.razorpay.com/#/access/signup 

*Generate secretID and secretKey.

After doing the above things, follow the below steps:

1. Clone the project or download the zip file.
2. Do a maven update on the project if necessary
3. Use the above generated secretID and secretKey and replace this values in the service class RazorPayService.java
4. Run the main application
5. Now use the URL "http://localhost:8080/razorapp/home" Fill the form click the Pay button. 
6. You will redirected to razorpay payment gateway after the above steps.
7. After successful transaction which is just a test mode, you can see the transaction details in your razorpay dashboard under transactions section.

Walkthrough of the code:

- After creating the sandbox account in razorpay, and copying the secretkey and secretId got from there, we invoke razorpay client as done in service class(RazorPayService.class).

- I have created two entities "customer" and "razorpay", customer for storing the form details and razorpay for storing razorpayOrderId, application fees, secret key, paymentId,
Notes, imageurl, merchant name, purchase description, customer anme, customer email, all these fields to store for this entity.

- I have followed the razorpay manual checkout option(https://razorpay.com/docs/payment-gateway/web-integration/standard/) and from my frontend itself, I am calling the api - "razorapp/payment" which I have defined in the controller itself.

- After this, api is hit, I store all the fields of "manual checkout" from my backend itself.(I am setting them in the razorpay service class itself).

- After hitting this api -"http://localhost:8080/razorapp/home" , you will be redirect to form which I have created as "home.html" which is the home page and then you need to submit all your details.

- After that, you need to hit the pay button.
,
- On pressing the pay button, it will redirect to "razorpay payment gateway", where you need to choose your payment method.

- After choosing the payment method, you need to press pay button and then it will redirect to a page where you will see "success" or "failure"(2 options, since it is in testing mode and not in live mode).

- If you press on "success", it will prompt a message that "Payment completed successfully".

- If you press on "failure", it will prompt a message that "payment_failed" and ask to retry payment.

- In service class, "createRazorPayOrder" is used to get the order amount and "getRazorPay" is used to get the orderId, and set razorpay details. "convertRupeeToPaise" is used to convert into paise and store the amount.

- All the transaction details will be saved in razorpay transaction section of the razorpay dashboard. Fields that will be saved there are:-> Payment Id, Razorpay Order Id, Amount, Email, Contact, Created At, Status(failed or captured)
