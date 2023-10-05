package jdbc.controller1;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import jdbc.dao.ReservaDAO;
import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Reserva;

public class ReservasController {
    private ReservaDAO reservaDAO;

//    public ReservasController() {
//        Connection connection = new ConnectionFactory().recuperarConexion();
//        this.reservaDAO = new ReservaDAO(connection);
//    }

    public void guardar(Reserva reserva) {
        this.reservaDAO.guardar(reserva);
    }

  public List<Reserva> buscar() {
        return this.reservaDAO.buscar();
    }

    public List<Reserva> buscarId(String id) {
        return this.reservaDAO.buscarId(id);
    }

    public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
        this.reservaDAO.Actualizar(fechaE, fechaS, Float.valueOf(valor), formaPago, id);
    }

    public void eliminar(Integer id) {
        this.reservaDAO.Eliminar(id);
    }
}
