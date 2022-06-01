import "./cliente.css";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Menu from "../Menu/Menu";
import withReactContent from "sweetalert2-react-content";
import Swal from "sweetalert2";

function Cliente() {
  const [infoClientes, modificarInfoClientes] = useState([]); //useState sirve para renderizar al notar un cambio
  const navigate = useNavigate();
  const MySwal = withReactContent(Swal);

  useEffect(() => {
    cargarClientes();
  }, []);

  function FormCliente() {
    navigate("/formCliente");
  }

  const cargarClientes = async () => {
    const response = await fetch("http://localhost:8080/listarCliente");
    const data = await response.json();
    modificarInfoClientes(data);
  };

  const eliminarCliente = async (cedula) => {
    MySwal.fire({
      title: "Seguro que quieres eliminar el cliente?",
      showDenyButton: true,
      showCancelButton: false,
      confirmButtonText: "Si",
      denyButtonText: `No`,
    }).then ( async(result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        const response = await fetch(
          "http://localhost:8080/eliminarCliente/" + cedula,
          {
            method: "DELETE",
            mode: "cors",
            headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin": "http://localhost:3000",
            },
          }
        );
        const respuesta = await response.json();
        if (respuesta) {
          const foundCliente = infoClientes.filter(
            (element) => element.cedula_Cliente !== cedula
          );
          modificarInfoClientes(foundCliente);
        }

        MySwal.fire("Eliminado!", "", "success");
      } else if (result.isDenied) {
        
      }
    });
  };

  const redireccionForCliente = (cedula) => {
    navigate("/formCliente/"+cedula);
  }
  const generarTabla = () => {
    return infoClientes.map((element) => (
      <tr key={element.cedula_Cliente}>
        <td> {element.cedula_Cliente} </td>
        <td> {element.nombre_Cliente} </td>
        <td> {element.correo_Cliente} </td>
        <td> {element.direccion_Cliente} </td>
        <td> {element.telefono_Cliente} </td>
        <td>
          <button 
          className="btn btn-outline-primary btn-sm marginButtonUsuario bi bi-pencil-fill"
          onClick={(e) => redireccionForCliente (element.cedula_Cliente) }
          ></button>
          <button
            className="btn btn-danger btn-sm marginButtonUsuario bi bi-trash "
            onClick={(e) => eliminarCliente(element.cedula_Cliente)}
          ></button>
        </td>
      </tr>
    ));
  };
  return (
    <div className="flex">
    <Menu></Menu>
    <div className="anchoMenu">
      <div className="UsuarioTabla">
        <div className="UsuarioTitulo">
          <h1>Lista de Clientes</h1>
        </div>

        <table className="UsuarioTablaAncho table table-striped mx-auto">
          <thead>
            <tr>
              <th>CEDULA</th>
              <th>NOMBRE</th>
              <th>CORREO</th>
              <th>DIRECCION</th>
              <th>TELEFONO</th>
              <th>ACCIONES</th>
            </tr>
          </thead>
          <tbody>{generarTabla()}</tbody>
        </table>
        <div className="UsuarioTablaAncho mx-auto">
          <a>
            <button className="btn btn-primary" onClick={FormCliente}>
              Nuevo
            </button>
          </a>
        </div>
      </div>
    </div>
  </div>

  );
}
export default Cliente;
