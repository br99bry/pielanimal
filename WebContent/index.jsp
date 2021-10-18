<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    
    <link rel="stylesheet" href="css/mainStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Muli&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Inicio de sesión</title>
</head>
<body>
    <header class="header">
        <img class="header__img" style="width: 50px; height: 50px; margin: 15px" src="img/logo.png" alt="">
    </header>

    <section class="login">
        <section class="login-container">
            <h2>Inicia sesión</h2>
            
            <form action="${pageContext.request.contextPath}/indexStore.jsp" class="login-container-form">
                <input type="text" class="input" placeholder="Usuario" name="user" required>
                <input type="password" class="input" placeholder="Constraseña" name="pwd" required>
                <button class="button">Iniciar sesión</button>
                
            </form>
            <section class="login-container-socialmedia">      
                <p class="login-container-register">No tienes ninguna cuenta  <a href="${ pageContext.request.contextPath }/register.jsp">Registrate</a></p>         
            </section>
        </section>
    </section>

    <footer class="footer">
        <a href="/">Terminos de uso</a>
        <a href="/">Declaración de privacidad</a>
        <a href="/">Centro de ayuda</a>
    </footer>
</body>
</html>