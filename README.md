## Ejemplo de un proceso con Flowable y Spring Boot

Este programa es una prueba de concepto de un proceso BPM ejecutado con Flowable y Spring. El proceso tiene solo dos etapas una etapa inicial y una etapa de revisión. Cuando se ejecuta la etapa de revisión se ejecutan dos acciones dependiendo de si se aprueba o no la tarea.

Exponemos tres servicios: 
- Iniciar proceso 
- Listar tareas
- Aprobar una tarea

Para inciar el proceso
```
post http://localhost:8080/iniciar
Content-Type: application/json

{
  "id": "1234",
  "author": "yo",
  "url": "yo.geocities.org/myfunnyarticle"
}
```

Para listar las tareas
```
get http://localhost:8080/tareas?asignado=yo
Content-Type: application/json
```


Para cerrar la tarea
```
post http://localhost:8080/revisar
Content-Type: application/json

{
  "id": "8414675f-c3b4-11e9-9fa3-843a4b00acdc",
   "status": true
}
```

Ejemplo tomado del tutorial [Introduction to Flowable](http://www.baeldung.com/flowable)
