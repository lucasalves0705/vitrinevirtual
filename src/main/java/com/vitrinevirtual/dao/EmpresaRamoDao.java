package com.vitrinevirtual.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vitrinevirtual.Entidades.Avaliacao;
import com.vitrinevirtual.Entidades.EmpresaRamo;

@Repository
public class EmpresaRamoDao extends AbstractDao<EmpresaRamo, Integer> implements IEmpresaRamoDao {

	@Transactional
	public void deletarPorEmpresa(Integer empresaid) {
		List<EmpresaRamo> empresaramo =  super.createQuery("select i from EmpresaRamo as i where i.empresa = "+ empresaid);
		
		for (int i=0; i < empresaramo.size(); i++) {
			delete(empresaramo.get(i).getId());
		}
	}
	
	public List<EmpresaRamo> findPorEmpresa(Integer empresaid) {
		List<EmpresaRamo> empresaramo =  super.createQuery("select i from EmpresaRamo as i where i.empresa = "+ empresaid);
		return empresaramo;
	}
	
}
