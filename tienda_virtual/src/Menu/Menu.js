import './menu.css';
function Menu() {
  return (
    <div className="menu_Contenedor">
      <div className="menu_Contenedor_Titulo login_Contenedor">
        <h1>Tienda Generica</h1>
      </div>

      <div className="menu_Contenedor_Menu">
       <a href="/Inicio" className="bi-house">Inicio </a>
        <a href="/Usuario" className="bi-people ">Usuarios </a>
        <a href="/Cliente"className="bi-person-check">Clientes </a>
        <a href="/Proveedor" className="bi-building">Proveedores </a>
        <a href="/Producto"className="bi-grid">Productos </a>
        <a href="/Ventas" className="bi-bag-check">Ventas </a>
        <a href="/Reportes" className="bi-card-checklist">Reportes </a>
        <a href="/" className="bi-door-closed">Cerrar Sesion </a>
      </div>
    </div>
  );
}

export default Menu;
