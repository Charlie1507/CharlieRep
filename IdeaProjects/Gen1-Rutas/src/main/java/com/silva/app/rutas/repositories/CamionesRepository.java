package com.silva.app.rutas.repositories;

import com.silva.app.rutas.models.Camion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CamionesRepository implements IRepository<Camion>
{
    private Connection conn;

    public CamionesRepository(Connection conn)
    {
        this.conn=conn;
    }
    @Override
    public List<Camion> listar() throws SQLException
    {
        List<Camion> camiones = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CAMIONES"))
        {
            while(rs.next())
            {
                Camion a = this.getCamion(rs);
                camiones.add(a);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return camiones;
    }

    @Override
    public Camion getById(Long id) throws SQLException
    {
        Camion camion = null;
        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM camiones WHERE ID_CAMION = ?"))
        {
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    camion = this.getCamion(rs);
                }
            }
        }
        return camion;
    }

    @Override
    public void guardar(Camion camion) throws SQLException
    {
        String sql ="";
        if (camion.getId() != null && camion.getId()>0)
        {
            sql = "update camiones set MATRICULA=?, TIPO_CAMION=?, " +
                    " MODELO=?, MARCA=?, CAPACIDAD=?, KILOMETRAJE=?, " +
                    "DISPONIBILIDAD=? where id_camion=?";
        }
        else
        {
            sql = "insert into camiones (ID_CAMION, MATRICULA, TIPO_CAMION, " +
                    " MODELO, MARCA, CAPACIDAD, KILOMETRAJE, DISPONIBILIDAD) " +
                    "values (SEQUENCE1.NEXTVAL,?,?,?,?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            if(camion.getId() != null && camion.getId() > 0)
            {
                stmt.setString(1,camion.getMatricula());
                stmt.setString(2,camion.getTipoCamion());
                stmt.setInt(3,camion.getModelo());
                stmt.setString(4,camion.getMarca());
                stmt.setInt(5,camion.getCapaciad());
                stmt.setFloat(6, camion.getKilometraje());
                stmt.setInt(7, camion.getDisponibilidad() ? 1 : 0);
                stmt.setLong(8,camion.getId());
            }
            else
            {
                stmt.setString(1,camion.getMatricula());
                stmt.setString(2,camion.getTipoCamion());
                stmt.setInt(3,camion.getModelo());
                stmt.setString(4,camion.getMarca());
                stmt.setInt(5,camion.getCapaciad());
                stmt.setFloat(6, camion.getKilometraje());
                stmt.setInt(7, camion.getDisponibilidad() ? 1 : 0);
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException
    {
        String sql = "delete from camiones where id_camion=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Camion getCamion (ResultSet rs) throws SQLException
    {
        Camion a = new Camion();
        a.setId(rs.getLong("ID_CAMION"));
        a.setMatricula(rs.getString("MATRICULA"));
        a.setTipoCamion(rs.getString("tipo_camion"));
        a.setModelo(rs.getInt("modelo"));
        a.setMarca(rs.getString("marca"));
        a.setCapaciad(rs.getInt("capacidad"));
        a.setKilometraje(rs.getFloat("kilometraje"));
        a.setDisponibilidad(rs.getBoolean("DISPONIBILIDAD"));

        return a;
    }
}
