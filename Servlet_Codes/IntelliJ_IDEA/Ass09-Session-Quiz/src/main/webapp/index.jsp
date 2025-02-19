<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Asap:wght@400;600&display=swap');

        body {
            background-color: rgba(244, 91, 105, 1);
            font-family: 'Asap', sans-serif;
        }

        .login {
            overflow: hidden;
            background-color: white;
            padding: 40px 30px 30px 30px;
            border-radius: 10px;
            position: absolute;
            top: 50%;
            left: 50%;
            width: 400px;
            transform: translate(-50%, -50%);
            transition: transform 300ms, box-shadow 300ms;
            box-shadow: 5px 10px 10px rgba(2, 128, 144, 0.2);
        }

        .login::before, .login::after {
            content: '';
            position: absolute;
            width: 600px;
            height: 600px;
            border-top-left-radius: 40%;
            border-top-right-radius: 45%;
            border-bottom-left-radius: 35%;
            border-bottom-right-radius: 40%;
            z-index: -1;
        }

        .login::before {
            left: 40%;
            bottom: -130%;
            background-color: rgba(69, 105, 144, 0.15);
            animation: waves 6s infinite linear;
        }

        .login::after {
            left: 35%;
            bottom: -125%;
            background-color: rgba(2, 128, 144, 0.2);
            animation: waves 7s infinite;
        }

        .login input {
            font-family: 'Asap', sans-serif;
            display: block;
            border-radius: 5px;
            font-size: 16px;
            background: white;
            width: 100%;
            border: 0;
            padding: 10px;
            margin: 15px 0;
        }

        .login button {
            font-family: 'Asap', sans-serif;
            cursor: pointer;
            color: #fff;
            font-size: 16px;
            text-transform: uppercase;
            width: 100%;
            border: 0;
            padding: 10px;
            border-radius: 5px;
            background-color: rgba(244, 91, 105, 1);
            transition: background-color 300ms;
        }

        .login button:hover {
            background-color: rgb(219, 79, 91);
        }

        @keyframes waves {
            from { transform: rotate(0); }
            to { transform: rotate(360deg); }
        }

        a {
            text-decoration: none;
            color: rgba(255, 255, 255, 0.6);
            position: absolute;
            right: 10px;
            bottom: 10px;
            font-size: 12px;
        }
    </style>
</head>
<body>


    <form class="login" method="post" action="./login-servlet">
        <input type="text" placeholder="Username" name="username" required>
        <input type="password" placeholder="Password" name="password" required>

        <input type="submit" value="Login">
    </form>


</body>
</html>
