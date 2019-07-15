package view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import beans.Alumno;
import service.AlumnoService;

@Component
public class PdfView extends AbstractPdfView {

	
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Alumno> alumnos = (List<Alumno>) model.get("Alumnos");

        PdfPTable table = new PdfPTable(5);

        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Father surname");
        table.addCell("Mother surname");
        table.addCell("Email");

        for(Alumno a: alumnos) {
            table.addCell(a.getId_alumno().toString());
            table.addCell(a.getNombre());
            table.addCell(a.getApe_paterno());
            table.addCell(a.getApe_materno());
            table.addCell(a.getEmail());
        }

        document.add(table);
    }


	

}