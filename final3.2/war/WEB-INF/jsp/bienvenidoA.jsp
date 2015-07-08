<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%HttpSession misesion= request.getSession();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Colegio Pensatorium</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>

<div id="container">
<div class="Login_box">
<div class="clear"></div>
<ul id="nav_list">
<li class="li_nav_body"><a href="pensiones.jsp">Pensiones</a></li>
<li class="li_nav_body"><a href="/getList2">Noticias</a></li>
<li class="li_nav_footer"><a href="#">Avisos</a></li>	
<li class="li_nav_footer"><a href="galeria">Galeria de fotos</a></li>
<%if(misesion.getAttribute("nombre")!=null){%>
<li class="li_nav_footer"><a href="/cerrar">Cerrar Sesion</a></li>
<%}%>
</ul>
<div class="clear"></div>
</div>

  <div id="head">
    <!-- aqui falta agregar la insignia del colegio <img src="assets/bg.jpg" style="padding-left:0px; float:left; border-bottom: 1px solid #B5BC5D;"/>-->
    <h1>Colegio<span class="red"><br />
Pensatorium</span></h1>
</div>

<div id="content">
<div class="Login_box">
<p><b class="yellow">Info</b>
</p><p style="color:#FFFFFF; text-align:left">Colegio Pensatorium - Av. Pedro Picapiedra 977 Teléfono: 051-054 202020 Fax: 051-054 23624  </p>
<p style="color:#FFFFFF; text-align:left">Arequipa-Perú | 2015 </p>
</div>
<br></br><br></br>
<div class="content_box_large">
<h3>Bienvenido alumno <%=misesion.getAttribute("nombre") %>  </h3>

</div>

<div class="content_box">
<h3>Noticias</h3>
<p>aqui se agregaran las noticias mas actuales</p>
<div class="date" ><a href="">Read more...</a></div>
<h3>Fotos</h3>
<p align="center"><a href="#"><img src="assets/photo.jpg" /></a></p>
<p align="center"><a href="#"><img src="assets/photo2.jpg" /></a></p>
<div class="date" ><a href="">More photos...</a></div>
</div>

<div class="clear"></div>
</div>

<div class="content_box_photo">

</div>

</div>


