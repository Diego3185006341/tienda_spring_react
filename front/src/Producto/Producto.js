import "./producto.css";
import Menu from "../Menu/Menu";

function Producto() {
  return (
    <>
      <div className="flex">
        <Menu></Menu>
        <div className="anchoMenu">
          <div className="ProductoTabla">
            <div class="ProductoTitulo">
              <h1>Lista de Productos</h1>
            </div>
            <table class="ProductoAnchoTabla table table-striped mx-auto">
              <thead>
                <tr>
                  <th>CODIGO</th>
                  <th>NOMBRE</th>
                  <th>PROVEEDOR</th>
                  <th>COSTO</th>
                  <th>IVA</th>
                  <th>PRECIO VENTA</th>
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
                  <td></td>
                  <td>
                    <a class="btn btn-outline-primary btn-sm marginButtonUsuario bi bi-pencil-fill"></a>
                    <a class="btn btn-danger btn-sm marginButtonUsuario bi bi-trash">
                      {" "}
                    </a>
                  </td>
                </tr>
              </tbody>
            </table>
            <div class="ProductoAnchoTabla mx-auto">
              <a href="formProducto" class="btn btn-primary">
                Nuevo
              </a>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Producto;
