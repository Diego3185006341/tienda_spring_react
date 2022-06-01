import "./cliente.css";
import Menu from "../Menu/Menu";
import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import React, { useEffect } from "react";

function FormCliente() {
    //const navigate = useNavigate();
    const MySwal = withReactContent(Swal);
    const navigate = useNavigate();
  
    let params = useParams(); // captura parameetros de la url { cedula }
  
    const InicializarForm = async () => {
      // validar si hay algo en el parametro cedula
      if (params.cedula) {
        // hacer un get por cedula para traer los datos
        // despues de tener los datos asociales a los input los datos correspondientes
        const response = await fetch(
          "http://localhost:8080/Cliente/" + params.cedula
        );
        const data = await response.json();
        console.log(data);
        document.getElementById("cedula_Clientes").value = data.cedula_Cliente;
        document.getElementById("nombre_Clientes").value = data.nombre_Cliente;
        document.getElementById("correo_Clientes").value = data.correo_Cliente;
        document.getElementById("direccion_Clientes").value = data.direccion_Cliente;
        document.getElementById("telefono_Clientes").value = data.telefono_Cliente;
      }
    };
    useEffect(() => {
      //sirve para ejecutar esa funcion apenas carga o cuando cambia una variable dentro de la funcion
      InicializarForm();
    }, []);
  
    const crearNuevoCliente = async (e) => {
      e.preventDefault();
  
      const cedulaCliente = document.getElementById("cedula_Clientes").value;
      const nombreCliente = document.getElementById("nombre_Clientes").value;
      const correoCliente = document.getElementById("correo_Clientes").value;
      const direccionCliente = document.getElementById("direccion_Clientes").value;
      const telefonoCliente = document.getElementById("telefono_Clientes").value;
  
      if (
        cedulaCliente &&
        nombreCliente &&
        correoCliente &&
        direccionCliente &&
        telefonoCliente
      ) {
        const clienteCompleto = {
          cedula_Cliente: cedulaCliente,
          nombre_Cliente: nombreCliente,
          correo_Cliente: correoCliente,
          direccion_Cliente: direccionCliente,
          telefono_Cliente: telefonoCliente,
          // usuario, clave_Usuario son las variables del modelo en eclipse mismo nombre
        };
        const response = await fetch("http://localhost:8080/saveCliente", {
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
            "Cliente agregado",
            "El el cliente se agrego exitosamente",
            "success"
          );
  
          navigate("/cliente");
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
    <div className="flex">
    <Menu></Menu>
    <div className="anchoMenu">
      <form>
        <div className="UsuarioTitulo">
          <h1>Formulario - Ingresar Clientes</h1>
        </div>
        <div className="Contenido_Usuarios">
          <div className="Contenido_Usuarios_div">
            <div className="Contenido_Usuarios_cuadros">
              <label htmlFor="Cédula"> Cédula </label>
              <input
                id="cedula_Clientes"
                type="text"
                name="cedula_Clientes"
                placeholder="Digite la cédula"
              />
              <br />
            </div>

            <div className="Contenido_Usuarios_cuadros">
              <label htmlFor="Usuario"> Nombre </label>
              <input
                id="nombre_Clientes"
                type="text"
                name="nombre_Clientes"
                placeholder="Digite el nombre"
              />
              <br />
            </div>
          </div>

          <div className="Contenido_Usuarios_div">
            <div className="Contenido_Usuarios_cuadros">
              <label htmlFor="Nombre_Completo"> correo </label>
              <input
                type="text"
                id="correo_Clientes"
                placeholder="Digite el correo"
              />
              <br />
            </div>

            <div className="Contenido_Usuarios_cuadros">
              <label htmlFor="Contraseña"> direccion </label>
              <input
                type="text"
                id="direccion_Clientes"
                placeholder="Digite la direccion"
              />
              <br />
            </div>
          </div>

          <div className="Contenido_Usuarios_div">
            <div className="Contenido_Usuarios_cuadros">
              <label htmlFor="Correo_Electronico">
                {" "}
                telefono {" "}
              </label>
              <input
                type="text"
                id="telefono_Clientes"
                placeholder="Digite el telefono"
              />
              <br />
            </div>
          </div>
        </div>

        <div className="botones_Usuarios">
          <div className="botones_Usuarios_conte">
            <button
              type="submit"
              id="consultar_Usuarios"
              className="btn btn-primary btn-lg active"
              onClick={crearNuevoCliente}
            >
              Guardar
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>

  );
}
export default FormCliente;
