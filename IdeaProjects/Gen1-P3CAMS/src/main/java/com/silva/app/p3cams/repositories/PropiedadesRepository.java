package com.silva.app.p3cams.repositories;

import com.silva.app.p3cams.models.Inquilino;
import com.silva.app.p3cams.models.Propiedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropiedadesRepository implements IRepository<Propiedad>
{
    Connection conn;

    public PropiedadesRepository(Connection conn)
    {
        this.conn=conn;
    }

    @Override
    public List<Propiedad> listar() throws SQLException
    {
        List<Propiedad> propiedades = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROPIEDADES"))
        {
            while(rs.next())
            {
                Propiedad a = this.getPropiedad(rs);
                propiedades.add(a);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return propiedades;
    }

    @Override
    public Propiedad getById(Long id) throws SQLException
    {
        Propiedad propiedad = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM propiedades WHERE ID_propiedad = ?"))
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
    public void guardar(Propiedad propiedad) throws SQLException
    {
        String sql ="";
        if (propiedad.getId() != null && propiedad.getId()>0)
        {
            sql = "update propiedades set direccion=?, duenio_id=?, " +
                    "disponibilidad=?, tipo_propiedad=?, precio=? " +
                    "where id_propiedad=?";
        }
        else
        {
            sql = "insert into propiedades (ID_PROPIEDAD, DIRECCION, DUENIO_ID, DISPONIBILIDAD, TIPO_PROPIEDAD, PRECIO) " +
                    "values (SEQUENCE_PROPIEDAD.NEXTVAL,?,?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (propiedad.getId() != null && propiedad.getId() > 0) {
                stmt.setString(1, propiedad.getDireccion());
                stmt.setLong(2, propiedad.getDuenioId());
                stmt.setInt(3, propiedad.getDisponibilidad() ? 1 : 0);
                stmt.setString(4, propiedad.getTipoPropiedad());
                stmt.setFloat(5, propiedad.getPrecio());
                stmt.setLong(6, propiedad.getId());
            } else {
                stmt.setString(1, propiedad.getDireccion());
                stmt.setLong(2, propiedad.getDuenioId());
                stmt.setInt(3, propiedad.getDisponibilidad() ? 1 : 0);
                stmt.setString(4, propiedad.getTipoPropiedad());
                stmt.setFloat(5, propiedad.getPrecio());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException
    {
        String sql = "delete from propiedades where id_propiedad=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
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
