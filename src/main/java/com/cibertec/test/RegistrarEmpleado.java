package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class RegistrarEmpleado {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		Empleado x = new Empleado(0, "Carla", "Castillo", "15986328");
		String msg = dao.registrarEmpleado(x);
		System.out.println(msg);
	}
}
