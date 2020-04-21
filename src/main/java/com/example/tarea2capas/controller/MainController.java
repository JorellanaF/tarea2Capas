package com.example.tarea2capas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Controller
public class MainController {

    @RequestMapping("/alumno")
    public @ResponseBody String mostrarInf(){
        String info = "Jorge Orellana 00103717 Ingenieria Informatica Cuarto Anio";

        return info;
    }

    @RequestMapping("/parametro")
    public @ResponseBody String parametroDia(HttpServletRequest req) {

        String dia = req.getParameter("dia");
        String mes = req.getParameter("mes");
        String anio = req.getParameter("anio");

        String pFecha = String.format("%s/%s/%s", dia, mes, anio);
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(pFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        String diaSemana = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
        return diaSemana;
    }

}
