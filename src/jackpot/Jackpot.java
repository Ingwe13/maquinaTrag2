package jackpot;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Jackpot {

    private int[] resultado = new int[3];
    private float saldo = 0;
    private float deposito = 1000;
    private final float VALOR_APUESTA = 0.50F;
    private final int CEREZA = 0;
    private final int CAMPANA = 1;
    private final int TREBOL = 2;
    private final int MONEDA = 3;
    private final int SIETE = 4;
    private Node documento;
    private Node almacen;

    public float jugar() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            resultado[i] = random.nextInt(5);
        }
        saldo -= VALOR_APUESTA;
        float premio = getPremio();
        saldo += premio;
        return premio;
    }

    public ImageIcon getImagen(int indice) {
        try {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/" + resultado[indice] + ".png"));
            return imagen;
        } catch (NullPointerException ex) {
            Logger.getLogger(Jackpot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private int getPremio() {
        if (resultado[0] == CEREZA && resultado[1] == CEREZA) {
            return 5;
        } else if (resultado[0] == CEREZA) {
            return 1;
        } else if (resultado[0] == CAMPANA && resultado[1] == CAMPANA && resultado[2] == CAMPANA) {
            return 10;
        } else if (resultado[0] == CAMPANA && resultado[1] == CAMPANA && resultado[2] == SIETE) {
            return 10;
        } else if (resultado[0] == TREBOL && resultado[1] == TREBOL && resultado[2] == TREBOL) {
            return 15;
        } else if (resultado[0] == TREBOL && resultado[1] == TREBOL && resultado[2] == SIETE) {
            return 15;
        } else if (resultado[0] == MONEDA && resultado[1] == MONEDA && resultado[2] == MONEDA) {
            return 20;
        } else if (resultado[0] == MONEDA && resultado[1] == MONEDA && resultado[2] == SIETE) {
            return 20;
        } else if (resultado[0] == SIETE && resultado[1] == SIETE && resultado[2] == SIETE) {
            return 100;
        } else {
            return 0;
        }
    }

    public void introducirMoneda(float valor) {
        this.saldo += valor;
        deposito += valor;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getDeposito() {
        return deposito;
    }

    public void cobrar() {
        deposito -= saldo;
        saldo = 0;
    }
//    TransformerFactory fábricaTransformador = TransformerFactory.newInstance();
//    Transformer transformador = fábricaTransformador.newTransformer();
//    Source origen = new DOMSource(almacen);
//    
//    Result destino = new StreamResult("almacen.xml");
//    transformador.transform(almacen.xml);
///*--------------------------------------------------------------------------*/    
//        DocumentBuilderFactory fábricaDocumento = DocumentBuilderFactory.newInstance();
//        DocumentBuilder creadorDocumento = fábricaDocumento.newDocumentBuilder();
//        DocumentBuilder crearDocumento = fábricaDocumento.newDocumentBuilder();
//        //Crear un nuevo documento XML
//        Document almacen = (Document) crearDocumento.newDocument();
//        //Crear el nodo raíz y colgarlo del documento
//        Element elementoRaiz = almacen.createElement("almacen");
//
//        almacen.appendChild (elementoRaiz);
//        Element elementoFechaYHora = almacen.createElement("Fecha y Hora");
//
//        almacen.appendChild (elementoEmpleado);
//        Element elementoSaldo = almacen.createElement("Saldo");
//
//        almacen.appendChild (elementoSaldo);
//        Element elementDeposito = almacen.createElement("Deposito");
//
//        almacen.appendChild (elementoDeposito);
//        Element elementoPremio = almacen.createElement("Premio");
//   

}
