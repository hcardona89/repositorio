/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.bean;

import com.mycompany.entity.PisoCupo;
import com.mycompany.sessionBeanDao.PisoCupoFacade;
import com.mycompany.sessionBeanDao.PisoCupoFacadeLocal;
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
public class PisoCupoBean implements Serializable {

    @EJB
    private PisoCupoFacadeLocal pisoCupoFacade;
    
    private List<PisoCupo> listaPisoCupo;
  
    /**
     * Creates a new instance of PisoCupoBean
     */
    public PisoCupoBean() {
    }
  
    public List<PisoCupo>getListaPisoCupo(){
        listaPisoCupo=pisoCupoFacade.findAll();
        return listaPisoCupo;
        
    }
    
}
