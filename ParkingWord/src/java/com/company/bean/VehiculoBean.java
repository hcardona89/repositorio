/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.bean;

import com.mycompany.entity.Vehiculo;
import com.mycompany.sessionBeanDao.VehiculoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author harry
 */
@ManagedBean
@SessionScoped
public class VehiculoBean implements Serializable {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    
    private List <Vehiculo> listaVehiculo;
    
    public VehiculoBean() {    
        
    }

    public List<Vehiculo> getListaVehiculo() {
        
        listaVehiculo=vehiculoFacade.findAll();
        return listaVehiculo;
    }
    
    
    
}
