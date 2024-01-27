package com.silva.app.p3cams.repositories;

import com.silva.app.p3cams.models.Duenio;
import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.models.Mantenimiento;
import com.silva.app.p3cams.models.Propiedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientosRepository implements IMantenimientorepository {
    private Connection conn;
    public MantenimientosRepository(Connection conn) { this.conn=conn;}

    public Propiedad getPropiedadId (Long id) throws SQLException {
        Propiedad propiedad = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM propiedades WHERE ID_PROPIEDAD = ?"))
        {
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    propiedad = this.getPropiedad(rs);
                }
            }
        }
        return propiedad;
    }

    @Override
    public List<Mantenimiento> listar() throws SQLException
    {
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mantenimientos"))
        {
            while(rs.next())
            {
                Mantenimiento a = this.getMantenimiento(rs);
                mantenimientos.add(a);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return mantenimientos;
    }

    @Override
    public Mantenimiento getById(Long id) throws SQLException
    {
        Mantenimiento mantenimiento = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM mantenimientos WHERE ID_mantenimiento = ?"))
        {
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    mantenimiento = this.getMantenimiento(rs);
                }
            }
        }
        return mantenimiento;
    }

    @Override
    public void guardar(Mantenimiento mantenimiento) throws SQLException
    {
        String sql ="";
        if (mantenimiento.getId() != null && mantenimiento.getId()>0)
        {
            sql = "update mantenimientos set propiedad_id=?, DESCRIPCION=?, " +
                    "costo=?, fecha_reporte=?, estado_finalizado=? " +
                    "where id_mantenimiento=?";
        }
        else
        {
            sql = "insert into mantenimientos (ID_MANTENIMIENTO, PROPIEDAD_ID, DESCRIPCION, COSTO, FECHA_REPORTE, ESTADO_FINALIZADO) " +
                    "values (SEQUENCE_mantenimiento.NEXTVAL,?,?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (mantenimiento.getId() != null && mantenimiento.getId() > 0) {
                stmt.setLong(1, mantenimiento.getPropiedadId());
                stmt.setString(2, mantenimiento.getDescripcion());
                stmt.setFloat(3, mantenimiento.getCosto());
                stmt.setDate(4, Date.valueOf(mantenimiento.getFechaReporte()));
                stmt.setInt(5, mantenimiento.getEstadoFinalizado() ? 1 : 0);
                stmt.setLong(6, mantenimiento.getId());
            } else {
                stmt.setLong(1, mantenimiento.getPropiedadId());
                stmt.setString(2, mantenimiento.getDescripcion());
                stmt.setFloat(3, mantenimiento.getCosto());
                stmt.setDate(4, Date.valueOf(mantenimiento.getFechaReporte()));
                stmt.setInt(5, mantenimiento.getEstadoFinalizado() ? 1 : 0);
            }
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException
    {
        String sql = "delete from mantenimientos where id_mantenimiento=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }


    private Mantenimiento getMantenimiento(ResultSet rs) throws SQLException{
        Mantenimiento  m = new Mantenimiento();
        m.setId(rs.getLong("ID_MANTENIMIENTO"));
        m.setPropiedadId(rs.getLong("PROPIEDAD_ID"));
        m.setDescripcion(rs.getString("DESCRIPCION"));
        m.setCosto(rs.getFloat("COSTO"));
        m.setFechaReporte(rs.getDate("FECHA_REPORTE").toLocalDate());
        m.setEstadoFinalizado(rs.getBoolean("ESTADO_FINALIZADO"));
        return m;
    }
    private Propiedad getPropiedad(ResultSet rs) throws SQLException
    {
        Propiedad a = new Propiedad();
        a.setId(rs.getLong("ID_PROPIEDAD"));
        a.setDireccion(rs.getString("DIRECCION"));
        a.setDuenioId(rs.getLong("DUENIO_ID"));
        a.setDisponibilidad(rs.getBoolean("DISPONIBILIDAD"));
        a.setTipoPropiedad(rs.getString("TIPO_PROPIEDAD"));
        a.setPrecio(rs.getFloat("PRECIO"));

        return a;
    }
}