<div id="content_footer">
<p align="center">
    <a href="http://validator.w3.org/check?uri=referer"><img
      src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" height="31" width="88" /></a>
  	<a href="http://jigsaw.w3.org/css-validator/check/referer">
        <img style="border:0;width:88px;height:31px"
            src="http://jigsaw.w3.org/css-validator/images/vcss"
            alt="¡CSS Válido!" />
    </a>
    <a href="http://jigsaw.w3.org/css-validator/check/referer">
    <img style="border:0;width:88px;height:31px"
        src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
        alt="¡CSS Válido!" />
    </a>
    <td style="text-align: right;">Siguenos en:<a href="https://www.facebook.com/" target="_blank"><img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTjMDOpv17rmwMjZ7vyHhf1v1sdFKLE4a088--Bma0mSQM2hAO_" width="25" height="25" alt="facebook" /></a>&nbsp;<img src="data:image/png;base64,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" width="25" height="25" alt="twitter" />&nbsp;<a href="http://www.youtube.com" target="_blank"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJcAAABdCAMAAACfMgSZAAAAyVBMVEX///8AAADBIibYKifhLSjeLCjGJCbSKCfJJSfU1NT47e3NJid2dna3t7fbAADpr6/gGxPKAAD439/vx8fMzMzsvr6oqKj89vbSRkbAGh/OMjOhoaHul5XRHx7XQ0O8AADWZ2baXl3JVljOVVXWGBTIHB7d3d3dZmUbGxvs7OxPT0/cNDDAwMBsbGzSAAAODg4uLi7ObG7wqKZAQEDae3uOjo7JDxHikpLbhIXjpKXGODrKSEnblpi9BQ/x0dE3NzfriIbmXFheXl4WlUEVAAAEgklEQVRoge2YW3uqOhBAg9YbVhGU4g2hGqxWSr3VYiu23f//R52ZBBVb6Vbc+p2HrIcmwSCLYTLEEiIQCAQCgUAgEAgEAoHgf4why7KmrddVXVGmSHsDGymKXl2vNQ1mGdeT0tpfnRGtlEMqP9l+Qkedr7Z2Ha3PcuXmFCrl9jW0vsonWSHl+8trfZYzp3P5iMmVBFqZTOXS6T/14O4j7GnigRgvJdnlhtJg8DHE3mwwkGrxEx9uMmUtwifdXfwGKsP0cDzpQzIvMpMkqQCtAe14GDtNHkFUogfaEQ8qE6J7MQFL6HUHPi/QutA+xU/TvEx634se51VOmGB98HmE9gVaN37aupxOl6GKyzjAav5J01tM5pU+iJe0uH5I0gCe30CSnuMfI7/saDSq4GU60Ile+1evakKvFgvU8PfHSBQvcvsdM50xTZMpYRN60comhialNBOekHBBkgIY3ZIS/L2DkVF6eQlXpeu6sCCGbs0dYpmIemXSuU6n3kynm/VOfRR6mf7U5rNopz31R1ySJvUiY1iI5Ba8hjz74bniAiU8giW+Xn26Fy8Tl79CWTAeTPRS7jHBlyhm6ux7+a3QaVIvyPjnAqTXH0JqUkife91uvebfvPDFp3gsGPfMK0zvppmmm0xX8Bz6mtQLHySuxhYhj9B8jMNU2/OyzRwj1guWLP55pdSHxmCDdzgpuZfxwWM0ZDXjiZVarLB7Xg+HvGg0XiNvzo55oGQUVXzQUzWXW/hJvVhuSdKMR67EV2g/xkuN84K8r8Og6lEDq3DOwwh6uZw5T+zFs6rFOy5/BRSO8VKjXmro1TSYEHpp53kNx2GqH+tVP+zVAaOqil6aaqrne5EnrA3khHjlTJt5LaJeufrWy4ANxz/wKoXv7qPj9TevEE09z6vG0+tXL6fI4F6OE/VyuJdzwKtYNJOvx2O8bDPWq+s43720YoeRKxYXievXUV7zeK/7n15rCJQKFC/u5S9O9FKrur5cXNxrtcgzuFdx47Uku+dYZPUrrBN5VifUfJ5N+Qde3+t9i3stD3qpVRLNL+ZlfvNKvM/ZefW5yu79+MTfBQW87E8vXWXPiHtpdTbSF2xGV50TfpKqn+9F/uBmf7bbTzw/SqHXWs0yuFfD6eF0vqHhXlBLcbAMHH87mDjhCed6FcLt1wD3X2ybMb7lXtq+VzbLqpShb700XrZ6TjZYh19bBa2sJZ/j9cy9SI29KmeoxTJ+1nfhM/CS89zLCr0sTGf5LZL3XRTQrWy2keI/NXSngTeSXIsY/X5/81vIbbU2v7oLd65BhvAZhqLnMK9G1+7aKegsJqu5E7zDqJnNd227t2j4rxMW1bzV81d+z8K+836G1zG8BilGA8hixwmc7QibVJYd4ZOg22C94IwycRSalUqCdfH/GdrO3y1+ENiX1iJy0DhZq5E6YzUei/Zm8cw62sp6v4IWoNhvFhIEkNaxOEHAZjV6Z7yCTkSW17qyXPn+fDKZ2HYX6TFY17Ynk7nvr5aKvtauEyuBQCAQCAQCgUAgEAgE+/wHCSagwu/vLLIAAAAASUVORK5CYII=" width="25" height="25" alt="youtube" /></a></td>
    
  </p>
  
  
</div>       
</body>
</html>