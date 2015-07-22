<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>

<title>Colegio Pensatorium</title>

<meta charset="utf-8">
<meta name="description" content="Place your description here">
<meta name="keywords" content="put, your, keyword, here">
<meta name="author" content="Templates.com - website templates provider">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<!--[if lt IE 7]>
     <link rel="stylesheet" href="css/ie/ie6.css" type="text/css" media="screen">
     <script type="text/javascript" src="js/ie_png.js"></script>
     <script type="text/javascript">
        ie_png.fix('.png, footer, header nav ul li a, .nav-bg, .list li img');
     </script>
<![endif]-->
<!--[if lt IE 9]>
  	<script type="text/javascript" src="js/html5.js"></script>
  <![endif]-->
</head>
<body id="page1">
<div class="wrap">
   <!-- header -->
   <header>
      <div class="container">
         <h1><a href="index.html">Student's site</a></h1>
         <nav>
            <ul>
            	<li><a href="#" class="m1">Inicio</a></li>
                <li><a href="/cerrar" class="m2">Cerrar</a></li>
                <li><a href="/noticias" class="m3">Noticias</a></li>
                <li><a href="/galeria" class="m4">Galeria de fotos</a></li>
            	<li class="last"><a href="sitemap.html" class="m5">Site Map</a></li>
                       	            
            </ul>
         </nav>
         <form action="" id="search-form">
            <fieldset>
            <div class="rowElem">
               <input type="text">
               <a href="#" onClick="document.getElementById('search-form').submit()">Search</a></div>
            </fieldset>
         </form>
      </div>
   </header>
   
   
   <div class="container">
      <!-- aside -->
      <aside>
         <h3>Categories</h3>
         <ul class="categories">
          
            <li><span><a href="/pensiones">Pagar Pensiones</a></span></li>
            <li><span><a href="/verPagos">Ultimos Pagos</a></span></li>
            <li><span><a href="/otorgarBecas">Otorgar Becas</a></span></li>                        
            <li><span><a href="/registrarse">Registrar Alumnos</a></span></li>
            <li><span><a href="/getList">Alumnos Matriculados</a></span></li>
            <li><span><a href="/modificarContraAl">Modificar contraseña de alumno</a></span></li>
            <li><span><a href="/crearCuenta">Crear cuenta profesor</a></span></li>
            <li><span><a href="/modificarContraAl">Modificar cuenta del profesor</a></span></li>
            <li><span><a href="/subirNoticias">Publicar Noticias</a></span></li>            
         
         </ul>
         
         <h2>Ultimas <span>Noticias</span></h2>
         <ul class="news">
            <li><strong>June 30, 2010</strong>
               <h4><a href="#">Sed ut perspiciatis unde</a></h4>
               Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque. </li>
            <li><strong>June 14, 2010</strong>
               <h4><a href="#">Neque porro quisquam est</a></h4>
               Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit consequuntur magni. </li>
            <li><strong>May 29, 2010</strong>
               <h4><a href="#">Minima veniam, quis nostrum</a></h4>
               Uis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae. </li>
         </ul>
      </aside>
      <!-- content -->
      <section id="content">
         <div id="banner">
            <h2>Profesionales <span>En Educación <span>Desde 1992</span></span></h2>
         </div><div class="ic">More Website Templates at TemplateMonster.com!</div>
         
         <div class="inside">
           
            <h2>Realizar pagos</h2>

			<form action="/getDeudas" method="get">
			Codigo de alumno:<br>
			<input type="text" name="codigo" required>
			<br></br>
			<input type="submit" value="Aceptar">
			<input type="reset" value="Borrar">
			</form>
                     
         </div>
         
         
      </section>
   </div>
</div>
<!-- footer -->
<footer>
   <div class="container">
      <div class="inside">
         <div class="wrapper">
            <div class="fleft">24/7 Customer Service <span>8.800.146.56.7</span></div>
            <div class="aligncenter"><a rel="nofollow" href="http://www.templatemonster.com" class="new_window">Website template</a> designed by TemplateMonster.com<br>
               <a href="http://www.templates.com/product/3d-models/" class="new_window">3D Models</a> provided by Templates.com</div>
         </div>
      </div>
   </div>
</footer>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>