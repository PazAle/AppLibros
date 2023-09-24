package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.libro.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorLibro {

    private ServicioLibro servicioLibro;

    @Autowired
    public ControladorLibro(ServicioLibro servicioLibro){
        this.servicioLibro = servicioLibro;
    }

    @RequestMapping(path = "/home")
    public ModelAndView homeLibro(){
        return null;
    }
}
