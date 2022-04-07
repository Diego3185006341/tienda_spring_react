import "./cliente.css";
import Menu from "../Menu/Menu";

function Cliente() {
  return (
    <div className="flex">
      <Menu></Menu>
      <div className="anchoMenu">
        <div className="ClienteTabla">
          <div class="ClienteTitulo">
            <h1>Lista de Clientes</h1>
          </div>

          <table class="ClienteTablaAncho table table-striped mx-auto">
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
            <tbody>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                  <a className="btn btn-outline-primary btn-sm marginButtonUsuario bi bi-pencil-fill"></a>
                  <a className="btn btn-danger btn-sm marginButtonUsuario bi bi-trash "></a>
                </td>
              </tr>
            </tbody>
          </table>
          <div class=" ClienteTablaAncho mx-auto">
            <a href="/formCliente" className="btn btn-primary">
              Nuevo
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Cliente;
