# relacionBidireccional
aca puedes ver como implemento en sprinboot una relacion entre dos entidades de uno a muchos con la anotacion de  jpa @OneToMany

# json para crear en el cliente postman la factura
{
    "facturaId": 1,
    "fecha":"2023-02-02",
    "nombre_cliente":"juan",
    "ciudad":"Medellin",
    "telefono_cliente":"31054004",
    "correo_cliente":"juan@gmail.com"
}

# json para crear una linea de detalles de la factura

{
    "id":1,
    "producto": "biscicleta",
    "precio": 11500.0,
    "cantidad": 15,
    "factura":{
        "facturaId": 1
    }
}
