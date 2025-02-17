Documentación de la API
Recurso: Usuarios
Endpoint: /api/usuarios

Método HTTP: GET

Descripción: Obtener todos los usuarios.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "nombre": "Juan Pérez",
        "edad": 30,
        "email": "juan@example.com"
    }
]
Endpoint: /api/usuarios/{id}

Método HTTP: GET

Descripción: Obtener un usuario por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Juan Pérez",
    "edad": 30,
    "email": "juan@example.com"
}
Endpoint: /api/usuarios

Método HTTP: POST

Descripción: Crear un nuevo usuario.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Juan Pérez",
    "edad": 30,
    "email": "juan@example.com"
}
Endpoint: /api/usuarios/u{id}

Método HTTP: PUT

Descripción: Actualizar un usuario existente por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Juan Pérez",
    "edad": 31,
    "email": "juan@example.com"
}
Endpoint: /api/usuarios/d{id}

Método HTTP: DELETE

Descripción: Eliminar un usuario por su ID.

Respuesta: 204 No Content

Endpoint: /api/usuarios/{usuarioId}/actividades/{actividadId}

Método HTTP: POST

Descripción: Asociar una actividad a un usuario.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Juan Pérez",
    "edad": 30,
    "email": "juan@example.com"
}
Recurso: Hoteles
Endpoint: /api/hoteles

Método HTTP: GET

Descripción: Obtener todos los hoteles.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "nombre": "Hotel Plaza",
        "direccion": "Calle Mayor 1",
        "estrellas": 5
    }
]
Endpoint: /api/hoteles/{id}

Método HTTP: GET

Descripción: Obtener un hotel por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Hotel Plaza",
    "direccion": "Calle Mayor 1",
    "estrellas": 5
}
Endpoint: /api/hoteles/mas-estrellas/{stars}

Método HTTP: GET

Descripción: Obtener hoteles con un mínimo de estrellas.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "nombre": "Hotel Plaza",
        "estrellas": 5
    }
]
Endpoint: /api/hoteles

Método HTTP: POST

Descripción: Crear un nuevo hotel.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Hotel Plaza",
    "direccion": "Calle Mayor 1",
    "estrellas": 5
}
Endpoint: /api/hoteles/u{id}

Método HTTP: PUT

Descripción: Actualizar un hotel existente por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Hotel Plaza",
    "direccion": "Calle Mayor 1",
    "estrellas": 5
}
Endpoint: /api/hoteles/d{id}

Método HTTP: DELETE

Descripción: Eliminar un hotel por su ID.

Respuesta: 204 No Content

Recurso: Habitaciones
Endpoint: /api/habitaciones

Método HTTP: GET

Descripción: Obtener todas las habitaciones.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "numero": "101",
        "tipo": "Individual",
        "precio": 100.0
    }
]
Endpoint: /api/habitaciones/{id}

Método HTTP: GET

Descripción: Obtener una habitación por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "numero": "101",
    "tipo": "Individual",
    "precio": 100.0
}
Endpoint: /api/habitaciones/c{hotelId}

Método HTTP: POST

Descripción: Crear una nueva habitación asociada a un hotel.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "numero": "101",
    "tipo": "Individual",
    "precio": 100.0
}
Endpoint: /api/habitaciones/tipo/{tipo}

Método HTTP: GET

Descripción: Obtener habitaciones por tipo.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "numero": "101",
        "tipo": "Individual",
        "precio": 100.0
    }
]
Endpoint: /api/habitaciones/precio/{precio}

Método HTTP: GET

Descripción: Obtener habitaciones con precio máximo.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "numero": "101",
        "tipo": "Individual",
        "precio": 100.0
    }
]
Endpoint: /api/habitaciones/u{id}

Método HTTP: PUT

Descripción: Actualizar una habitación existente por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "numero": "101",
    "tipo": "Individual",
    "precio": 100.0
}
Endpoint: /api/habitaciones/d{id}

Método HTTP: DELETE

Descripción: Eliminar una habitación por su ID.

Respuesta: 204 No Content

Recurso: Actividades Turísticas
Endpoint: /api/actividades

Método HTTP: GET

Descripción: Obtener todas las actividades turísticas.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "nombre": "Visita al Museo",
        "descripcion": "Recorrido por el museo",
        "fecha": "2023-12-15"
    }
]
Endpoint: /api/actividades/{id}

Método HTTP: GET

Descripción: Obtener una actividad turística por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Visita al Museo",
    "descripcion": "Recorrido por el museo",
    "fecha": "2023-12-15"
}
Endpoint: /api/actividades/fecha/{date}

Método HTTP: GET

Descripción: Obtener actividades por fecha.

Ejemplo de Respuesta:

json
Copy
[
    {
        "id": 1,
        "nombre": "Visita al Museo",
        "fecha": "2023-12-15"
    }
]
Endpoint: /api/actividades

Método HTTP: POST

Descripción: Crear una nueva actividad turística.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Visita al Museo",
    "descripcion": "Recorrido por el museo",
    "fecha": "2023-12-15"
}
Endpoint: /api/actividades/u{id}

Método HTTP: PUT

Descripción: Actualizar una actividad turística por su ID.

Ejemplo de Respuesta:

json
Copy
{
    "id": 1,
    "nombre": "Visita al Museo",
    "descripcion": "Recorrido por el museo",
    "fecha": "2023-12-15"
}
Endpoint: /api/actividades/d{id}

Método HTTP: DELETE

Descripción: Eliminar una actividad turística por su ID.

Respuesta: 204 No Content
