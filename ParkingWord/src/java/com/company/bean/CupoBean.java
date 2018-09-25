/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.bean;

import com.mycompany.entity.Cupo;
import com.mycompany.entity.MedidasCupo;
import com.mycompany.entity.PisoCupo;
import com.mycompany.entity.TipoCupo;
import com.mycompany.entity.Vehiculo;
import com.mycompany.sessionBeanDao.CupoFacadeLocal;
import com.mycompany.sessionBeanDao.MedidasCupoFacadeLocal;
import com.mycompany.sessionBeanDao.PisoCupoFacadeLocal;
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
public class CupoBean implements Serializable {

    @EJB
    private CupoFacadeLocal cupoFacade;
    @EJB
    private TipoCupoFacadeLocal tipoCupoFacade;    
    @EJB
    private PisoCupoFacadeLocal pisoCupoFacade;    
    @EJB
    private MedidasCupoFacadeLocal medidasCupoFacade;
    
    private Cupo cupo;
   
    private TipoCupo tipoCupo;
    
    private PisoCupo pisoCupo;
    
    private MedidasCupo medidasCupo;
    
    private List<Cupo> listaCupo;

    public CupoBean() {
        cupo=new Cupo();
        tipoCupo=new TipoCupo();
        pisoCupo=new PisoCupo();
        medidasCupo=new MedidasCupo();
        
    }
    

    public MedidasCupo getMedidasCupo() {
        return medidasCupo;
    }

    public void setMedidasCupo(MedidasCupo medidasCupo) {
        this.medidasCupo = medidasCupo;
    }
    
    public PisoCupo getPisoCupo() {
        return pisoCupo;
    }

    public void setPisoCupo(PisoCupo pisoCupo) {
        this.pisoCupo = pisoCupo;
    }

    
    public TipoCupo getTipoCupo() {
        return tipoCupo;
    }

    public void setTipoCupo(TipoCupo tipoCupo) {
        this.tipoCupo = tipoCupo;
    }
    
    
    public Cupo getCupo() {
        return cupo;
    }

    public void setCupo(Cupo cupo) {
        this.cupo = cupo;
    }

    
    public List<Cupo> getListaCupo() {

        listaCupo = cupoFacade.findAll();
        return listaCupo;

    }

    public String validaSaveOrUpdate(){
        if (cupo.getIdCupo() == null) {
            cupo.setIdCupo(0);
        }
        if (cupoFacade.find(cupo.getIdCupo()) != null) {
            cupo.setIdTipoCupo(tipoCupoFacade.find(tipoCupo.getIdTipoCupo()));
            cupo.setIdPisoCupo(pisoCupoFacade.find(pisoCupo.getIdPisoCupo()));
            cupo.setIdMedidasCupo(medidasCupoFacade.find(medidasCupo.getIdMedidasCupo()));
            cupoFacade.create(cupo);
        }else{
            cupo.setIdTipoCupo(tipoCupoFacade.find(tipoCupo.getIdTipoCupo()));
            cupo.setIdPisoCupo(pisoCupoFacade.find(pisoCupo.getIdPisoCupo()));
            cupo.setIdMedidasCupo(medidasCupoFacade.find(medidasCupo.getIdMedidasCupo()));
            cupoFacade.edit(cupo);
        }
        
        return "Cupo.xhtml";
    }
    
}
