package com.cibertec.dao.impl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRUD");
	EntityManager manager = factory.createEntityManager();
	private static final String OPERACION_OK = "Operación realizada correctamente: ";
	private static final String OPERACION_ERROR = "NO se pudo realizar la operación: ";

	public Empleado buscarEmpleado(int id) {
		return manager.find(Empleado.class, id);
	}

	public String registrarEmpleado(Empleado empleado) {
		String msg = OPERACION_ERROR + "registrarEmpleado";
		if(!Objects.isNull(empleado)) {
			manager.getTransaction().begin();
			manager.persist(empleado);
			manager.getTransaction().commit();
			manager.close();
			msg = OPERACION_OK + "registrarEmpleado";
		}
		return msg;
	}

	public String actualizarEmpleado(Empleado empleado) {
		String msg = OPERACION_ERROR + "actualizarEmpleado";
		Empleado emp = buscarEmpleado(empleado.getId());
		if(!Objects.isNull(emp)) {
			manager.getTransaction().begin();
			emp.setNombre(empleado.getNombre());
			emp.setApellido(empleado.getApellido());
			emp.setDni(empleado.getDni());
			manager.getTransaction().commit();
			manager.close();
			msg = OPERACION_OK + "actualizarEmpleado";
		}
		return msg;
	}

	public String eliminarEmpleado(int id) {
		String msg = OPERACION_ERROR + "eliminarEmpleado";
		Empleado emp = buscarEmpleado(id);
		if(!Objects.isNull(emp)) {
			manager.getTransaction().begin();
			manager.remove(emp);
			manager.getTransaction().commit();
			manager.close();
			msg = OPERACION_OK + "eliminarEmpleado";
		}
		return msg;
	}

	public List<Empleado> listarEmpleado() {
		CriteriaBuilder crtBld = manager.getCriteriaBuilder();
		CriteriaQuery<Empleado> crtQry = crtBld.createQuery(Empleado.class);
		Root<Empleado> registro = crtQry.from(Empleado.class);
		CriteriaQuery<Empleado> res = crtQry.select(registro);
		TypedQuery<Empleado> listado = manager.createQuery(res);
		return listado.getResultList();
	}

}
