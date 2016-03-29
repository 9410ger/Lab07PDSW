/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.test;

import static edu.eci.pdsw.samples.textview.MyBatisExample.getSqlSessionFactory;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.eci.pdsw.samples.mybatis.mappers.PacienteMapper;
import java.sql.Date;
import java.util.HashSet;
import java.util.LinkedList;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.Consulta;
import java.util.Set;
import org.junit.Assert;
/**
 *
 * @author hcadavid
 */
public class PersistenceTest {

    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config-h2.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    
    /*@Test
    public void CE1(){
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        
        SqlSession sqlss = sessionfact.openSession();
        PacienteMapper pm= sqlss.getMapper(PacienteMapper.class);
        //Deberia registrar paciente nuevo con mas de una consulta
        Paciente p4 = new Paciente(1234567890,"TI","Pepito Perez",Date.valueOf("1996-07-09"));
        Consulta c5 = new Consulta(Date.valueOf("2009-10-12"),"El paciente tiene fiebre");
        Consulta c6 = new Consulta(Date.valueOf("2009-10-13"),"El paciente sigue con fiebre");
        Set<Consulta> consultas4=new HashSet<>();
        consultas4.add(c5);consultas4.add(c6);
        p4.setConsultas(consultas4);
        pm.insertPaciente(p4);
        for(Consulta c: p4.getConsultas()){
            pm.insertConsulta(c, p4.getId(), p4.getTipo_id());
        }  
    }*/
    
    @Test
    public void CE2(){
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        PacienteMapper pm= sqlss.getMapper(PacienteMapper.class);
        Paciente p = new Paciente(9876, "TI", "Carmenzo", Date.valueOf("1995-07-10"));
        pm.insertPaciente(p);
        sqlss.close();
        Assert.assertEquals(pm.loadPacienteById(p.getId(), p.getTipo_id()).toString(),p.toString());
    }
        
        
    
    
}
