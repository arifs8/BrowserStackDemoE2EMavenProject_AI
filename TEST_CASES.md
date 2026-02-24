# Test Cases - BrowserStack Demo E-Commerce

This document outlines 10 critical test scenarios for the BrowserStack Demo application, designed by a Senior QA Automation Lead (15+ years experience) using the **RICE POT** framework.

## 📝 Test Case Suite

| TC_ID | Category | Description | Pre-condition | Steps | Expected Result | Priority |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **TC_001** | Positive (Login) | Successful login with valid credentials and "Remember Me" checked. | User has valid account details. | 1. Navigate to bstackdemo.com 2. Click Sign In 3. Select valid Email/Username 4. Select valid Password 5. Check 'Remember me' 6. Click Log In | User is successfully logged in and session is preserved for next visit. | High |
| **TC_002** | Positive (Login) | Successful login and adding a product to the cart. | User is on the login page. | 1. Log in with valid credentials 2. Locate 'iPhone 12 Mini' 3. Click 'Add to cart' | Product is added to the cart and cart count increments. | High |
| **TC_003** | Positive (Login) | Navigate to 'Create a free account' from login page. | User is on the login page. | 1. Click on 'Create a free account' link | User is redirected to the account registration page. | Medium |
| **TC_004** | Negative (Validation) | Login attempt with an invalid email format. | Browser is open at the login page. | 1. Enter invalid email (e.g., 'user@invalid') 2. Enter valid password 3. Click 'Log In' | System displays a validation error for invalid email format. | High |
| **TC_005** | Negative (Validation) | Login attempt with an empty email field. | Browser is open at the login page. | 1. Leave email empty 2. Enter password 3. Click Log In | Error message shown indicating email field is mandatory. | High |
| **TC_006** | Negative (Validation) | Login attempt with incorrect password. | User has a valid email/username. | 1. Select valid email 2. Enter an incorrect password 3. Click Log In | [ASSUMPTION] Error message "Invalid Password" is displayed. | High |
| **TC_007** | Negative (Validation) | Verification of 'Forgot Password' link functionality. | User is on the login page. | 1. Click 'Forgot password' link | User is redirected to the password recovery page. | Medium |
| **TC_008** | Negative (Validation) | Login attempt with non-existent email/username. | Browser is open at the login page. | 1. Enter a non-registered email 2. Enter any password 3. Click Log In | Error message shown: "User does not exist" or similar. | Medium |
| **TC_009** | Security | Brute force protection check (Multiple failed attempts). | Account is in a normal state. | 1. Perform 10 consecutive login attempts with wrong passwords | [ASSUMPTION] Account is temporarily locked or CAPTCHA is triggered. | High |
| **TC_010** | Performance | Login response time under standard network conditions. | Stable internet connection. | 1. Enter valid credentials 2. Click Log In 3. Measure time until Dashboard is interactive | Login process should complete within 2 seconds. | Medium |

---

## 🔍 Assumptions & Observations
- **[ASSUMPTION]**: Since specific error messages are not provided in the prompt, standard industry-standard messages are expected.
- **[ASSUMPTION]**: Performance threshold of 2 seconds is based on e-commerce UX best practices.
- **Not specified**: Password complexity rules (characters, length) were not specified as per constraints.
- **Not specified**: Specific SQL Injection strings were not defined, but TC_009 covers general security resiliency.
