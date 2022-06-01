import "./App.css";
import Menu from "./Menu/Menu";
import Inicio from "./Inicio";
import Usuario from "./Usuarios/Usuario";
import FormUsuario from "./Usuarios/FormUsuario";
import FormeditarUsuario from "./Usuarios/FormeditarUsuario";
import Cliente from "./Clientes/Cliente";
import FormCliente from "./Clientes/FormCliente";
import Producto from "./Producto/Producto";
import FormProducto from "./Producto/FormProducto";
import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import FormProveedor from "./Proveedor/FormProveedor";
import Proveedor from "./Proveedor/Proveedor";
import Ventas from "./Ventas/Ventas";
import Reportes from "./Reportes/Reportes";
import VentasPorCliente from "./Reportes/VentasPorCliente";
import Login from "./Login/Login";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/Inicio" element={<Inicio />} />
        <Route path="/Usuario" element={<Usuario />} />
        <Route path="/formUsuario" element={<FormUsuario />} />
        <Route path="/formUsuario/:cedula" element={<FormUsuario />} />
        <Route path="/formeditarUsuario/:cedula" element={<FormeditarUsuario />} />
        <Route path="/Cliente" element={<Cliente />} />
        <Route path="/formCliente" element={<FormCliente />} />
        <Route path="/formCliente/:cedula" element={<FormCliente />} />
        <Route path="/Proveedor" element={<Proveedor />} />
        <Route path="/formProveedor" element={<FormProveedor />} />
        <Route path="/formProveedor/:nit" element={<FormProveedor />} />
        <Route path="/Producto" element={<Producto />} />
        <Route path="/formProducto" element={<FormProducto />} />
        <Route path="/formProducto/:codigo" element={<FormProducto />} />
        <Route path="/Ventas" element={<Ventas />} />
        <Route path="/Reportes" element={<Reportes />} />
        <Route path="/ventasPorCliente" element={<VentasPorCliente />} />
        {/* /* path es la ruta href  y elemnt el nombre del componente*/}
      </Routes>
    </Router>
  );
}

export default App;
