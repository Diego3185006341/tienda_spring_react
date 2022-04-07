import "./cliente.css";
import Menu from "../Menu/Menu";

function FormCliente() {
  return (
    <div className="flex">
      <Menu></Menu>
      <div className="anchoMenu">
        <form>
          <div className="ClienteTitulo">
            <h1>Formulario - Ingresar Cliente</h1>
          </div>
          <div className="Contenido_Clientes">
            <div className="Contenido_Clientes_div">
              <div className="Contenido_Clientes_cuadros">
                <label for="Cédula"> Cédula </label>
                <input
                  type="text"
                  name="cedula_Clientes"
                  placeholder="Digite la cédula"
                />
                <br />
              </div>

              <div className="Contenido_Clientes_cuadros">
                <label for="Telefono"> Telefono </label>
                <input
                  type="text"
                  name="telefono_Clientes"
                  placeholder="Digite el telefono"
                />
                <br />
              </div>
            </div>
            <div className="Contenido_Clientes_div">
              <div className="Contenido_Clientes_cuadros">
                <label for="Nombre_Completo"> Nombre Completo </label>
                <input
                  type="text"
                  name="nombre_Clientes"
                  placeholder="Digite el nombre"
                />
                <br />
              </div>

              <div className="Contenido_Clientes_cuadros">
                <label for="Correo_Electronico"> Correo Electronico </label>
                <input
                  type="text"
                  name="correo_Clientes"
                  placeholder="Digite el correo"
                />
                <br />
              </div>
            </div>

            <div className="Contenido_Clientes_div">
              <div className="Contenido_Clientes_cuadros">
                <label for="Dirección"> Dirección </label>
                <input
                  type="text"
                  name="direccion_Clientes"
                  placeholder="Digite la direccion"
                />
                <br />
              </div>
            </div>
          </div>
          <div class="botones_Clientes">
            <div className="botones_Clientes_conte">
              <button
                type="submit"
                name="consultar_Clientes"
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
export default FormCliente;
