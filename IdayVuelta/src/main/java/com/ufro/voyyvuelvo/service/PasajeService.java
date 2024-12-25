package com.ufro.voyyvuelvo.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ufro.voyyvuelvo.model.Pasaje;
import com.ufro.voyyvuelvo.model.Usuario;
import com.ufro.voyyvuelvo.repository.PasajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@Service
public class PasajeService {

    @Autowired
    private PasajeRepository pasajeRepository;

    public Pasaje guardarPasaje(Pasaje pasaje) {
        return pasajeRepository.save(pasaje);
    }

    public List<Pasaje> obtenerPasajesPorUsuario(Usuario usuario) {
        return pasajeRepository.findByUsuario(usuario);
    }

    public File generarPdfPasaje(Pasaje pasaje) {

        File archivoPdf = null;

        try {
            String directorio = "src/main/java/com/ufro/voyyvuelvo/service/pasajes_generados";
            String nombreArchivo = "pasaje-"+ UUID.randomUUID() + ".pdf" ;

            archivoPdf = new File(directorio, nombreArchivo);

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(archivoPdf));

            document.open();

            agregarDetallesAlPdf(document, pasaje);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return archivoPdf;
    }

    private void agregarDetallesAlPdf(Document document, Pasaje pasaje) throws DocumentException {
        document.addTitle("Pasaje Voy y Vuelvo");
        document.add(new Paragraph("Detalles del Pasaje:"));
        document.add(new Paragraph("Titular Pasaje: " + pasaje.getUsuario().getRut()));
        document.add(new Paragraph("Origen: " + pasaje.getAsiento().getViaje().getOrigen()));
        document.add(new Paragraph("Destino: " + pasaje.getAsiento().getViaje().getDestino()));
        document.add(new Paragraph("Fecha Salida: " + pasaje.getAsiento().getViaje().getSalida()));
        document.add(new Paragraph("Asiento Numero: " + pasaje.getAsiento().getNumero()));
    }

}
