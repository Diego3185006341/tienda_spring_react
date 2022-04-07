import "./ventas.css";
import Menu from "../Menu/Menu";

function Ventas() {
  return (
    <div className="flex">
      <Menu></Menu>
      <div className="anchoMenu">
        <form method="POST">
          <div class="VentasTitulo">
            <h1>Factura</h1>
          </div>
          <div className="Contenido_Ventas_Informacion">
            <table className="tabla_Datos">
              <tr>
                <td>
                  <label>Usuario </label>
                </td>
                <td>
                  <select
                    id="selectUsuario"
                    onchange="completarUsuario()"
                    className="tabla_td_select"
                  >
                    <option value="0">Seleccione el usuario:</option>
                    <option></option>
                  </select>
                </td>

                <td>
                  <input
                    id="inputUsuario"
                    className=" border_input"
                    type="text"
                    name="cedula_Usu_Vta"
                  />
                </td>
              </tr>
              <tr>
                <td>
                  <label>Cliente </label>
                </td>
                <td>
                  <select
                    id="selectCliente"
                    onchange="completarCliente()"
                    className="tabla_td_select"
                  >
                    <option value="0">Seleccione el cliente:</option>
                    <option></option>
                  </select>
                  <input
                    id="nombre_Cli_Vta"
                    name="nombre_Cli_Vta"
                    type="hidden"
                    value=""
                  />
                </td>

                <td>
                  <input
                    id="inputCliente"
                    className=" border_input"
                    type="text"
                    name="cedula_Cli_Vta"
                  />
                </td>
              </tr>
              <tr>
                <td>
                  <label>Fecha y Hora </label>
                </td>
                <td>
                  <input
                    id="FechaActual"
                    type="text"
                    name="datos_Fecha"
                    className=" border_input tabla_td_select"
                  />
                </td>

                <td>
                  <input
                    id="HoraActual"
                    type="text"
                    name="datos_Hora"
                    className=" border_input tabla_td_select"
                  />
                </td>
              </tr>
            </table>

            <table className="tabla_CodigoTotales">
              <tr>
                <td>
                  <label>Factura </label>
                </td>
                <td>
                  <input
                    type="text"
                    name="codigo_Vta"
                    className=" border_input tabla_td_select alignCenter"
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label>Valor Factura </label>
                </td>
                <td>
                  <input
                    id="datoValorFactura"
                    type="text"
                    name=""
                    className=" border_input tabla_td_select alignCenter "
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label>Valor IVA </label>
                </td>
                <td>
                  <input
                    id="datoValorIVA"
                    type="text"
                    name=""
                    className=" border_input tabla_td_select alignCenter"
                  />
                </td>
              </tr>
            </table>
          </div>

          <div className="Contenido_Ventas_Factura">
            <table className="tabla_Factura ">
              <tr>
                <th className="bordes_Tabla color_Gris">Cod. Producto</th>
                <th className="bordes_Tabla color_Gris">Nombre Producto</th>
                <th className="bordes_Tabla color_Gris">Precio Venta</th>
                <th className="bordes_Tabla color_Gris">Cantidad</th>
                <th className="bordes_Tabla color_Gris">Vlr. Total</th>
                <th></th>
              </tr>

              <tr>
                <td className="bordes_Tabla">
                  <input
                    id="inputProducto1"
                    type="text"
                    name="cod_Producto"
                    className=" border_input"
                    disabled="disabled"
                  />
                </td>

                <td className="bordes_Tabla">
                  <select
                    id="selectProducto1"
                    onchange="completarProducto1()"
                    className="tabla_td_select"
                  >
                    <option value="0">Seleccione el producto:</option>
                    <option></option>
                  </select>
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="precio_SinIVA1"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="precio_SinIVA"
                    disabled="disabled"
                  />
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="cantidadProducto1"
                    onchange="hallarValorTotalSinIVA1()"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="cantidad"
                  />
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="inputTotalSinIVA1"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="valor_sinIVA"
                  />
                </td>

                <td className="alignCenter">
                  <button
                    type="button"
                    onclick="eliminarFilaProducto1()"
                    className="btn btn-danger btn-sm bi bi-trash "
                  >
                    
                  </button>
                </td>
              </tr>

              <tr>
                <td className="bordes_Tabla">
                  <input
                    id="inputProducto2"
                    type="text"
                    name="cod_Producto"
                    className=" border_input"
                    disabled="disabled"
                  />
                </td>

                <td className="bordes_Tabla">
                  <select
                    id="selectProducto2"
                    onchange="completarProducto2()"
                    className="tabla_td_select"
                  >
                    <option value="0">Seleccione el producto:</option>
                    <option></option>
                  </select>
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="precio_SinIVA2"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="precio_SinIVA"
                    disabled="disabled"
                  />
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="cantidadProducto2"
                    onchange="hallarValorTotalSinIVA2()"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="cantidad"
                  />
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="inputTotalSinIVA2"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="valor_sinIVA"
                  />
                </td>

                <td className="alignCenter">
                  <button
                    type="button"
                    onclick="eliminarFilaProducto2()"
                    className="btn btn-danger btn-sm bi bi-trash "
                  >
                    
                  </button>
                </td>
              </tr>

              <tr>
                <td className="bordes_Tabla">
                  <input
                    id="inputProducto3"
                    type="text"
                    name="cod_Producto"
                    className=" border_input"
                    disabled="disabled"
                  />
                </td>

                <td className="bordes_Tabla">
                  <select
                    id="selectProducto3"
                    onchange="completarProducto3()"
                    className="tabla_td_select"
                  >
                    <option value="0">Seleccione el producto:</option>
                    <option></option>
                  </select>
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="precio_SinIVA3"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="precio_SinIVA"
                    disabled="disabled"
                  />
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="cantidadProducto3"
                    onchange="hallarValorTotalSinIVA3()"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="cantidad"
                  />
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="inputTotalSinIVA3"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="valor_sinIVA"
                  />
                </td>

                <td className="alignCenter">
                  <button
                    type="button"
                    onclick="eliminarFilaProducto3()"
                    className="btn btn-danger btn-sm bi bi-trash "
                  >
                    
                  </button>
                </td>
              </tr>

              <tr>
                <td rowspan="3 " colspan="3"></td>

                <td className="bordes_Tabla">
                  <label className="padding-left" for="sub_Total_Factura">
                    {" "}
                    Sub. Total Factura{" "}
                  </label>
                </td>

                <td className="bordes_Tabla">
                  <input
                    id="inputSubTotalSinIVA"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="valor_Vta"
                  />
                </td>
                <td></td>
              </tr>
              <tr>
                <td className="bordes_Tabla">
                  <label className="padding-left" for="valor_IVA">
                    {" "}
                    Valor IVA{" "}
                  </label>
                </td>
                <td className="bordes_Tabla">
                  <input
                    id="inputValorIVA"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="valor_IVA"
                  />
                </td>
                <td></td>
              </tr>
              <tr>
                <td className="bordes_Tabla">
                  <label className="padding-left" for="total_Factura">
                    {" "}
                    Total Factura{" "}
                  </label>
                </td>
                <td className="bordes_Tabla">
                  <input
                    id="inputValorTotalFactura"
                    className=" border_input tabla_td_select select_Producto"
                    type="text"
                    name="valor_Total"
                  />
                </td>

                <td className="alignCenter">
                  <button type="submit" name="consultar_Usuarios">
                    {" "}
                    Facturar{" "}
                  </button>
                </td>
              </tr>
            </table>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Ventas;
