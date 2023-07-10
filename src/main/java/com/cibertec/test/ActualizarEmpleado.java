package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class ActualizarEmpleado {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		Empleado x = new Empleado(1, "Donie", "Luperdi", "85850101");
		String msg = dao.actualizarEmpleado(x);
		System.out.println(msg);
	}

}
