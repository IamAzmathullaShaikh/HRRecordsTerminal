<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register - Organization</title>

<style>
  body {
    margin: 0;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: #f6f8fb;
    display: flex;
    justify-content: center;
    padding: 60px 20px;
  }

  .register-card {
    background: #fff;
    padding: 40px 35px;
    width: 400px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(44, 62, 80, 0.15);
  }

  .register-card h2 {
    text-align: center;
    margin-bottom: 30px;
    color: #22303c;
    font-weight: 700;
    font-size: 24px;
  }

  .register-card input,
  .register-card select {
    width: 100%;
    padding: 12px 14px;
    margin-bottom: 18px;
    border-radius: 8px;
    border: 1.5px solid #ced6e0;
    font-size: 16px;
  }

  .register-card input:focus,
  .register-card select:focus {
    outline: none;
    border-color: #2c3e50;
    box-shadow: 0 0 6px rgba(44, 62, 80, 0.3);
  }

  .register-card button {
    width: 100%;
    padding: 14px;
    background-color: #2c3e50;
    color: white;
    border: none;
    border-radius: 8px;
    font-weight: 600;
    font-size: 18px;
    cursor: pointer;
    margin-top: 10px;
  }

  .register-card button:hover {
    background-color: #1a252f;
  }

  .register-card p {
    text-align: center;
    margin-top: 20px;
    font-size: 14px;
    color: #7a8a99;
  }

  .register-card a {
    color: #2c3e50;
    font-weight: 600;
    text-decoration: none;
  }

  .register-card a:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>

<div class="register-card">
  <h2>Manager Registration</h2>

  <form action="<%= request.getContextPath() %>/ManagerRegistrationServlet" method="post">

    <input type="text" name="firstName" placeholder="First Name" required />
    <input type="text" name="lastName" placeholder="Last Name" required />

    <select name="gender" required>
      <option value="" disabled selected>Select Gender</option>
      <option value="Male">Male</option>
      <option value="Female">Female</option>
      <option value="Other">Other</option>
    </select>

    <input type="date" name="dob" required />

    <select name="maritalStatus" required>
      <option value="" disabled selected>Marital Status</option>
      <option value="Single">Single</option>
      <option value="Married">Married</option>
    </select>

    <select name="country" required>
      <option value="" disabled selected>Select Country</option>
      <option value="India">India</option>
      <option value="USA">USA</option>
      <option value="UK">UK</option>
    </select>

    <!-- ✅ Department Field -->
        <label for="department">Department</label>
    <input type="text" id="department" name="department">

    <input type="tel" name="phno" placeholder="Phone Number" required />
    <input type="email" name="email" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />

    <button type="submit">Register</button>
  </form>

  <p>
    Already registered?
    <a href="<%= request.getContextPath() %>/ManagerLogin.jsp">Login here</a>
  </p>
</div>

</body>
</html>
