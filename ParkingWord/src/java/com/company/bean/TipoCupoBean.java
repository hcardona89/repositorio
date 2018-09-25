/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.bean;

import com.mycompany.entity.TipoCupo;
import com.mycompany.sessionBeanDao.TipoCupoFacade;
import com.mycompany.sessionBeanDao.TipoCupoFacadeLocal;
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
public class TipoCupoBean implements Serializable {

    @EJB
    private TipoCupoFacadeLocal tipoCupoFacade;
    private List<TipoCupo> listaTipoCupo;
    
    /**
     * Creates a new instance of TipoCupoBean
     */
    public TipoCupoBean() {
    }
    
    public List<TipoCupo>getListaTipoCupo (){
        listaTipoCupo=tipoCupoFacade.findAll();
        return listaTipoCupo;
        
        
    }
    
}
