import "./producto.css";
import Menu from "../Menu/Menu";

function FormProducto() {
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
                    type="text"
                    name="codigo_Producto"
                    placeholder="Digite el codigo"
                  />
                  <br />
                </div>

                <div className="Contenido_Productos_cuadros">
                  <label for="Nombre"> Producto </label>{" "}
                  <input
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
                    type="text"
                    name="nit_Proveedor"
                    placeholder="Digite NIT del proveedor"
                  />
                  <br />
                </div>

                <div className="Contenido_Productos_cuadros">
                  <label for="Costo"> Costo </label>{" "}
                  <input
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
                    type="text"
                    name="iva_Producto"
                    placeholder="Digite valor del IVA"
                  />
                  <br />
                </div>
                <div className="Contenido_Productos_cuadros">
                  <label for="Precio_Venta"> Precio Venta </label>{" "}
                  <input
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
