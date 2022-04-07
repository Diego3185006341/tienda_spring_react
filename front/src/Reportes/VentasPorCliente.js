import "./reportes.css";
import Menu from "../Menu/Menu";

function VentasPorCliente() {
  return (
    <div className="flex">
      <Menu></Menu>
      <div className="anchoMenu">
        <div>
          <div class="ReportesTitulo">
            <h1>Ventas por Cliente</h1>
          </div>

          <table class=" VentasClientesTablaAncho table table-striped mx-auto">
            <thead>
              <tr>
                <th>CEDULA CLIENTE</th>
                <th>NOMBRE CLIENTE</th>
                <th>VALOR ANTES IVA</th>
                <th>IVA </th>
                <th>VALOR FACTURA</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default VentasPorCliente;
