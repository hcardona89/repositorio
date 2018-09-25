/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.bean;

import com.mycompany.entity.MedidasCupo;
import com.mycompany.sessionBeanDao.MedidasCupoFacade;
import com.mycompany.sessionBeanDao.MedidasCupoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author harry
 */
@ManagedBean
@SessionScoped
public class MedidasCupoBean implements Serializable {

   @EJB
   private MedidasCupoFacadeLocal medidasCupoFacade;
   private List<MedidasCupo> listaMedidasCupo;
   
    
    /**
     * Creates a new instance of MedidasCupoBean
     */
    public MedidasCupoBean() {
    }
   
    public List<MedidasCupo>getListaMedidasCupo (){
        
        listaMedidasCupo=medidasCupoFacade.findAll();
        return listaMedidasCupo;
    }
}
