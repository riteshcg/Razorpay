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
