/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.boleto.app.service;

import com.com470.boleto.app.controller.BoletoController;
import com.com470.boleto.app.dao.BoletoDao;
import com.com470.boleto.app.entities.Boleto;
import java.lang.reflect.Array;
import java.util.Date;
import static org.h2.util.New.arrayList;
import static org.hamcrest.CoreMatchers.sameInstance;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author VladimirP11
 */
public class BoletoServiceTest {

    public BoletoServiceTest() {
    }

    @Mock
    private BoletoDao boletoDao;

    @InjectMocks
    BoletoService boletoService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBoleto() {

        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertEquals(boletoService.createBoleto(boleto),boleto);

    }
    
    @Test
    public void testGetBoletoById() {

        Boleto boleto = new Boleto();
        boleto.setBoletoId(1);
        boleto.setNombreDelPasajero("Jorge Perez");
        boleto.setSalida("Sucre");
        boleto.setDestino("Potosi");
        boleto.setFecha(new Date());
        boleto.setEmail("jorge.perez@gmail.com");
        
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        assertEquals(boletoService.getBoletoById(1),boleto);

    }
    
    @Test
    public void testGetAllBoletos() {

        Boleto boleto = new Boleto();
        Iterable<Boleto> r = boletoDao.findAll();
        Mockito.when(boletoDao.findAll()).thenReturn(r);
        assertEquals(boletoService.getAllBoletos(),r);

    }
    
    @Test
    public void testDeleteBoleto() {

        Boleto boleto = new Boleto();
        Runnable mock = mock(Runnable.class);
        Mockito.doNothing().when(boletoDao).delete(1);
        boletoService.deleteBoleto(1);
        

    }
    
    @Test
    public void testUpdateBoleto() {

        Boleto boleto = new Boleto();
        String email = "es@gmail.com";
        Mockito.when(boletoDao.findOne(1)).thenReturn(boleto);
        boleto.setEmail(email);
        Mockito.when(boletoDao.save(boleto)).thenReturn(boleto);
        assertEquals(boletoService.updateBoleto(1, email),boleto);

    }
}
