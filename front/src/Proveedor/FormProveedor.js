import "./proveedor.css";
import Menu from "../Menu/Menu";

function FormProveedor() {
  return (
    <div className="flex">
      <Menu></Menu>
      <div className="anchoMenu">
        <form>
          <div className="UsuarioTitulo">
            <h1>Formulario - Ingresar Proveedor</h1>
          </div>
          <div className="Contenido_Proveedores">
            <div className="Contenido_Proveedores_div">
              <div className="Contenido_Proveedores_cuadros">
                <label for="nit"> NIT </label>
                <input
                  type="text"
                  name="nit_Proveedores"
                  placeholder="Digite el NIT"
                />
                <br />
              </div>

              <div className="Contenido_Proveedores_cuadros">
                <label for="Telefono"> Telefono </label>
                <input
                  type="text"
                  name="telefono_Proveedores"
                  placeholder="Digite el telefono"
                />
                <br />
              </div>
            </div>
            <div className="Contenido_Proveedores_div">
              <div className="Contenido_Proveedores_cuadros">
                <label for="Nombre"> Nombre Proveedor </label>
                <input
                  type="text"
                  name="nombre__Proveedores"
                  placeholder="Digite el nombre"
                />
                <br />
              </div>

              <div className="Contenido_Proveedores_cuadros">
                <label for="Ciudad"> Ciudad </label>
                <input
                  type="text"
                  name="ciudad_Proveedores"
                  placeholder="Digite la ciudad"
                />
                <br />
              </div>
            </div>

            <div className="Contenido_Proveedores_div">
              <div className="Contenido_Proveedores_cuadros">
                <label for="Dirección"> Dirección </label>
                <input
                  type="text"
                  name="direccion_Proveedores"
                  placeholder="Digite la direccion"
                />
                <br />
              </div>
            </div>
          </div>
          <div className="botones_Proveedores">
            <div className="botones_Proveedores_conte">
              <button
                type="submit"
                name="consultar_Proveedores"
                class="btn btn-primary btn-lg active"
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
export default FormProveedor;
