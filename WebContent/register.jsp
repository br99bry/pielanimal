<!DOCTYPE html>
<html lang="en">
<head>
    
    <link rel="stylesheet" href="/css/mainStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Muli&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/register.css">
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <header class="header">
        <img class="header__img" src="images/logo-platzi-video.png" alt="">
    </header>

    <section class="login">
        <section class="login-container">
            <h2>Registrate</h2>
            <form action="" class="login-container-form">
                <input type="password" class="input" placeholder="Nombre">
                <input type="text" class="input" placeholder="Correo">
                <input type="password" class="input" placeholder="Constraseña">
                <button class="button">Registrarme</button>
                <a href="${ pageContext.request.contextPath }/index.jsp">Iniciar sesión</a>
            </form>
        </section>
    </section>

    <footer class="footer">
        <a href="/">Terminos de uso</a>
        <a href="/">Declaración de privacidad</a>
        <a href="/">Centro de ayuda</a>
    </footer>
</body>
</html>