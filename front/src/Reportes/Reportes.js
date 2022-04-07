import "./reportes.css";
import Menu from "../Menu/Menu";

function Reportes() {
  return (
    <>
      <div className="flex">
        <Menu></Menu>
        <div className="anchoMenu">
          <div class="ReportesTitulo">
            <h1>Reportes</h1>
          </div>
          <div class="Contenido_Reportes">
            <a class="btn btn-primary FontBotonReporte"> Listado de Usuarios</a>

            <a class="btn btn-primary FontBotonReporte MarginBotonReporte">
              Listado de Clientes
            </a>

            <a
              href="/ventasPorCliente"
              class="btn btn-primary FontBotonReporte"
            >
              Ventas por Cliente
            </a>
          </div>
        </div>
      </div>
    </>
  );
}

export default Reportes;
