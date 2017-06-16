# Sync

Ejemplo de sincronización de datos entre Sqlite Con Mysql en Android 

## Arquitectura Basada En Un SyncAdapter

Estilos arquitecturales que podemos usar a la hora de comunicar nuestras aplicaciones Android con un servicio REST. [Google I/O 2010 – Android REST client applications (Video)](https://youtu.be/xHXn3Kg2IQE)

El patrón está basado en un componente llamado SyncAdapter, cuya funcionalidad es sincronizar datos en segundo plano entre una aplicación Android y un servidor remoto.

![Patrón de Sincronizacióon de Datos](http://www.hermosaprogramacion.com/wp-content/uploads/2015/07/arquitectura-centrada-en-syncadapter.png)

Esta arquitectura se enfoca en evitar realizar la sincronización en el UI Thread. Lo que libera a nuestras actividades de operaciones en la base de datos, peticiones Http, etc.

La sincronización en Android está ligada al uso de cuentas de usuario para determinar qué datos asociados serán procesados.
Esto quiere decir que no es posible usar sincronización sin crear al menos una cuenta asociada a la aplicación.

## Formas para Iniciar un SyncAdapter

1. **Por Cambios en el servidor** — En este escenario, el Sync Adapter se inicia debido a que se produce una petición desde el servidor hacia el dispositivo Android, cuando los datos en él cambian . A esto se le llama notificaciones push y podemos implementarlo con el servicio de Firebase Cloud Messaging.
1. **Por Cambios en el contenido local** — Cuando los datos del Content Provider son modificados en la aplicación local, el Sync Adapter puede iniciarse automáticamente para subir los datos nuevos al servidor y asegurar una actualización.
1. **Al enviar mensaje de red** — Android comprueba la disponibilidad de la red enviando un mensaje de prueba con frecuencia. Podemos indicar a nuestro Sync Adapter que se inicie cada vez que este mensaje es liberado.
1. **Programando intervalos de tiempo**— En este caso podemos programar el Sync Adapter para que se ejecute cada cierto tiempo continuamente o si lo deseas, en una hora determinada del día.
1. **Manualmente (por demanda)**— El sincronizador se inicia por petición del usuario en la interfaz. Por ejemplo, pulsando un action button.

## Tareas a Realizar en el proyecto

* Crear servicio web con Php y Mysql
  1. Diseñar e implementar base de datos
  1. Implementar conexión a la base de datos
  1. Implementar métodos de operación de datos
  
   
* Desarrollar Aplicación Android
  1. Creación De Content Provider
  1. Preparar capa de conexión con Volley
  1. Añadir autenticación de usuarios
  1. Añadir SyncAdapter
  1. Implementar adaptador del RecyclerView
  1. Creación de la actividad principal
  1. Creación de la actividad de inserción
  
  
> Este ejemplo ha sido realizado en base al Artículo [
¿Cómo Sincronizar Sqlite Con Mysql En Android?](http://www.hermosaprogramacion.com/2015/07/usar-transiciones-en-android-con-material-design/) de *James Revelo*
