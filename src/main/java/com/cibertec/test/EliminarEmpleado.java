package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;

public class EliminarEmpleado {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		String msg = dao.eliminarEmpleado(2);
		System.out.println(msg);
	}

}
