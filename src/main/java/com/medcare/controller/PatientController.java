package com.medcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.medcare.model.PatientDetailsModel;
import com.medcare.service.PatientCountServiceI;
import com.medcare.service.PatientCountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/patient")
public class PatientController {

    @Autowired
    PatientCountServiceI patientCountService;
    HttpSession currentSession;

    @RequestMapping(value="/count",method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> forForm(HttpServletRequest request)
    {
        return patientCountService.totalCount();

    }


    @RequestMapping(value="/opdList",method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> opdList(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        if(request!=null)
        {
            currentSession=request.getSession();
            Integer id= (Integer) currentSession.getAttribute("user");
            map =  patientCountService.opdPatients(id);
            return map;
        }
        else {
            return null;
        }
    }

    @RequestMapping(value="/admitList",method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> admitList(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        if(request!=null) {
            currentSession=request.getSession();
            Integer id= (Integer) currentSession.getAttribute("user");
            map =  patientCountService.admitPatients(id);
            return map;
        }
        else {
            return null;
        }
    }
}