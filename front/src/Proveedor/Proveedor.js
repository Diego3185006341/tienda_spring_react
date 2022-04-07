import "./proveedor.css";
import Menu from "../Menu/Menu";

function Proveedor() {
  return (
    <>
      <div className="flex">
        <Menu></Menu>
        <div className="anchoMenu">
          <div className="ProveedorTabla">
            <div class="ProveedorTitulo">
              <h1>Lista de Proveedores</h1>
            </div>

            <table class="ProveedorTablaAncho table table-striped mx-auto">
              <thead>
                <tr>
                  <th>NIT</th>
                  <th>NOMBRE</th>
                  <th>DIRECCION</th>
                  <th>CIUDAD</th>
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
                    <a className="btn btn-danger btn-sm marginButtonUsuario bi bi-trash ">
                      {" "}
                    </a>
                  </td>
                </tr>
              </tbody>
            </table>
            <div class="ProveedorTablaAncho mx-auto">
              <a href="/formProveedor" class="btn btn-primary">
                Nuevo
              </a>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Proveedor;
