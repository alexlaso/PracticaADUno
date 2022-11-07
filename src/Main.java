import java.io.File;
import java.io.StringReader;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/NBA","root", "");
        con.setAutoCommit(false);
        apartadoUno(con);
        //apartadoDos(con);
        segundoEjercicio(con);
    }

    private static void apartadoUno(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM equipos");
        while (rs.next()){
            System.out.println(rs.getString("Nombre")+" - " + rs.getString("Ciudad")+ " - " + rs.getString("Conferencia")+ " - " + rs.getString("Division"));
        }
        ResultSet rsJugadores = stmt.executeQuery("SELECT * FROM jugadores");
        while (rsJugadores.next()){
            System.out.println(rsJugadores.getString("Codigo")+ " - " + rsJugadores.getString("Nombre")+ " - " + rsJugadores.getString("Procedencia")+ " - " + rsJugadores.getString("Altura")+ " - " + rsJugadores.getString("Peso")+ " - " + rsJugadores.getString("Posicion")+ " - " + rsJugadores.getString("NombreEquipo"));
        }
        stmt.close();
    }

    /*private static void apartadoDos(Connection con) throws SQLException {
        String nombreEquipoBusqueda;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo que quieres buscar");
        nombreEquipoBusqueda = sc.next();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM jugadores WHERE NombreEquipo = '"+nombreEquipoBusqueda+"'");
        while (rs.next()){
            System.out.println(rs.getString("Codigo")+ " - " + rs.getString("Nombre")+ " - " + rs.getString("Procedencia")+ " - " + rs.getString("Altura")+ " - " + rs.getString("Peso")+ " - " + rs.getString("Posicion")+ " - " + rs.getString("NombreEquipo"));
        }
    }*/

    private static void segundoEjercicio(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String query = "INSERT INTO jugadores VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        PreparedStatement psDos = con.prepareStatement(query);
        Statement st = con.createStatement();
        int id,  peso, idDos,  pesoDos;
        String nombre, procedencia, altura, posicion, nombreEquipo, nombreDos, procedenciaDos, alturaDos, posicionDos, nombreEquipoDos;
        System.out.println("Introduce el id del primer jugador a importar");
        id = sc.nextInt();
        ps.setInt(1, id);
        System.out.println("Introduce el nombre del primer jugador a importar");
        nombre = sc.next();
        ps.setString(2, nombre);
        System.out.println("Introduce la procedencia del primer jugador a importar");
        procedencia = sc.next();
        ps.setString(3,procedencia);
        System.out.println("Introduce la altura del primer jugador a importar");
        altura = sc.next();
        ps.setString(4,altura);
        System.out.println("Introduce el peso del primer jugador a importar");
        peso = sc.nextInt();
        ps.setInt(5,peso);
        System.out.println("Introduce la posición del primer jugador a importar");
        posicion = sc.next();
        ps.setString(6,posicion);
        System.out.println("Introduce el equipo del primer jugador a importar");
        nombreEquipo = sc.next();
        ps.setString(7,nombreEquipo);
        ps.executeUpdate();
        /*st.executeUpdate("INSERT INTO jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) VALUES ('"+id+"','"+ nombre+"','"+ procedencia+"','"+altura+"','"+peso+"','"+posicion+"','"+ nombreEquipo+"');");*/

        System.out.println("Introduce el id del segundo jugador a importar");
        idDos = sc.nextInt();
        psDos.setInt(1,idDos);
        System.out.println("Introduce el nombre del segundo jugador a importar");
        nombreDos = sc.next();
        psDos.setString(2,nombreDos);
        System.out.println("Introduce la procedencia del segundo jugador a importar");
        procedenciaDos = sc.next();
        psDos.setString(3,procedenciaDos);
        System.out.println("Introduce la altura del segundo jugador a importar");
        alturaDos = sc.next();
        psDos.setString(4,alturaDos);
        System.out.println("Introduce el peso del segundo jugador a importar");
        pesoDos = sc.nextInt();
        psDos.setInt(5,pesoDos);
        System.out.println("Introduce la posición del segundo jugador a importar");
        posicionDos = sc.next();
        psDos.setString(6,posicionDos);
        System.out.println("Introduce el equipo del segundo jugador a importar");
        nombreEquipoDos = sc.next();
        psDos.setString(7,nombreEquipoDos);
        psDos.executeUpdate();
        /*st.executeUpdate("INSERT INTO jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombreEquipo) VALUES ('"+idDos+"','"+ nombreDos+"','"+ procedenciaDos+"','"+alturaDos+"','"+pesoDos+"','"+posicionDos+"','"+ nombreEquipoDos+"');");*/
        st.close();
        ps.close();
        psDos.close();
    }
}