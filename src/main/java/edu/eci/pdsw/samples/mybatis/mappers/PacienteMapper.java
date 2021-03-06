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
package edu.eci.pdsw.samples.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author hcadavid
 */
public interface PacienteMapper {
    
    /**
     * Cargar un paciente por ID
     * @param id del paciente
     * @param tipoid tipo de id
     * @return 
     */
    public Paciente loadPacienteById(@Param("idPaciente") int id,@Param("tipoIdPaciente") String tipoid);

    /**
     * Insertar un nuevo paciente
     * @param p el objeto paciente
     */
    public void insertPaciente(@Param("paciente")Paciente p);
    
    /**
     * Insertar la consulta asociada a un paciente
     * @param con la nueva consulta
     * @param id el identificador del PACIENTE
     * @param tipoid el tipo de ID del PACIENTE
     */
    public void insertConsulta(@Param("consulta") Consulta con,@Param("idPaciente") int id,@Param ("tipoIdPaciente")String tipoid);
        
}
