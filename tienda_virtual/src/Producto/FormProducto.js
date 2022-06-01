import "./producto.css";
import Menu from "../Menu/Menu";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import React, { useEffect } from "react";

function FormProducto() {
   //const navigate = useNavigate();
   const MySwal = withReactContent(Swal);
   const navigate = useNavigate();
 
   let params = useParams(); // captura parameetros de la url { cedula }
 
   const InicializarForm = async () => {
     // validar si hay algo en el parametro cedula
     if (params.codigo) {
       // hacer un get por cedula para traer los datos
       // despues de tener los datos asociales a los input los datos correspondientes
       const response = await fetch(
         "http://localhost:8080/Producto/" + params.codigo
       );
       const data = await response.json();
       console.log(data);
       document.getElementById("codigo_Productos").value = data.codigo_Producto;
       document.getElementById("nombre_Productos").value = data.nombre_Producto;
       document.getElementById("nit_Proveedores").value = data.nit_Proveedor;
       document.getElementById("precio_Compras").value = data.precio_Compra;
       document.getElementById("iva_Productos").value = data.iva_Producto;
       document.getElementById("precio_Venta_Productos").value = data.precio_Venta_Producto;
      
     }
   };
   useEffect(() => {
     //sirve para ejecutar esa funcion apenas carga o cuando cambia una variable dentro de la funcion
     InicializarForm();
   }, []);
 
   const crearNuevoProducto = async (e) => {
     e.preventDefault();
 
     const codigoProducto = document.getElementById("codigo_Productos").value;
     const nombreProducto = document.getElementById("nombre_Productos").value;
     const nitProveedor = document.getElementById("nit_Proveedores").value;
     const precioCompra = document.getElementById("precio_Compras").value;
     const ivaProducto = document.getElementById("iva_Productos").value;
     const precioVentaProducto = document.getElementById("precio_Venta_Productos").value;
 
     if (
       codigoProducto &&
       nombreProducto &&
       nitProveedor &&
       precioCompra &&
       ivaProducto&&
       precioVentaProducto
     ) {
       const clienteCompleto = {
         codigo_Producto: codigoProducto,
         nombre_Producto: nombreProducto,
         nit_Proveedor: nitProveedor,
         precio_Compra: precioCompra,
         iva_Producto: ivaProducto,
         precio_Venta_Producto:precioVentaProducto
         // usuario, clave_Usuario son las variables del modelo en eclipse mismo nombre
       };
       const response = await fetch("http://localhost:8080/saveProducto", {
         //aqui envia la inf
         method: "POST", // *GET, POST, PUT, DELETE, etc.
         mode: "cors", // no-cors, *cors, same-origin
         headers: {
           "Content-Type": "application/json",
         },
         body: JSON.stringify(clienteCompleto), // body data type must match "Content-Type" header
       });
       const respuesta = await response.json();
 
       if (respuesta) {
         MySwal.fire(
           "Producto agregado",
           "El  producto se agrego exitosamente",
           "success"
         );
 
         navigate("/producto");
       } else {
         MySwal.fire(
           "Datos Incompletos",
           "Por favor complete todos los campos",
           "error"
         );
       }
     
     }
   };
 
  return (
    <>
      <div className="flex">
        <Menu></Menu>
        <div className="anchoMenu">
          <form>
            <div className="ProductoTitulo">
              <h1>Formulario - Ingresar Productos</h1>
            </div>
            <div className="Contenido_Productos">
              <div className="Contenido_Productos_div">
                <div className="Contenido_Productos_cuadros">
                  <label for="Codigo"> Codigo </label>{" "}
                  <input
                    id="codigo_Productos"
                    type="text"
                    name="codigo_Producto"
                    placeholder="Digite el codigo"
                  />
                  <br />
                </div>

                <div className="Contenido_Productos_cuadros">
                  <label for="Nombre"> Producto </label>{" "}
                  <input
                    id="nombre_Productos"
                    type="text"
                    name="nombre_Producto"
                    placeholder="Digite nombre del producto"
                  />
                  <br />
                </div>
              </div>
              <div className="Contenido_Productos_div">
                <div className="Contenido_Productos_cuadros">
                  <label for="Nit_Proveedor"> Nit Proveedor </label>{" "}
                  <input
                    id="nit_Proveedores"
                    type="text"
                    name="nit_Proveedor"
                    placeholder="Digite NIT del proveedor"
                  />
                  <br />
                </div>

                <div className="Contenido_Productos_cuadros">
                  <label for="Costo"> Costo </label>{" "}
                  <input
                    id="precio_Compras"
                    type="text"
                    name="costo"
                    placeholder="Digite el costo"
                  />
                  <br />
                </div>
              </div>

              <div className="Contenido_Productos_div">
                <div className="Contenido_Productos_cuadros">
                  <label for="Iva"> IVA </label>
                  <input
                    id="iva_Productos"
                    type="text"
                    name="iva_Producto"
                    placeholder="Digite valor del IVA"
                  />
                  <br />
                </div>
                <div className="Contenido_Productos_cuadros">
                  <label for="Precio_Venta"> Precio Venta </label>{" "}
                  <input
                    id="precio_Venta_Productos"
                    type="text"
                    name="precio_Venta"
                    placeholder="Digite valor de venta"
                  />
                  <br />
                </div>
              </div>
            </div>
            <div className="botones_Productos">
              <div className="botones_Productos_conte">
                <button
                  type="submit"
                  name="consultar_Productos"
                  class="btn btn-primary btn-lg active"
                  onClick={crearNuevoProducto}
                >
                  Guardar
                </button>
              </div>
            </div>
          </form>

          <div className="row espacioBotonCarga" align="center">
            <h2>Cargar masiva por archivo .csv</h2>
            <form action="" method="post" enctype="">
              <input
                type="file"
                name="file"
                accept=".csv"
                class="btn btn-secondary"
              />
              <input
                type="submit"
                name="btn_archivo"
                value="Cargar archivo csv"
                class="btn btn-primary"
              />
            </form>
          </div>
        </div>
      </div>
    </>
  );
}
export default FormProducto;
