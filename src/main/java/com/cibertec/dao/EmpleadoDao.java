package com.cibertec.dao;

import java.util.List;

import com.cibertec.model.Empleado;

public interface EmpleadoDao {
	public Empleado buscarEmpleado(int id);
	public String registrarEmpleado(Empleado empleado);
	public String actualizarEmpleado(Empleado empleado);
	public String eliminarEmpleado(int id);
	public List<Empleado> listarEmpleado();
}
