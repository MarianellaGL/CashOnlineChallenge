# CashOnlineChallenge
Primer paso previo al deployed: hostee la base de datos, en este caso busque un host que me permitiese dejar el script de la base de datos en git y ya subida en una nube. 

Conecté la base de datos al workbench.

hice un push con todos los cambios que quedaban previos,inclusive los que ya estaban  listos, incluí también las collection del postman que utilicé para testear los controllers que generé.

para crear el deploy git bash here en la carpeta, 
en la linea de comandos 
utilicé git init
git add .
git commit -m "comentario"
heroku create 
git remote -v para comprobar el remoto que fue enviado a la app y finalmente git push heroku master

finalmente cuando termina el deployed se prueba en postman 

