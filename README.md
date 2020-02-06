# Utils-sample

# Respuestas en formato JSON!
Agregamos nuevos métodos. Estos son:
  - Modificar/agregar un objeto ó elemento al response de un Endpoint.
  - Orden de elementos por campos específicos simplificado.
  - Filtro de elementos/lista.

Todos estos métodos son hechos sin uso de librerías lo cual los hace un poco 
más complejo de escribir. Sin embargo es más factible hacerlo de esta manera ya que ciertas librerías
quedan deprecadas con el tiempo lo cual hace que tengamos que buscar una forma de optimizar de nuevo
el código ó buscar algun reemplazo.

# YouTube API Feature!
Para la implementación de la API de YouTube se deben seguir los siguientes pasos:
  - Declarar una API Key en tu cuenta Developers Console (Ver Documentación).
  - Obtener el SHA-1 del Keystore. Ej.: "inTerminal: keytool -list -v -keystore $keyPath -alias $aliasName"
  - Descargar sample code .ZIP de YouTube.
  - Agregar los .JAR files en la carpeta 'libs' de nuestro Proyecto Android.
  - Crear una clase 'DeveloperKey.java' y agrega el valor del API Key.
  - Crear una clase y extender de YouTubeBaseActivity e implementar sus propiedades.
  
  Para más configuraciones personalizadas ver la Documentación.
